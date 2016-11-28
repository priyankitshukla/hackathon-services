package com.chat.service.hackathon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.service.hackathon.pojo.Data;
import com.chat.service.hackathon.pojo.Facebook;
import com.chat.service.hackathon.pojo.SearchRequest;
import com.chat.service.hackathon.pojo.SearchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class SearchService {
	
	
	@RequestMapping(value="/searchservice", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody SearchResponse getSearchService(@RequestBody SearchRequest searchRequest){
		SearchResponse searchResponse = new SearchResponse();
		try {
			System.out.println("Request received -->"+new ObjectMapper().writeValueAsString(searchRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtils.equalsIgnoreCase("searchFid.com",searchRequest.getResult().getMetadata().getIntentName())){
			System.out.println("Used Product Service --->"+searchRequest.getResult().getParameters().getProduct_service().get(0));
			String url = "https://search.fidelity.com/search/getSearchResults?question="+searchRequest.getResult().getParameters().getProduct_service().get(0);
			try {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(url);
				request.addHeader("User-Agent","Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:49.0) Gecko/20100101 Firefox/49.0");
				HttpResponse response = client.execute(request);
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line);
	
				}
				String resultol = StringUtils
						.substringBetween(
								result.toString(), "<ol>","</ol>");
				Document document = Jsoup.parse(resultol);
				Elements links = document.select("a[href]");
				searchResponse.setSpeech("speech");
				searchResponse.setDisplayText("displayText");
				Data data = new Data();
				data.setSender_action("typing_on");
				for (Element link : links) {
					Facebook facebook = new Facebook();
					facebook.setText(link.text());
					data.setFacebook(facebook);
					//searchResponse.setDisplayText(link.attr("href"));
					break;
				}
				searchResponse.setData(data);
				searchResponse.setSource(searchRequest.getResult().getMetadata().getIntentName());
			} catch (Exception exception) {
				exception.printStackTrace();
			}			
		}
		return searchResponse;
	}
	public static void main(String[] args){
		SpringApplication.run(SearchService.class, args);
	}
}

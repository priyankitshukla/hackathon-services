package com.chat.service.hackathon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

import com.chat.service.hackathon.pojo.Facebook;
import com.chat.service.hackathon.pojo.SearchRequest;
import com.chat.service.hackathon.pojo.SearchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class SearchService {
	
	
	@RequestMapping(value="/searchservice", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	//public @ResponseBody List<SearchResponse> getSearchService(@RequestBody SearchRequest searchRequest){
	public @ResponseBody SearchResponse getSearchService(@RequestBody SearchRequest searchRequest){
		
		//List<SearchResponse> searchResponseList = new ArrayList<SearchResponse>();
		SearchResponse searchResponse = new SearchResponse();
		Map<String,Facebook> data = new HashMap<String, Facebook>();
		Map<String,Map<String,Facebook>> datamap = new HashMap<String, Map<String,Facebook>>();
		try {
			System.out.println("Request received -->"+new ObjectMapper().writeValueAsString(searchRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtils.equalsIgnoreCase("searchFid.com",searchRequest.getResult().getMetadata().getIntentName())){
			System.out.println("Used Product Service --->"+searchRequest.getResult().getParameters().getProduct_service().get(0));
			/*String url = "https://search.fidelity.com/search/getSearchResults?question="+searchRequest.getResult().getParameters().getProduct_service().get(0);
			try {
				HttpClient client = HttpClientBuilder
						.create().build();
				HttpGet request = new HttpGet(url);
				request.addHeader("User-Agent",
						"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:49.0) Gecko/20100101 Firefox/49.0");
	
				HttpResponse response = client
						.execute(request);
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(response
								.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line);
	
				}
				String resultol = StringUtils
						.substringBetween(
								result.toString(), "<ol>",
								"</ol>");
				Document document = Jsoup.parse(resultol);
				Elements links = document.select("a[href]");
				for (Element link : links) {
					//SearchResponse searchResponse = new SearchResponse();
					searchResponse.setSpeech(link.text());
					searchResponse.setDisplayText(link.attr("href"));
					Map<String,String> dataRes = new HashMap<String,String>();
					dataRes.put(link.text(),link.attr("href"));
					Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
					data.put("facebook", dataRes);
					searchResponse.setData(data);
					searchResponse.setSource(searchRequest.getResult().getMetadata().getIntentName());
					
					//searchResponseList.add(searchResponse);
					break;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}*/
			searchResponse.setSpeech("speech");
			searchResponse.setDisplayText("displayText");
			//Map<String,String> recipient = new HashMap<String,String>();
			//recipient.put("id", "100014274137230");
			Map<String,String> message = new HashMap<String,String>();
			message.put("text", "response from service");
			//message.put("quick_replies", "response from serviceqr");
			Facebook facebook = new Facebook();
			facebook.setMessage(message);
			//facebook.setRecipient(recipient);
			facebook.setSender_action("sender_action");
			facebook.setNotification_type("notification_type");
			data.put("facebook", facebook);
			//datamap.put("data", data);
			searchResponse.setData(data);
			searchResponse.setSource("test source");
			
			
		}
		return searchResponse;
	}
	public static void main(String[] args){
		SpringApplication.run(SearchService.class, args);
	}
//	public static void main(String[] args) throws Exception {
//
//		CamelContext camelContext = new DefaultCamelContext();
//		camelContext.addRoutes(new RouteBuilder() {
//
//			@Override
//			public void configure() throws Exception {
//				from("jetty:https://hackathon-services.herokuapp.com/searchhttpservice")
//						.process(new Processor() {
//
//							public void process(Exchange exchange)
//									throws Exception {
//								Map<String, String> responseData = new LinkedHashMap<String, String>();
//								String searchKey = exchange.getIn().getHeader(
//										"searchKey", String.class);
//								String url = "https://search.fidelity.com/search/getSearchResults?question="
//										+ searchKey;
//								try {
//									HttpClient client = HttpClientBuilder
//											.create().build();
//									HttpGet request = new HttpGet(url);
//									request.addHeader("User-Agent",
//											"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:49.0) Gecko/20100101 Firefox/49.0");
//
//									HttpResponse response = client
//											.execute(request);
//									BufferedReader bufferedReader = new BufferedReader(
//											new InputStreamReader(response
//													.getEntity().getContent()));
//									StringBuffer result = new StringBuffer();
//									String line = "";
//									while ((line = bufferedReader.readLine()) != null) {
//										result.append(line);
//
//									}
//									String resultol = StringUtils
//											.substringBetween(
//													result.toString(), "<ol>",
//													"</ol>");
//									Document document = Jsoup.parse(resultol);
//									Elements links = document.select("a[href]");
//									for (Element link : links) {
//										System.out.println("\nlink :"
//												+ link.attr("href"));
//										System.out.println("text:"
//												+ link.text());
//										responseData.put(link.text(),
//												link.attr("href"));
//
//									}
//
//									exchange.getOut().setBody(responseData);
//								} catch (Exception exception) {
//									exception.printStackTrace();
//								}
//
//							}
//
//						}).marshal().json(JsonLibrary.Gson);
//
//			}
//		});
//
//		camelContext.addRoutes(new RouteBuilder() {
//
//			@Override
//			public void configure() throws Exception {
//				from("jetty:websocket://localhost:8086/searchhttpservice")
//						.process(new Processor() {
//
//							public void process(Exchange exchange)
//									throws Exception {
//								Map<String, String> responseData = new LinkedHashMap<String, String>();
//								String searchKey = exchange.getIn().getHeader(
//										"searchKey", String.class);
//								String url = "https://search.fidelity.com/search/getSearchResults?question="
//										+ searchKey;
//								try {
//									HttpClient client = HttpClientBuilder
//											.create().build();
//									HttpGet request = new HttpGet(url);
//									request.addHeader("User-Agent",
//											"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:49.0) Gecko/20100101 Firefox/49.0");
//
//									HttpResponse response = client
//											.execute(request);
//									BufferedReader bufferedReader = new BufferedReader(
//											new InputStreamReader(response
//													.getEntity().getContent()));
//									StringBuffer result = new StringBuffer();
//									String line = "";
//									while ((line = bufferedReader.readLine()) != null) {
//										result.append(line);
//
//									}
//									String resultol = StringUtils
//											.substringBetween(
//													result.toString(), "<ol>",
//													"</ol>");
//									Document document = Jsoup.parse(resultol);
//									Elements links = document.select("a[href]");
//									for (Element link : links) {
//										System.out.println("\nlink :"
//												+ link.attr("href"));
//										System.out.println("text:"
//												+ link.text());
//										responseData.put(link.text(),
//												link.attr("href"));
//
//									}
//
//									exchange.getOut().setBody(responseData);
//								} catch (Exception exception) {
//									exception.printStackTrace();
//								}
//
//							}
//
//						}).marshal().json(JsonLibrary.Gson);
//
//			}
//		});
//		camelContext.start();
//
//	}
}

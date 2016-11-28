package com.chat.service.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 * 
 */
@SpringBootApplication
@RestController
public class SearchService {
	
	
	@RequestMapping(value="/getSearchService", method=RequestMethod.GET)
	public String getSearchService(){
		return "it works!";
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

package com.example.springbootdocker;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@RequestMapping("/")
	public String home() {

		/**
		 * <dependency> <groupId>org.apache.httpcomponents</groupId>
		 * <artifactId>httpclient</artifactId> <version>4.5.10</version> </dependency>
		 */
//		CloseableHttpClient httpClient = HttpClients.createDefault();

		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).build();
		CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

		HttpGet request = new HttpGet("https://zjqqwk.api.infobip11.com/people/2/persons");

		// add request headers
		request.addHeader("Accept", "application/json");
		request.addHeader("Authorization", "App 0e9faa7f429f35e96389dfcc0b61b571-48ec9a26-508c-4415-a8ac-44a1e59c0a6a");

//		try (CloseableHttpResponse response = httpClient.execute(request)) {
//
////			CloseableHttpResponse response = httpClient.execute(request);
//			// Get HttpResponse Status
//			System.out.println(response.getProtocolVersion()); // HTTP/1.1
//			System.out.println(response.getStatusLine().getStatusCode()); // 200
//			System.out.println(response.getStatusLine().getReasonPhrase()); // OK
//			System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK
//
//			HttpEntity entity = response.getEntity();
//			if (entity != null) {
//				// return it as a String
//				String result = EntityUtils.toString(entity);
//				System.out.println(result);
//			}
//
//		} catch (IOException e) {
//
//		}

		int count = 0;

		try {
			httpClient.execute(request);
		} catch (ConnectTimeoutException exception) {
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}


	int count = 0;

	public void connectionTimeout() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://74.125.203.100");
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000).setSocketTimeout(1000)
				.setConnectTimeout(1000).build();
		httpGet.setConfig(requestConfig);
		try {
			httpclient.execute(httpGet);
		} catch (ConnectTimeoutException exception) {
			count++;
			if (count < 3) {
				connectionTimeout();
			}else {
				throw new Exception("timeout > 3 times, give up");
			}
		}
	}

}

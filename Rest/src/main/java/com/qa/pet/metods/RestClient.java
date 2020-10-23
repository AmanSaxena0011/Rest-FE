package com.qa.pet.metods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class RestClient {

	public static int statuscode;
	public static JSONArray jsonArray;
	public static String jsonString;

	public void get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse httpresponse = httpclient.execute(httpget);

		statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println("Status Code -->>" + statuscode);

		String responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseString);

		jsonArray = new JSONArray(responseString);

		System.out.println("Response Json from API -->" + jsonArray);
		jsonString = jsonArray.toString();

		Header[] headerArray = httpresponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headerArray) {

			allHeaders.put(header.getName(), header.getName());
		}

		System.out.println("Headers Array -->" + allHeaders);

	}
	
	
	//3. POST Method:
			public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
				CloseableHttpClient httpClient = HttpClients.createDefault();
				HttpPost httppost = new HttpPost(url); //http post request
				httppost.setEntity(new StringEntity(entityString)); //for payload
				
				//for headers:
				for(Map.Entry<String,String> entry : headerMap.entrySet()){
					httppost.addHeader(entry.getKey(), entry.getValue());
				}
				
				CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost);
				return closebaleHttpResponse;
				
				
			}	
	


}

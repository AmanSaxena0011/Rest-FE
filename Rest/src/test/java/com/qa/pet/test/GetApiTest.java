package com.qa.pet.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pet.base.TestBase;
import com.qa.pet.metods.RestClient;
import com.qa.pet.utils.Constants;

public class GetApiTest extends TestBase {
	TestBase testbase;
	String url;
	RestClient restClient;
	boolean flag;

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {

		testbase = new TestBase();
		url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
	}

	@Test(priority = 1)

	public void getAPITeststatusCode() throws ClientProtocolException, IOException {

		restClient = new RestClient();
		restClient.get(url);
		int actual = RestClient.statuscode;
		Assert.assertEquals(actual, Constants.StatusCode200);
	}

	@Test(priority = 2)

	public void validateAPIJSON() throws ClientProtocolException, IOException {

		restClient.get(url);

		if (RestClient.jsonString.contains("Llama")) {
			flag = true;
		} else {
			flag = false;
		}

		Assert.assertEquals(flag, Constants.trueflag);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

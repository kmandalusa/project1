package com.revature.cucumber_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	private HttpResponse response = null;

	@When("Login as User {string} and password {string}")
	public void login(String userId, String password) throws Exception {
		HttpPost request = new HttpPost("http://localhost:7777/login");
		List<NameValuePair> form = new ArrayList();
		form.add(new BasicNameValuePair("userId", userId));
		form.add(new BasicNameValuePair("password", password));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);
//		StringEntity entity = new StringEntity("usreId=Krishna&password=krishna"); //body
//		request.addHeader("content-type", "application/x-www-form-urlencoded");
		request.setEntity(entity);
		response = httpClient.execute(request);
		
	}

	@Then("Success")
	public void success() {
		int status = response.getStatusLine().getStatusCode();
		assertEquals(302, status);
	}
}
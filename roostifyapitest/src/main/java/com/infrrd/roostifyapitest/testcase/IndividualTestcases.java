package com.infrrd.roostifyapitest.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infrrd.roostifyapitest.helper.Authorization;
import com.infrrd.roostifyapitest.pojocollection.CreateALeadPOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingALoanApplicationPOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingAMessagePOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingATaskPOJO;
import com.infrrd.roostifyapitest.pojocollection.SubmitLoanAppPOJO;
import com.infrrd.roostifyapitest.pojocollection.UpdateALoanApplicationPOJO;
import com.infrrd.roostifyapitest.pojocollection.UpdateATaskPOJO;
import com.infrrd.testfrogforapi.base.BaseTest;
import com.infrrd.testfrogforapi.helper.FilePropertyHelper;

import io.restassured.response.Response;

public class IndividualTestcases extends BaseTest {

	@BeforeClass
	public void setup(){
		initializeReports();
	}
	
	@Test(description = "Testcase to display all tasks")
	public void display_all_tasks() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks?loan_application_id=6657144636962928";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(description = "Testcase to update a task")
	public void update_a_task() {
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks/4301853161191592";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = UpdateATaskPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/update_a_task.json";
		patch();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(description = "Testcase to verify api settings")
	public void settings_api() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/settings";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	

	@Test(description = "Testcase to submit loan application")
	public void submit_loan_application(){
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = SubmitLoanAppPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/submit_loan_application.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
	}
			
	
	@Test(description = "Testcase to retreive all accounts")
	public void retrieving_accounts() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//accounts/6661045189006214";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to retreive service")
	public void retrieving_service() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//service";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	

	@Test(description = "Testcase to retrieve a user by id")
	public void retrieve_a_user_by_id() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//services/users/1";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to create a lead")
	public void create_a_lead(){
		
		
		URI = "https://"+getEnvironment()+".roostify.com/api/draft//leads";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreateALeadPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/create_a_lead.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(description = "Testcase to retreive a lead")
	public void retrieve_a_lead() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/draft//leads/7279917561024244";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	

	@Test(description = "Testcase to create a task")
	public void creating_a_task(){
		
		URI = " https://"+getEnvironment()+".roostify.com/api/v1//tasks";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingATaskPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_task.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(description = "Testcase to listing tasks")
	public void listing_tasks() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks?loan_application_id=3707295962017979&page=1&count=50";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to retrieve a loan application")
	public void retrieve_a_loan_application() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/loan_applications/3707295962017979";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to update a loan application")
	public void update_a_loan_application() {
		
				
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications/9168695066949847";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = UpdateALoanApplicationPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/update_a_loan_application.json";
		patch();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(description = "Testcase to create a message")
	public void creating_a_message(){
		
		URI = "https://"+getEnvironment()+".roostify.com/api/draft/messages";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingAMessagePOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_message.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to create a loan application")
	public void creating_a_loan_application(){
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingALoanApplicationPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_loan_application.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
	}

	
	@Test(description = "Testcase to retrieve a message")
	public void retrieve_a_message() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/draft/messages/8738153823782151";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
}

package com.infrrd.roostifyapitest.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.infrrd.roostifyapitest.helper.Authorization;
import com.infrrd.roostifyapitest.pojocollection.CreateALeadPOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingALoanApplicationPOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingAMessagePOJO;
import com.infrrd.roostifyapitest.pojocollection.CreatingATaskPOJO;
import com.infrrd.roostifyapitest.pojocollection.UpdateALoanApplicationPOJO;
import com.infrrd.roostifyapitest.pojocollection.UpdateATaskPOJO;
import com.infrrd.testfrogforapi.base.BaseTest;
import com.infrrd.testfrogforapi.helper.FilePropertyHelper;

public class CascadedTestcases extends BaseTest {

	@BeforeClass
	public void setup(){
		initializeReports();
	}
	
			
	@Test(description = "TestCase To Create & Retrieve A Loan Application")
	public void creating_loan_Application(){
		
				
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingALoanApplicationPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_loan_application.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);		
		
		// Fetch Id From Creating A Loan Application
		String id = response.path("id");
		
		// Validate Response For Retrieve A Loan Application
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/loan_applications/" + id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	@Test(description = "TestCase To Submit Loan Application, Display Tasks, Retrieve Account & Updating Loan Application")
	public void submit_loan_Application(){
		
			
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingALoanApplicationPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_loan_application.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);		
		
		// Fetch Id From Submitting A Loan Application
		String id = response.path("id");
		String account_id = response.path("account_id");	
		
		// Validate Response For Display All Tasks
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks?loan_application_id=" + id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);		
		
		// Validate Response For Retrieving Account
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//accounts/" + account_id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);
		
		// Validate Response For Updating A Loan Application
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//loan_applications/"+id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type","application/json");
		POJOclass = UpdateALoanApplicationPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/update_a_loan_application.json";
		patch();
		Assert.assertEquals(response.statusCode(), 200);	
	}		
	
	
	
	
	@Test(description = "TestCase To Create Task, Retrieve Task, Update Task, List Task")
	public void creating_Task(){
		
		URI = " https://"+getEnvironment()+".roostify.com/api/v1//tasks";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingATaskPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_task.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);		
		
		// Fetch Id From Submitting A Loan Application
     	String id = response.path("id");
     	
     	//Validate Response For Listing A Task
     	URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks?loan_application_id="+id+"page=1&count=50";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
		
		//Validate Response For Update A Task
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//tasks/" + id;
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = UpdateATaskPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/update_a_task.json";
		patch();
		Assert.assertEquals(response.statusCode(), 200);		
	}
	
	
	
	
	@Test(description = "Testcase To Verify Api Settings")
	public void settings_api() {
		
		//Validate Response For Api Settings
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/settings";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		headerMap.put("Content-Type", "application/json");
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	@Test(description = "Testcase To Retrieve Service")
	public void retrieving_service() {
		
		//Validate Response For Retrieving Service
		URI = "https://"+getEnvironment()+".roostify.com/api/v1//service";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	@Test(description = "Testcase To Create & Retrieve Lead")
	public void creating_lead(){
		
		URI = "https://"+getEnvironment()+".roostify.com/api/draft//leads";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreateALeadPOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/create_a_lead.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
		
		// Fetch Id From Submitting A Loan Application
     	String id = response.path("id");
     	
     	//Validate Response For Retrieving Lead
     	URI = "https://"+getEnvironment()+".roostify.com/api/draft//leads/" + id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	@Test(description = "TestCase To Create Message")
	public void creating_message(){
		
			
		URI = "https://"+getEnvironment()+".roostify.com/api/draft/messages";
		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		POJOclass = CreatingAMessagePOJO.class;
		jsonFilePath = FilePropertyHelper.getProperty( "application", "jsonPath" ).get()+"/creating_a_message.json";
		post();
		Assert.assertEquals(response.statusCode(), 200);
		
		// Fetch Id From Submitting A Loan Application
     	//String id = response.path("id");
     	
     	//Validate Response For Retrieving Message
     	URI = "https://"+getEnvironment()+".roostify.com/api/draft/messages/9385";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
	@Test(description = "TestCase To Retrieve A User")
	public void retrieve_user() {
		
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/users";
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
		
		// Fetch Id From Submitting A Loan Application
     	String id = response.path("id");
		
		//Validate Response For Retrieving User By Id
		URI = "https://"+getEnvironment()+".roostify.com/api/v1/users/" + id;
		headerMap.put("Authorization", Authorization.getAuthorization(getEnvironment()));
		get();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	
	
}
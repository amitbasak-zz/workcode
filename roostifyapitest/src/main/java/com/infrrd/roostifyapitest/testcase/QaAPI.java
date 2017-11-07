package com.infrrd.roostifyapitest.testcase;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.infrrd.roostifyapitest.common.FilePropertyHandler;
import com.infrrd.roostifyapitest.pojocollection.CreatingATaskPOJO;
import com.infrrd.roostifyapitest.pojocollection.UpdateATaskPOJO;
import com.infrrd.testfrogforapi.base.BaseTest;

import io.restassured.response.Response;

public class QaAPI extends BaseTest {

	@BeforeClass
	public void setup(){
		initializeReports();
	}
	
	@Test(description = "Testcase to display all tasks")
	public void display_all_tasks() {
		
		URI = "https://qa.roostify.com/api/v1//tasks?loan_application_id=6657144636962928";
		headerMap.put("Authorization", "Basic NjY2MTA0NTE4OTAwNjIxNDoyMmNkOGY0Yzc2ZTYwYTkw");
		headerMap.put("Content-Type", "application/json");

		Response response = get();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(description = "Testcase to retreive all accounts")
	public void retrieving_accounts() {
		
		URI = "https://qa.roostify.com/api/v1//accounts/6661045189006214";
		headerMap.put("Authorization", "Basic NjY2MTA0NTE4OTAwNjIxNDoyMmNkOGY0Yzc2ZTYwYTkw");
		headerMap.put("Content-Type", "application/json");

		Response response = get();

		Assert.assertEquals(response.statusCode(), 200);

	}

	@Test(description = "Testcase to create and update a task")
	public void creating_and_update_a_task() {
		
		Response response ;
		
		// Create a new task

		URI = "https://qa.roostify.com/api/v1//tasks";
		headerMap.put("Authorization", "Basic NjY2MTA0NTE4OTAwNjIxNDoyMmNkOGY0Yzc2ZTYwYTkw");
		headerMap.put("Content-Type", "application/json");
		POJOclass = CreatingATaskPOJO.class;
		jsonFilePath = FilePropertyHandler.getProperty( "application", "jsonPath" ).get()+"/Creating_a_task.json";

		response = post();

		Assert.assertEquals(response.statusCode(), 200);
		
		// =====================================
		
		// Update the created task
		
			
		String update_id = response.path("id");
		
		URI = "https://qa.roostify.com/api/v1//tasks/" + update_id;
		headerMap.put("Authorization", "Basic NjY2MTA0NTE4OTAwNjIxNDoyMmNkOGY0Yzc2ZTYwYTkw");
		headerMap.put("Content-Type", "application/json");
		jsonFilePath = FilePropertyHandler.getProperty( "application", "jsonPath" ).get()+"/update_a_task.json";
		POJOclass = UpdateATaskPOJO.class;
				
		response = patch();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		// =====================================

	}
}

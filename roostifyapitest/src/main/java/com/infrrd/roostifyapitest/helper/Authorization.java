package com.infrrd.roostifyapitest.helper;

import com.infrrd.testfrogforapi.helper.FilePropertyHelper;

public class Authorization {
	private static String Authorization;
	
	private static void setAuthorization(String Environment){
		if(Environment.equalsIgnoreCase("QA")){
			Authorization = FilePropertyHelper.getProperty( "authorization", "QA_Auth" ).get();
		}else if(Environment.equalsIgnoreCase("Test")){
			Authorization = FilePropertyHelper.getProperty( "authorization", "Test_Auth" ).get();
		}
	}
	
	public static String getAuthorization(String Environment){
		setAuthorization(Environment);
		return Authorization;
	}

}

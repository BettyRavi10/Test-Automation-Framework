package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	
	//To read properties file and return the value of the key

	public static String readProperty(Env env,String propertyName ) {
		System.out.println(System.getProperty("user.dir")); //C:\Users\betty\eclipse-workspace\SDET\Automation_project_practice
		File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties"); //filepath of the properties file
		FileReader fileReader = null;
		Properties properties = new Properties(); // create object of Properties class

		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // create object of FileReader class and pass the properties file to it.
		
		 catch (IOException e) {
			e.printStackTrace();
		} // load the properties file to the Properties object
		String value = properties.getProperty(propertyName.toUpperCase()); // get the value of the key "URL" from the properties file
		return value;
		//System.out.println(value); // print the value of the key "URL" to the console //https://automationpractice.techwithjatin.com/login


	}
}

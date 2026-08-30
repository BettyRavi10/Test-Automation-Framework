package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "loginDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		String filePath = "testData/logindata.json";

		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") +filePath);
		FileReader fileReader = new FileReader(testDataFile);
		TestData testdata = gson.fromJson(fileReader, TestData.class); // Deserialization of JSON to Java object.
																		// Here we are converting JSON to TestData class
																		// object.

		List<Object[]> dataToReturn = new ArrayList<Object[]>(); // This is how you return from data provider. Data
																	// provider only can return in
		// Object[] format. So we need to convert List<User> to List<Object[]>.
		// You always create a reference variable of parent type and object is created
		// for child classes
		for (User user : testdata.getData()) {// one by one we get an individual data and attach to the arraylist
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator(); // returning iterator of List<Object[]>

	}

	@DataProvider(name = "loginCSVDataProvider")
	public Iterator<User> loginTestCSVDataProvider() {
		return CSVReaderUtility.readCSVfile("logindata.csv");

	}

	@DataProvider(name = "loginExcelDataProvider")
	public Iterator<User> loginTestExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("logindata.xlsx");

	}

}

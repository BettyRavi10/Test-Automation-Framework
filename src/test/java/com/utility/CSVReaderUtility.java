package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVfile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userlist = null;
		User userData;

		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // Skip the header row1
			// csvReader.readNext(); //Skip the first data row2
			// csvReader.readNext(); // Skip the first data row3
			// data = csvReader.readNext(); //row 4 [no row! we have reached the end of the
			// file] and readNext() will return null
			// System.out.println(Arrays.toString(data));*/

			userlist = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userlist.add(userData);

			}

//			for (User user : userlist) {
//				System.out.println(user);
//			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}

		return userlist.iterator();

	}

}

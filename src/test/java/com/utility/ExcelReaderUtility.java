package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		File xlsxFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		XSSFWorkbook xssfWorkbook = null; // xlsx FILE
		List<User> userList = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		Iterator<Row> rowIterator;
		XSSFSheet xssfSheet;

		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile); // to read the xlsx file
			userList = new ArrayList<User>();
			xssfSheet = xssfWorkbook.getSheet("LoginTestData"); // to read the sheet from the xlsx file
			rowIterator = xssfSheet.iterator(); // to iterate through the rows of the sheet of entire excel
			rowIterator.next(); // Skip the column name and its mandatory
			while (rowIterator.hasNext()) { // read data fron an iterator
				row = rowIterator.next();
				emailAddressCell = row.getCell(0); // to read the first cell of the row
				passwordCell = row.getCell(1); // to read the second cell of the row
				user = new User(emailAddressCell.toString(), passwordCell.toString()); // to create a user object with
				userList.add(user); // to add the user object to the list
				xssfWorkbook.close();

			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}

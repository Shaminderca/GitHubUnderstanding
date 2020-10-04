package com.qa.Automation.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Automation.Utility.ExcelUtility;
import com.qa.Automation.base.TestBase;
import com.qa.Automation.pages.ContactPage;

public class ContactPageTest extends TestBase {
	ContactPage cp;


	@BeforeMethod
	void StartUp() {
		initialisation();
		cp = new ContactPage();
	}

	@Test(dataProvider = "TestDataProviderFromExcel")
	void inputValuesInFieldTest(String email, String order, String message) {
		cp.selectDropDown();
		cp.inputValuesInField(email, order, message);
		boolean flag = cp.submitButtonMethod();
        Assert.assertTrue(flag);
	}

	@DataProvider(name = "TestDataProviderFromExcel")
	String[][] TestDataProvider() {
		String filePath = "./TestData\\AutomationData.xlsx";
		int row = ExcelUtility.getRowCount(filePath, "Sheet1");
		int col = ExcelUtility.getCellCount(filePath, "Sheet1", 1);
		System.out.println("row " + row + "col " + col);
		String[][] SignUpTestData = new String[row][col];
		for (int i = 1; i <= row; i++) {
			System.out.println("VALUR OF I IS "  + i);
			
			for (int j = 0; j< col; j++) {
				System.out.println("VALUR OF J IS "  + j);
		        
				SignUpTestData[i-1][j] = ExcelUtility.getCellData(filePath, "Sheet1", i, j);
		        
			}

		}
		return SignUpTestData;
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}

package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataObjects.PageObject_CWT_LoginWithNewPassword;
import DataObjects.PageObject_CWT_ResetPassword;
import DataObjects.WebDriverClass;
import Utilities.Utilities;

public class TESTCASE2_ResetPassword extends WebDriverClass{

	WebDriver driver;
	WebDriverWait wait;
	PageObject_CWT_ResetPassword homePage;
	PageObject_CWT_LoginWithNewPassword loginPage;
	Utilities util;
	
	@Before
	public void before() throws IOException {
		this.driver = super.initializeWebDriver(this.driver);
		this.wait = super.initializeWebDriverWait(this.driver);
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "yop"));
		homePage = new PageObject_CWT_ResetPassword();
		loginPage = new PageObject_CWT_LoginWithNewPassword();

		util = new Utilities();
	}
	
	@Test
	public void main() throws IOException {
		String passwordGenerated = util.generateRandomPassword(10);
		homePage.inputEmail(this.driver, this.wait, 
				super.getValueFromExcel("03_EMAIL", "Value", "email"), 
				passwordGenerated);
		//driver.quit();
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "cwt"));
		loginPage.login(this.driver, this.wait, super.getValueFromExcel("03_EMAIL", "Value", "email"),passwordGenerated );
		
	}
	
	@After
	public void close() 
	{
		super.closeWindow(this.driver);
	}
}


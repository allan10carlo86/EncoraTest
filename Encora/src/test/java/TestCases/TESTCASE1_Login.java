package TestCases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataObjects.PageObject_CWT_ForgotPassword;
import DataObjects.WebDriverClass;

public class TESTCASE1_Login extends WebDriverClass{

	WebDriver driver;
	WebDriverWait wait;
	PageObject_CWT_ForgotPassword homePage;
	
	@Before
	public void before() throws IOException {
		this.driver = super.initializeWebDriver(this.driver);
		this.wait = super.initializeWebDriverWait(this.driver);
		System.out.println(super.getValueFromExcel("01_URL", "URL", "cwt"));
		super.openWindow(this.driver, super.getValueFromExcel("01_URL", "URL", "cwt"));
		homePage = new PageObject_CWT_ForgotPassword();
	}
	
	@Test
	public void main() throws IOException {
		homePage.clickForgotPasswordLink(this.driver, this.wait);
		homePage.inputUsername(driver, wait, super.getValueFromExcel("02_LOGIN", "Value", "email"));
	}
	
	@After
	public void close() 
	{
		super.closeWindow(this.driver);
	}
}


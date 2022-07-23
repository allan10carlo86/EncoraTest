package DataObjects;

import java.util.ArrayList;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObject_CWT_ResetPassword{
	By emailInput = By.xpath("//input[@title='Login']");
	By submitButton = By.xpath("//button[@title='Check Inbox @yopmail.com']");
    By resetPasswordButton = By.xpath("(//a[contains(@href,'https:')])[1]");
    
    By newPasswordInputText = By.id("newPassword");
    By submitButtonPassword = By.id("submit-button");
    By errorMesssagePolicy = By.xpath("//p[contains(text(),'Your password does not meet the password policy')]");
    By passwordSuccessfullyChanged = By.id("password-changed-title");
	
	public void inputEmail(WebDriver driver, WebDriverWait wait, String email, String newPassword) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
		driver.findElement(submitButton).click();
		driver.switchTo().frame("ifmail");
		wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordButton)).click();
		
		
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordInputText));
	    driver.findElement(newPasswordInputText).sendKeys("a");
	    driver.findElement(submitButtonPassword).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMesssagePolicy)).getText();
	    Assert.assertEquals(text, "Your password does not meet the password policy");
	    driver.findElement(newPasswordInputText).clear();
	    
	    driver.findElement(newPasswordInputText).sendKeys("abc");
	    driver.findElement(submitButtonPassword).click();
		text = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMesssagePolicy)).getText();
	    Assert.assertEquals(text, "Your password does not meet the password policy");
	    driver.findElement(newPasswordInputText).clear();

	    driver.findElement(newPasswordInputText).sendKeys("abc123");
	    driver.findElement(submitButtonPassword).click();
		text = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMesssagePolicy)).getText();
	    Assert.assertEquals(text, "Your password does not meet the password policy");
	    driver.findElement(newPasswordInputText).clear();

	    driver.findElement(newPasswordInputText).sendKeys(newPassword);
	    driver.findElement(submitButtonPassword).click();
	    
	    String message = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordSuccessfullyChanged)).getText();
	    Assert.assertEquals(message, "Your password was successfully changed");
	   
	}
	
}

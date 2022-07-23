package DataObjects;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObject_CWT_ForgotPassword{
	By forgotPasswordLink = By.id("forgot-password-button");
	By usernameInputText = By.id("usernameField");
	By submitButton = By.id("submit-button");
	By checkYourEmailText = By.xpath("//h3[contains(text(),'Check your email')]");
	
	public void clickForgotPasswordLink(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink)).click();
	}
	
	public void inputUsername(WebDriver driver, WebDriverWait wait, String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText)).sendKeys(username);
		driver.findElement(submitButton).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(checkYourEmailText)).getText();
		Assert.assertEquals(text, "Check your email");
	}
}

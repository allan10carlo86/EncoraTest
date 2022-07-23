package DataObjects;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObject_CWT_LoginWithNewPassword{
	By usernameInput = By.id("username-input");
	By passwordInput = By.id("password-input");
	By submitButton = By.id("submit-button");
	By plataConfirmText = By.xpath("//b[text()='plata']");
	
	public void login(WebDriver driver, WebDriverWait wait, String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(submitButton).click();
		
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(plataConfirmText)).getText();
		Assert.assertEquals(text, "plata");
	}
}

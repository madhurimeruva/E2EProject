package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.xpath("//input[@id='user_email']");

	By password = By.cssSelector("input[id='user_password']");

	By submit = By.cssSelector("input[type='submit']");

	By forgotPassword = By.xpath("//a[@class='link-below-button']");

	public WebElement getEmail() {
		return driver.findElement(userName);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement logIn() {
		return driver.findElement(submit);
	}

	public ForgotPasswordPage forgotPassword() {
		driver.findElement(forgotPassword).click();
		// ForgotPasswordPage fp =
		return new ForgotPasswordPage(driver);
		// return fp;
	}
}

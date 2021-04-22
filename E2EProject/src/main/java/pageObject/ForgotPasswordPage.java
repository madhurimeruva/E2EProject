package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

	public WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.xpath("//input[@id='user_email']");
	By sendMeInstructions = By.xpath("//input[@name='commit']");

	public WebElement email() {
		return driver.findElement(email);

	}

	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}
}

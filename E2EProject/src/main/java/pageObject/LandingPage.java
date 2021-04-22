package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.xpath("//a[@class='theme-btn register-btn']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navBar = By.xpath("//ul[@class='navigation clearfix']");

	public LoginPage getLogin() {
		driver.findElement(login).click();
		LoginPage lop = new LoginPage(driver);
		return lop;
	}

	public WebElement getNavigation() {
		return driver.findElement(navBar);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}

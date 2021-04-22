package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import resources1.BaseFunction;

public class ValidateNavigation extends BaseFunction {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateNavigation.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeBrowser();

		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void mainHomePage() throws IOException {

		LandingPage lp = new LandingPage(driver);

		Assert.assertTrue(lp.getNavigation().isDisplayed());
		log.info("Navigation bar is displayed on the home page");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}

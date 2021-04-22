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

public class ValidateTitle extends BaseFunction {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeBrowser();
		log.info("Browser is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test()
	public void validateAppTitle() throws IOException {

		LandingPage lp = new LandingPage(driver);
		System.out.println(lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses123");
		log.info("Successfully got the page title");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

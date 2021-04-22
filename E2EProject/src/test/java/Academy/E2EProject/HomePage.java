package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources1.BaseFunction;

public class HomePage extends BaseFunction {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeBrowser();

	}

	@Test(dataProvider = "getData")
	public void mainHomePage(String username, String password, String text) throws IOException {
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);

		LoginPage lop = lp.getLogin();

		// LoginPage lop = new LoginPage(driver);

		lop.getEmail().sendKeys(username);

		lop.getPassword().sendKeys(password);

		log.info(text);
		// lop.logIn().click();
		ForgotPasswordPage fp=lop.forgotPassword();
		fp.email().sendKeys("hello5");
		fp.sendMeInstructions().click();

	}



	@DataProvider

	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		// row stands for how many different data types test should run
		// column stands for how many values for each data type

		// 0th row
		data[0][0] = "abcd@xyz.com";
		data[0][1] = "welcome";
		data[0][2] = "restricted user";
		// 1st row

		data[1][0] = "ghty@tyh.com";
		data[1][1] = "hello12";
		data[1][2] = "non-restricted user";
		// 2nd row
		data[2][0] = "hjyu@red.com";
		data[2][1] = "goldie";
		data[2][2] = "semi restricted user";

		return data;

	}

}

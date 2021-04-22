package resources1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseFunction {
	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(BaseFunction.class.getName());
	public WebDriver initalizeBrowser() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\javaprac\\E2EProject\\src\\main\\java\\resources1\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		log.info(browserName);
		log.info(urlName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		// Copy file at destination

		FileUtils.copyFile(sourceFile, new File(destinationFile));
		return destinationFile;

	}
}

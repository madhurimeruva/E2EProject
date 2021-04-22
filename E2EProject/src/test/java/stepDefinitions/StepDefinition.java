package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources1.BaseFunction;

public class StepDefinition extends BaseFunction {
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initalizeBrowser();
	}

	@Given("^navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);

	}

	@Given("^click on login link in the home page and land on secure sigh in page$")
	public void click_on_login_link_in_the_home_page_and_land_on_secure_sigh_in_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);

	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.getLogin();
		lop.getEmail().sendKeys(arg1);

		lop.getPassword().sendKeys(arg2);

		lop.logIn().click();
	}

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
}

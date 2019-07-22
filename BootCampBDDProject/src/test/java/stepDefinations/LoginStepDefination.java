package stepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;

public class LoginStepDefination {

	WebDriver driver;
	
	@Given("^a user with valid credentials$")
	public void a_user_with_valid_credentials() {
		String email = "techfiosdemo@gmail.com";
		String password = "abc123";
	}

	@When("^user goes to TechFios Login Page$")
	public void user_goes_to_TechFios_Login_Page() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
	}

	@Then("^TechFios Login Page should display$")
	public void techfios_Login_Page_should_display() {
		String expectedTitle = "Login - TechFios Test Application - Billing";
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		String displayedTitle = loginPage.getDisplayedTitle();
		System.out.println(displayedTitle);
		assertEquals("Titles did not match!", expectedTitle, displayedTitle);
	}

	@When("^user enter login information$")
	public void user_enter_login_information() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");
	}

	@Then("^Submit button should be enabled$")
	public void submit_button_should_be_enabled() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		assertTrue("Button was not enabled!", loginPage.isSubmitButtonEnabled());
	}

	@When("^user selects the Submit Button$")
	public void user_selects_the_Submit_Button() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnSubmitButton();
	}

	@Then("^Dashboard Page should display$")
	public void dashboard_Page_should_display() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		assertTrue("Title was not displayed!", loginPage.isTitleDisplayed());
		driver.close();
		driver.quit();
	}
	
	@Given("^a user with invalid credentials$")
	public void a_user_with_invalid_credentials()  {
		
	}
}

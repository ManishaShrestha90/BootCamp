package stepDefinations;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddContactSteps {
	
	WebDriver driver;
	
	@Before
	public void startBrowerAndGoToTechFios() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
	}

	
	@Given("^a user already logged in$")
	public void a_user_already_logged_in() {
		String ExpectedTitle = "Login - TechFios Test Application - Billing";
		String displayedTitle = driver.getTitle();
		assertEquals("Titles did not match!", ExpectedTitle, displayedTitle);
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		String expectedTitle = "Dashboard- TechFios Test Application - Billing";
		String actualTitle = driver.getTitle();
		
		@When("^user navigate to CRM -> Add Contact$")
		public void user_navigate_to_CRM_Add_Contact() {
			driver.findElement(By.xpath("//ul[@id='side-menu']/descendant::*[text()='CRM']")).click();
			
			driver.findElement(By.linkText("Add Contact")).click();
			

		}
		
		@Then("^Add Contact page should display$")
		public void add_Contact_page_should_display() {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Contacts ']"))));
			

		}
		@When("^user submits Full Name Company Name Email Phone Address City State/Region Zip/PostalCode Country Tags$"){
			public void user_submits_Full_Name_Comany_Name_Email_Phone_Address_City_State/Region_Zip/PostalCode_Country_Tags(){
			
				driver.findElement(By.id("account")).sendKeys("Peter Smith");
				driver.findElement(By.id("company")).sendKeys("ABC");
				driver.findElement(By.id("email")).sendKeys("petersmith@gmail.com");
				driver.findElement(By.id("phone")).sendKeys("1231234324");
				driver.findElement(By.id("address")).sendKeys("123 highway");
				driver.findElement(By.id("city")).sendKeys("texas");
				driver.findElement(By.id("state")).sendKeys("Tx");
				driver.findElement(By.id("zip")).sendKeys("73034");
				
			}
		}
		
		
		
		
}
}
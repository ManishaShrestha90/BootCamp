package test;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import junit.framework.Assert;
import page.AddDepositPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
public class AddDepositTest {
	
	@Test
	public void AddDepositToVerifyDepositPosted() throws InterruptedException {
		
		// starts the browser and saves the driver in the test class
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");

	
		// Page Factory inisiate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);


		// calling the method inside loginPage
		loginPage.login("techfiosdemo@gmail.com", "abc123");

		// Activate the DashboardPage
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		// call methods inside Dashboard Page. using explicit waits. wait for the page title
		dashboardPage.WaitForPage();

		// Step: click on the add deposit button
		dashboardPage.NavigateToNewDeposit();

		// Activate the Add Deposit Page
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);

		// validate AddDeposit Page opened (waitForPage)
		addDepositPage.waitForPage();

		addDepositPage.selectFromDropDownForDeposit("AutoAccount");

		addDepositPage.clearTheDateAndInput("2019-06-12");

		addDepositPage.clickAway();

		Thread.sleep(500);

		// initiate random class
		Random random = new Random();

		// storage for description and amount
		String eDescription = "TestDescription" + String.valueOf(random.nextInt(800));
		String eAmount = String.valueOf(random.nextInt(99999));

		// method to input description and amount
		addDepositPage.inputDescriptionAndAmount(eDescription, eAmount);
		

		// click on submit button

		addDepositPage.clickOnSubmitButton();


		// Assertion class to validate
		Assert.assertTrue("Success Message Did not show", addDepositPage.isSuccessMsgDisplayed());


	}

}

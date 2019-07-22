package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage{

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'CRM')]")
	WebElement CRM;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add Contact')]")
	WebElement AddContact;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Transactions')]")
	WebElement Transactions;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'New Deposit')]")
	WebElement NewDeposit;

	// calling a wait method. creates a explicit wait

	// method to interact with the elements
	public void WaitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void NavigateToAddContact() {

		CRM.click();
		AddContact.click();

	}

	public void NavigateToNewDeposit() {
		Transactions.click();
		NewDeposit.click();

	}

}

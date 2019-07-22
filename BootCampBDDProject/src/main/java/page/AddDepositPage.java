package page;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddDepositPage extends BasePage {
	
	// Global
		WebDriver driver;

		// Every page must have a constructor to invite the driver

		public AddDepositPage(WebDriver driver) {

			this.driver = driver;
		}
		

		// Element Library 7 in total

		@FindBy(how = How.XPATH, using = "//select[@id ='account']")WebElement Account;
		@FindBy(how = How.ID, using = "description")WebElement Description;
		@FindBy(how = How.ID, using = "amount")WebElement Amount;
		@FindBy(how = How.ID, using = "submit")WebElement Submit;
		
		// element for addDeposit Heading
		@FindBy(how = How.XPATH, using = "//h5[text()='Add Deposit']")WebElement AddDepositPanelHeading;
		// element for the date
		@FindBy(how = How.ID, using = "date")WebElement DateField;
		// element for transaction added successfully
		@FindBy(how = How.XPATH, using = "//button[@data-dismiss='alert']")WebElement DepositSuccessMsg;

		public void waitForPage() {
			waitForElement(AddDepositPanelHeading, driver);
		}

		// Methods to interact with the elements.
		public void fillInTheAddDepositForm(String description, String amount) {
			Account.click();
			Description.sendKeys(description);
			Amount.sendKeys(amount);
			Submit.click();
		}

		public void waitForSuccessMsg() {
			waitForElement(DepositSuccessMsg, driver);
		}

		// method to select from DropDown..
		public void selectFromDropDownForDeposit(String string) {
			Select AccountDropDown = new Select(Account);
			AccountDropDown.selectByVisibleText(string);

		}

		public void clearTheDateAndInput(String string) {
			DateField.clear();
			DateField.sendKeys(string);
			DateField.sendKeys(Keys.TAB);

		}

		public void inputDescriptionAndAmount(String eDescription, String eAmount) {
			Description.sendKeys(eDescription);
			Amount.sendKeys(eAmount);
		}

		public void clickAway() {
			AddDepositPanelHeading.click();

		}

		public void clickOnSubmitButton() {

			Submit.click();
		}
		
		//try and catch method
		public boolean isSuccessMsgDisplayed() {
			try {
			return DepositSuccessMsg.isDisplayed();
		}
			catch(NoSuchElementException e) {
				return false;
			}
		}

}

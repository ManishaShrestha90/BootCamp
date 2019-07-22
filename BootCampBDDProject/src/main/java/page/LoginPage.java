package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver; // Global
	// Every Page must have a constructor to invite the driver

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.ID, using = "username")
	WebElement UserName;
	@FindBy(how = How.ID, using = "password")
	WebElement Password;
	@FindBy(how = How.NAME, using = "login")
	WebElement SignInButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement PageTitle;

	// Methods to interact with the elements

	public void login(String userName, String password) {
		UserName.sendKeys(userName);
		Password.sendKeys(password);
//		SignInButton.click();
	}

	public String getDisplayedTitle() {
		return driver.getTitle();
	}

	public boolean isSubmitButtonEnabled() {
		return SignInButton.isEnabled();
	}

	public void clickOnSubmitButton() {
		SignInButton.click();
	}

	public boolean isTitleDisplayed() {
		return PageTitle.isDisplayed();
	}

}

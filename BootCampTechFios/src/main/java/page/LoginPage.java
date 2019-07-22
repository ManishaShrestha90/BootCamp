package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	// Global
			WebDriver driver;

			// Every page must have a constructor to invite the driver

			public LoginPage(WebDriver driver) {

				this.driver = driver;
			}

			// Element Library
			@FindBy(how = How.ID, using = "username")
			WebElement Email;

			@FindBy(how = How.ID, using = "password")
			WebElement Password;

			@FindBy(how = How.NAME, using = "login")
			WebElement SignInButton;

			// Methods to interact with the elements.
			
			public void login(String userName, String password) {
				
				Email.sendKeys(userName);
				Password.sendKeys(password);
				SignInButton.click();
			}


}

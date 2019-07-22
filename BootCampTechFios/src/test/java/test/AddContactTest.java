package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContact;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.Xls_Reader;

public class AddContactTest {
	
Xls_Reader reader=new Xls_Reader("./Data/Practice.xlsx");
	
	String LoginEmail=reader.getCellData("Sheet1", "LoginEmail", 2);
	String Password=reader.getCellData("Sheet1", "Password", 2);
	String Name=reader.getCellData("Sheet1", "Name", 2);
	String Company=reader.getCellData("Sheet1", "Company", 2);
	String Email=reader.getCellData("Sheet1", "Email", 2);
	String Phone=reader.getCellData("Sheet1", "Phone", 2);
	String Adddress=reader.getCellData("Sheet1", "Adddress", 2);
	String City=reader.getCellData("Sheet1", "City", 2);
	String State=reader.getCellData("Sheet1", "State", 2);
	String Zip=reader.getCellData("Sheet1", "Zip", 2);


	@Test
	public void AddingContact()throws InterruptedException{
		
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");
		 
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.login(LoginEmail, Password);
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.NavigateToAddContact();
		
		AddContact addContact = PageFactory.initElements(driver, AddContact.class);
		
				
		addContact.FillingUpAdressForm(Name, Company, Email, Phone, Adddress, City, State, Zip);

		driver.close();
		
		driver.quit();
		
	}

}

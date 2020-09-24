package pageLayer;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SetupTest;

public class HomePage {
	private static final String emailCreate = "email_create";
	private static final String CreateButton = "//form[@id='create-account_form']//span[1]" ;
	private static final String mrRadioButton = "id_gender1";
	private static final String firstNameId = "customer_firstname";
	private static final String lastNameId = "customer_lastname";
	private static final String passwordId = "passwd";
	private static final String AddressFNameID = "firstname";
	private static final String AddressLNameID = "lastname";
	private static final String Address = "address1";
	private static final String city = "city";
	private static final String zipCode = "postcode";
	private static final String mobile = "phone_mobile";
	private static final String register = "submitAccount";
	private static final String email = "email";
	private static final String password = "passwd";
	private static final String SubmitLoginId = "SubmitLogin";
	
	
	public static void fillForm(WebDriver driver){
		Properties prop = null;
		Select select;
		try {
			prop = SetupTest.readPropertiesFile(System.getProperty("user.dir") + "\\Resource\\data.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(emailCreate)).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(CreateButton)).submit();
		driver.findElement(By.id(mrRadioButton)).click();
		driver.findElement(By.id(firstNameId)).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.id(lastNameId)).sendKeys(prop.getProperty("lname"));
		driver.findElement(By.id(passwordId)).sendKeys(prop.getProperty("password"));
		WebElement days = driver.findElement(By.id("days"));
		select  =  new Select(days);
		select.selectByValue("25");
		WebElement months = driver.findElement(By.id("months"));
		select  =  new Select(months);
		select.selectByValue("12");
		WebElement years = driver.findElement(By.id("years"));
		select  =  new Select(years);
		select.selectByValue("1993");
		driver.findElement(By.id(Address)).sendKeys(prop.getProperty("address"));
		driver.findElement(By.id(city)).sendKeys(prop.getProperty("city"));
		WebElement state = driver.findElement(By.id("id_state"));
		select  =  new Select(state);
		select.selectByValue("3");
		driver.findElement(By.id(zipCode)).sendKeys(prop.getProperty("zipCode"));
		WebElement country = driver.findElement(By.id("id_country"));
		select  =  new Select(country);
		select.selectByVisibleText("United States");
		driver.findElement(By.id(mobile)).sendKeys(prop.getProperty("mobile"));
		driver.findElement(By.id(register)).click();
		
	}
	
	public static void LogInWithCreatedCredential(WebDriver driver) {
		Properties prop = null;
		try {
			prop = SetupTest.readPropertiesFile(System.getProperty("user.dir") + "\\Resource\\data.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(email)).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id(password)).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(SubmitLoginId)).click();
	}
	
}

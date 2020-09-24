package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageLayer.HomePage;
import pageLayer.DashboardPage;
import pageLayer.LoginPage;
import utils.SetupTest;

public class CrossAsystScenario {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void initilizeDriver() {
		driver = SetupTest.setup();
	}
	
	@Test
	public void CompleteOrder(){
		LoginPage.clickOnSignHome(driver);
		HomePage.fillForm(driver);
		DashboardPage.signOut(driver);
		HomePage.LogInWithCreatedCredential(driver);
		DashboardPage.goToWomenSection(driver);
		DashboardPage.quickView(driver);
		String ActualAmount = DashboardPage.completeCheckoutAndGetTotalAmount(driver);
		String ExpectedAmount = DashboardPage.GetTheTotalPriceFromOrderHistory(driver);
		Assert.assertEquals(ActualAmount, ExpectedAmount);
	}

	@AfterTest
	public void closeDriver(){
		driver.close();
	}

}

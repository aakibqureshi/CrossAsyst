package pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public static String clickOnSignHome(WebDriver driver) {
		driver.findElement(By.linkText("Sign in")).click();
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
		return title;
	}
	
	

}

package pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private static final String womenSection = "//a[@class='sf-with-ul'][contains(text(),'Women')]";

	public static void signOut(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
	}

	public static void goToWomenSection(WebDriver driver) {

		Actions action = new Actions(driver);
		WebElement women = driver.findElement(By.xpath(womenSection));
		action.moveToElement(women).build().perform();
		WebElement tShirt = driver.findElement(By.linkText("T-shirts"));
		action.moveToElement(tShirt).click().build().perform();
	}
	
	public static void quickView(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement image = driver
				.findElement(By.xpath("//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"));
		action.moveToElement(image).build().perform();
		driver.findElement(By.linkText("Quick view")).click();
	}
	
	public static String completeCheckoutAndGetTotalAmount(WebDriver driver) {
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-plus']")));
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		String totalAmount = driver.findElement(By.xpath("//span[@id='total_price']")).getText();
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		driver.findElement(By.xpath("//a[@class='button-exclusive btn btn-default']")).click();
		return totalAmount;
	}
	
	public static String GetTheTotalPriceFromOrderHistory(WebDriver driver) {
		String ExpectedAmount = driver.findElement(By.xpath("//td[@class='history_price']")).getText();
		return ExpectedAmount;
	}
}
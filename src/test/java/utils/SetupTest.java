package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupTest {
	
	public static WebDriver setup() {
		Properties prop = null;
		try {
			prop = readPropertiesFile(System.getProperty("user.dir") + "\\Resource\\data.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		return driver;
	}
	
	public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream input = null;
	      Properties prop = null;
	      try {
	         input = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(input);
	      } catch(FileNotFoundException fnf) {
	         fnf.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         input.close();
	      }
	      return prop;
	   }

}

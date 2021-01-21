package jdbc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Appsearch {
	public class AppSearch {
		public WebDriver driver;
		public String bname = "Firefox";
		public String url = "http://automationpractice.com/";
		
		@BeforeClass
		public void launchBrowser() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\avsub\\Downloads\\chromedriver_87\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver_20\\geckodriver.exe");
			
			if(bname.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		}
		

		@Test(priority=1, dataProvider="dbData", dataProviderClass=JDBCDataProvider.class)
		public void searchDress(String sreach) throws Exception {
			String searchXpath = "//input[@name='search_query']";
			String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
			
			driver.findElement(By.xpath(searchXpath)).click();
			driver.findElement(By.xpath(searchXpath)).clear();
			driver.findElement(By.xpath(searchXpath)).sendKeys(sreach);
			Thread.sleep(3000);
			driver.findElement(By.xpath(submitXpath)).click();
			Thread.sleep(3000);
		}
		@Test(priority=3)
		public void close() throws Exception {
			Thread.sleep(5000);
			System.out.println("closing browser");
			driver.quit();
		}
		
	}

}

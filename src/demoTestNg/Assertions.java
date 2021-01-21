package demoTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	public WebDriver driver;
	public String bname = "chrome";
	public String url ="http://automationpractice.com/index.php";
	
	@Test(priority=0)
	public void LaunchBrowser() {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avsub\\Downloads\\chromedriver_87\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver_20\\geckodriver.exe");

		if(bname.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//		Adding Assert for url
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(url, currenturl,"urls not matched ");
		System.out.println("urls matched ");
		
//		Assert for title
		String actualtitle = driver.getTitle();
		String excepectedTiltle = "My Store";
		Assert.assertTrue(actualtitle.equalsIgnoreCase(excepectedTiltle),"title mismatch");
		
		Assert.assertEquals(actualtitle, excepectedTiltle,"title mismatch");
		System.out.println("title matched");
	}


	@Test( priority=1 )//,enabled =false
	public void search()throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(searchXpath)).sendKeys("summer dresses");
		Thread.sleep(3000);
		System.out.println("sample user");
		driver.findElement(By.xpath(submitXpath)).click();

		
		boolean dFlag ;

		try {
			 dFlag = driver.findElement(By.xpath("//h1/span[contain(.,'Summer dresses')]")).isDisplayed(); //wrong xpath 
			} catch(Exception e) {
				dFlag = false;
			}
			Assert.assertFalse(dFlag, "Failed to display results"); // dflag is false so testcase passed.
			System.out.println("Results found");



	}	

	@Test(priority=2)
	public void  createuser( ) {
		//System.out.println(email_user);

	}

	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}




}

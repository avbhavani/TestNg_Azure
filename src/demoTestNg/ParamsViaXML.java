package demoTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import okio.Timeout;

public class ParamsViaXML {
	

	
	public WebDriver driver;
	public String bname ="chrome";
	public String url = "http://automationpractice.com/index.php";
	
	@BeforeClass
public void launchbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avsub\\Downloads\\chromedriver_87\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver_20\\geckodriver.exe");

		if(bname.equalsIgnoreCase("chrome")) {
			
				driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(20,  TimeUnit.SECONDS); // client side script like java ,vbscript all will take some time 
		//in some some instances to load in that case we will use it  

	}
	@Parameters({"seach_string","user_email"})
	@Test(priority=1)
	public void search(String seach_string,String user_email)throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys(seach_string);
		Thread.sleep(3000);
		System.out.println(user_email);
		driver.findElement(By.xpath(submitXpath)).click();
		
	}
	@Parameters({"user_email"})
	@Test(priority=2)
	public void  create(String user_email ) {
		System.out.println(user_email);
	}
	
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}


}

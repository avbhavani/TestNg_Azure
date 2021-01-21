package demoTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	public WebDriver driver;
	public String bname = "Firefox";
	public String url ="http://automationpractice.com/index.php";

	@BeforeClass
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
	}


	@Test( priority=1,dataProvider ="TestDta" )//,enabled =false
	public void search(String search_string, String email_user)throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(searchXpath)).sendKeys(search_string);
		Thread.sleep(3000);
		System.out.println(email_user);
		driver.findElement(By.xpath(submitXpath)).click();


	}	

	@Test(priority =2,dataProvider= "tdata")
	public void  createuser(String email_user) {
		System.out.println(email_user);

	}

	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}



	//this for Search method	
	@DataProvider(name="TestDta")
	//Object is Super of all classes or we can keep string also
	public Object[][] getData(){  //here two[][] dimensios for one is row (number of times should execute and other is for columns( data)
		String [][ ]datasets={     {"summer drsses", "test123@gmail.com"},
				{"winter dresses", "test113@gmail.com"},
				{"cotton dresses", "test244@gmail.com"}
		};


		return datasets;

	}

	//create user method
	@DataProvider(name ="tdata")
	public String [][] getdata2(){

		String [][] dataSets1 = {{" abc@gmail"},
				{"xyz@gmail"},
				{"jkl@gmail"}
		};
		return dataSets1;
	}
}

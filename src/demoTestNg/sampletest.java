package demoTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampletest {
	//in realtime we will give some gap between priorities eg: priority 1 and 2 becuase if 
	//two testcases with samepriorty it is hard to assgin the priority and should change priority 
	// in this case if we give the  gap it is easy to give priority instaed changing all of them
	
	
/*@Test(priority=1,description ="this is first test")
public void test1() {
		System.out.println("test1");
	}
	@Test(priority=3, enabled =false)
	
	public void test2() {
		System.out.println("test2");
		}
	
	//here it supposed to execute 3 times but  hence we mentioned invocationTimeOut after 10000milliseconds it will stop executing after 10sec,rest of counts will fail
	@Test(priority=5,invocationCount =3 , invocationTimeOut=10000)
	
	public void test3() throws InterruptedException {
		System.out.println("test3");
		Thread.sleep(5000);
		}*/
	
	/*@Test(priority=7)
	
	//in this case timeout comes first , then it will consider Thread.sleep (if Thread.sleep is 4000, it will consider timeout 5000-4000 =1000 as a waittime)
	//if we it couldn't be able to identfy element in specified time.
	public void test4() {
		System.out.println("test4");
		}
	//
	@Test(priority=9,timeOut=5000 )
	
	public void test5() throws Exception {
		System.out.println("test5");
		Thread.sleep(4000);
		}
	
	
	@Test(priority=1)
	public void launchbrowser() {
		System.out.println("launch browser"); // it will execute first bcz it is dependent on create user // if u did not provide any priority
	}
	@Test(priority=3,dependsOnMethods= {"launchbrowser"})
	public void search() {
		System.out.println("searc  for dresses");
		//Assert.fail(); //failing assert 
	}
	@Test(priority=5,dependsOnMethods= {"launchbrowser","search"},alwaysRun= true) //here 
	//if we use alwaysRun =true ,though dependent methods fails rest will pass.// called softdependency
	public void createuser() {
		System.out.println("create user");
	}
	@Test(priority=7)
	public void logout() {
		System.out.println("logout");
	}*/
	
	
	

	
	public static WebDriver driver;
	
	public String bname="chrome";
	public String url = "http://automationpractice.com/index.php";
	
	@BeforeSuite
	public void bs() {
		System.out.println("In before suite of sampletest");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("In before test of  sampletest");
	}


	@Test(priority=1)
	public void  launchbrowser( ) throws Exception {
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
	@Test(priority=3,dependsOnMethods= {"launchbrowser"})
	public void search() throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys("Winter dresses");
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();

		//Assert.fail(); //failing assert 
	}
	@Test(priority=5,dependsOnMethods= {"launchbrowser","search"},alwaysRun= true) //here 
	//if we use alwaysRun =true ,though dependent methods fails rest will pass.// called softdependency
	public void createuser() {
		System.out.println("create user");
	}
	@Test(priority=7)
	public void logout() {
		System.out.println("logout");
	}
}

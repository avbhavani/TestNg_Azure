package demoTestNg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterAnnotation {
	// what ever the annotation order you give testNg will execute  but it should have atlest oneTest @Testmethod
	@BeforeSuite
	public void bs() {
		System.out.println(" in before suite");
	}

	@AfterSuite
	public void as() {
		System.out.println(" in after suite");
	}

	@BeforeTest
	public void bt() {
		System.out.println(" in before test");
	}

	@AfterTest
	public void at() {
		System.out.println(" in after test");
	}
	@BeforeClass
	public void bc() {
		System.out.println("in before class");
	}
	@AfterClass
	public void ac() {
		System.out.println("in after class");
	}


	@BeforeMethod
	public void bm() {
		System.out.println(" in before method");
	}

	@AfterMethod
	public void am() {
		System.out.println(" in after method");
	}
	@Test(priority=1)
	public void login() {
		System.out.println("in login");
	}
	@Test(priority=3)
	public void search() {
		System.out.println("in search");
	}
	@Test
	public void  logout() {
System.out.println("logout ");
	}
	@Test(priority=5)
	public void createuser() {
		System.out.println("in createuser");
	}
}




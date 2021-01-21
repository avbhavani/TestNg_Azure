package demoTestNg;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupingDemo {
	@BeforeGroups("sanity")
	public void bg() {
		System.out.println("before group sanity");
	}
	//for before and after groups we no need to mention names in xml file it will take by default according with group names
	//we have given with @Test group name
	@BeforeGroups("regression")
	public void bg2() {
		System.out.println("before group regression");
	}
	/*
	 * if we use gruops with before and after annotations ,it will work normally 
	 * like in below eg: aftergroups if we exclude sanity, regression will run ,if u exclude regression
	 * sanity will run(not like @test gruops exclude)
	 */

	@AfterGroups({"regression", "sanity"})
	public void ag() {
		System.out.println("after group regresion");
	}

	/*in @Test annotaions if you exclude sanity in xml file while executing , regression  also will exclude that is
	 *  the disadvantage of exclude with @test groups in xml
	 * 
	 * lets say include sanity  or regression /both sanity and regression in the gruop of(sanity,regression) it will work  normally
	 * like a groups with annotations
	 */
	@Test(priority=1, groups = { "sanity", "regression"})
	public void launch() {
		System.out.println("Launch Browswer");
	}

	@Test(priority=2, groups = { "sanity"})
	public void search() {
		System.out.println("search dresses");
	}

	@Test(priority=3, groups = { "regression"})
	public void createUser() {
		System.out.println("Create user");
	}

	@Test(priority=4, groups = { "regression"})
	public void removeUser() {
		System.out.println("Remove an existing user");
	}

	@Test(priority=5, groups = { "sanity", "regression"})
	public void addItem() {
		System.out.println("add ite to shopping cart");
	}

	@Test(priority=6, groups = { "sanity", "regression"})
	public void checkout() {
		System.out.println("checkout items");
	}

	@Test(priority=7, groups = { "sanity", "regression"})
	public void logoutAndClose() {
		System.out.println("Logout and close");
	}


	@Test(priority=8, groups= {"smoke"})
	public void tc8() {
		System.out.println("tc8");
	}
}




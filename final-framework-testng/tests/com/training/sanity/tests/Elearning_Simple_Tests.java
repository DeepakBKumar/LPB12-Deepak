package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Elearning_LoginPOM;
import com.training.pom.Elearning_LogoutPOM;
import com.training.pom.MyCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Elearning_Simple_Tests {
	private WebDriver driver;
	private String baseUrl;
	private Elearning_LoginPOM loginPOM;
	private Elearning_LogoutPOM logoutPOM;
	private MyCoursePOM myCourse;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new Elearning_LoginPOM(driver);
		logoutPOM = new Elearning_LogoutPOM(driver); 
		myCourse = new MyCoursePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(enabled=false)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("DeepakBKumar");
		loginPOM.sendPassword("deepbkum@in.ibm.com");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		screenShot.captureScreenShot("screenshots/First");
		loginPOM.clickCourseCatalog();
		loginPOM.sendCourseName("Beta course 1");
		loginPOM.clicksearchCourse();
		loginPOM.clickSubscribe();
		loginPOM.isTextPresent("User Deepak B (DeepakBKumar) has been registered to course Beta course 1");
		
	}
	
	@Test(enabled=true)
	public void validLogoutTest() throws InterruptedException {
		loginPOM.sendUserName("DeepakBKumar");
		loginPOM.sendPassword("deepbkum@in.ibm.com");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		screenShot.captureScreenShot("screenshots/First");
		logoutPOM.clickUser();
		Thread.sleep(3000);
		boolean a=logoutPOM.isInboxPresent(" Inbox");                                        
		boolean b=logoutPOM.isMyCertificates("My certificates");
		boolean c=logoutPOM.isLogout("Logout");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		logoutPOM.clickLogout();
	}
	

	@Test(enabled=false)
	public void validMyCourseDetails() throws InterruptedException {
		loginPOM.sendUserName("DeepakBKumar");
		loginPOM.sendPassword("deepbkum@in.ibm.com");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		
		myCourse.clickMyCourse();
		myCourse.clickSubscribedCourse();
		myCourse.clickcourseDescription();
		driver.findElement(By.className("breadcrumb"));	
		System.out.println("END");
	}
	
}


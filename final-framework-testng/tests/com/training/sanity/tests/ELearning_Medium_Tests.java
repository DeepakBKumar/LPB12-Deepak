package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.Discuss_ForumPOM;
import com.training.pom.Elearning_LoginPOM;
import com.training.pom.MyCoursePOM;
import com.training.pom.Upload_AssignmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_Medium_Tests {

	private WebDriver driver;
	private String baseUrl;
	private Elearning_LoginPOM loginPOM;
	private MyCoursePOM myCourse;
	private Upload_AssignmentPOM uploadAssignment;
	private Discuss_ForumPOM forum;
	private static Properties properties;
		

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
		myCourse = new MyCoursePOM(driver); 
		uploadAssignment = new Upload_AssignmentPOM(driver);
		forum= new Discuss_ForumPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test(enabled=true)
	public void validMyCourseDetails() throws InterruptedException {
		loginPOM.sendUserName("DeepakBKumar");
		loginPOM.sendPassword("deepbkum@in.ibm.com");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);	
		myCourse.clickMyCourse();
		myCourse.clickSubscribedCourse();
		uploadAssignment.clickAssignments();
		uploadAssignment.clickCourseABC();
		uploadAssignment.clickUpload();	
		uploadAssignment.clickUploadSimple(); 
		uploadAssignment.enterFileName();
		uploadAssignment.selectFile();
		Thread.sleep(3000);
		uploadAssignment.clickUploadfile();
		uploadAssignment.verifyupload();
			
	}
	
	@Test(enabled=true)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("DeepakBKumar");
		loginPOM.sendPassword("deepbkum@in.ibm.com");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
//		loginPOM.clickCourseCatalog();
//		loginPOM.sendCourseName("BI");
//		loginPOM.clicksearchCourse();
//		loginPOM.clickSubscribe();
//		forum.verifyText();
		forum.clickMyCourse();
		forum.clickSubscribedCourse();
		forum.clickForums();
		forum.clickForumsCreated();
		forum.clickthread();
		forum.clickReplyToMessage();
		forum.entertext();
		forum.confirmReplyToMessage();
		
		
	}
	
}

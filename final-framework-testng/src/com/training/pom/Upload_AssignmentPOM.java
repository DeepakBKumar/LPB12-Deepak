package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Upload_AssignmentPOM {

private WebDriver driver; 
	
	public Upload_AssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='http://elearning.upskills.in/user_portal.php']")
	private WebElement myCourse;
	
	@FindBy(linkText="abc")
	private WebElement subsribedCourse;

	@FindBy(linkText="Assignments")
	private WebElement courseAssignments;
	
	@FindBy(linkText="ABC")
	private WebElement courseABC;
	
	@FindBy(className="btn-toolbar")
	private WebElement uploadbutton;
	
	@FindBy(linkText="Upload (Simple)")
	private WebElement uploadsimple;
	
	@FindBy(id="file_upload")
	private WebElement filename;
	
	@FindBy(id="form-work_file")
	private WebElement file;
	
	@FindBy(id="form-work_submitWork")
	private WebElement uploadfile;
	
	@FindBy(className="alert-info")
	private WebElement verifyupload;
	
	//=================methods=====================
	public void clickMyCourse() {
		this.myCourse.click(); 
	}
	
	public void clickSubscribedCourse() {
		this.subsribedCourse.click(); 
	}
	
	public void clickAssignments() {
		this.courseAssignments.click(); 
	}
	
	public void clickCourseABC() {
		this.courseABC.click(); 
	}
	
	public void clickUpload() {
		this.uploadbutton.click(); 
	}	

	public void clickUploadSimple() {
		this.uploadsimple.click(); 
	}
	
	public void enterFileName() {
		this.filename.click(); 
	}
	
	public void selectFile() {
		this.file.sendKeys("C:/Users/DeepakKumarB/test upload.txt");  
	}
	
	public void clickUploadfile() {
		this.uploadfile.click(); 
	}
	
	public void verifyupload() {
		String checkText=this.verifyupload.getText();
		System.out.println(checkText);
		Assert.assertEquals("The file has been added to the list of publications.", checkText);
		System.out.println("test complete");
	}		
	
}

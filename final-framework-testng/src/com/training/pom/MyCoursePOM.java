package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursePOM {

private WebDriver driver; 
	
	public MyCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='http://elearning.upskills.in/user_portal.php']")
	private WebElement myCourse;
	
	@FindBy(linkText="abc")
	private WebElement subsribedCourse;

	@FindBy(linkText="Course description")
	private WebElement courseDescription;
	
	
	public void clickMyCourse() {
		this.myCourse.click(); 
	}
	
	public void clickSubscribedCourse() {
		this.subsribedCourse.click(); 
	}
	
	public void clickcourseDescription() {
		this.courseDescription.click(); 
	}
	
}

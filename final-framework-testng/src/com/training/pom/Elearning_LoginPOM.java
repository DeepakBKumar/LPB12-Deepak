package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Elearning_LoginPOM {

private WebDriver driver; 
	
	public Elearning_LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Course catalog")
	private WebElement courseCatalog; 
		
	@FindBy(className="form-control")
	private WebElement courseName; 
	
	@FindBy(className="btn-default")
	private WebElement searchCourse; 
		
	@FindBy(xpath="//*[starts-with(@href,'/main/auth/courses.php?action')]")
	private WebElement subscribe; 
	
	@FindBy(className="alert-info")
	private WebElement textPresentOnUI; 
	
	
	//=============methods=====================
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
		
	public void clickCourseCatalog() {
		this.courseCatalog.click(); 
	}
	
	public void sendCourseName(String courseName) {
		this.courseName.clear(); 
		this.courseName.sendKeys(courseName); 
	}
	
	public void clicksearchCourse() {
		this.searchCourse.click(); 
	}
			
	public void clickSubscribe() {
			this.subscribe.click(); 
	}
	
	public boolean isTextPresent(String textValue) {
		String elementText = textPresentOnUI.getText();
		 return elementText.contains(textValue);
	 }

}
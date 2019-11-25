package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Discuss_ForumPOM {

private WebDriver driver; 
	
	public Discuss_ForumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}		
	
	@FindBy(className="alert-info")
	private WebElement textPresentOnUI; 
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/user_portal.php']")
	private WebElement myCourse;
	
	@FindBy(linkText="hii")
	private WebElement subsribedCourse;
	
	@FindBy(linkText="Forums")
	private WebElement clickForums;
	
	@FindBy(linkText="forum1")
	private WebElement clickForumCreated;
	
	@FindBy(linkText="thread1")
	private WebElement clickthread;
	
	@FindBy(id="reply-to-post-84")
	private WebElement replyToThisMessage;
	
	@FindBy(className="cke_editable cke_editable_themed cke_contents_ltr cke_show_borders")
	private WebElement enterText;
	
	@FindBy(className="thread_SubmitPost")
	private WebElement confirmMessage;
	
	
	
	//=============methods=====================	
	public void verifyText() {
		String checkText=this.textPresentOnUI.getText();
		System.out.println(checkText);
		Assert.assertEquals("User Deepak B (DeepakBKumar) has been registered to course abcd ", checkText);
	 }
	
	public void clickMyCourse() {
		this.myCourse.click(); 
	}
	
	public void clickSubscribedCourse() {
		this.subsribedCourse.click(); 
	}

	public void clickForums() {
		this.clickForums.click(); 
		
	}	
	public void clickForumsCreated() {
		this.clickForumCreated.click(); 
	}
	
	public void clickthread() {
		this.clickthread.click(); 
	}
	
	public void clickReplyToMessage() {
		this.replyToThisMessage.click(); 
	}
	
	public void entertext() {
		this.enterText.sendKeys("test"); 			
	}
	
	public void confirmReplyToMessage() {
		this.confirmMessage.click(); 
	}
	
}
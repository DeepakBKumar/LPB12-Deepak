package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elearning_LogoutPOM {
	
private WebDriver driver; 
	
	public Elearning_LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement clickUser;
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/main/messages/inbox.php']")
	private WebElement verifyInbox; 
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/main/gradebook/my_certificates.php']")
	private WebElement verifyMyCertificates;
	
	@FindBy(xpath="//a[@href='http://elearning.upskills.in/index.php?logout=logout&uid=342']")
	private WebElement verifyLogout;
	
	@FindBy(id="logout_button")
	private WebElement clickLogout;
	
	//=============methods=====================
	public void clickUser() {
		this.clickUser.click(); 
	}
	
	public boolean isInboxPresent(String textValue){
		String elementText = verifyInbox.getText();
		System.out.println("a");
		System.out.println(elementText);
		System.out.println(verifyInbox.getText());
		System.out.println("b");
		 return elementText.contains(textValue);
	 }
	public boolean isMyCertificates(String textValue) {
		String elementText = verifyMyCertificates.getText();
		System.out.println(elementText);
		 return elementText.contains(textValue);
	 }
	public boolean isLogout(String textValue) {
		String elementText = verifyLogout.getText();
		System.out.println(elementText);
		 return elementText.contains(textValue);
	 }

	public void clickLogout() {
		this.clickLogout.click(); 
	}
	
}

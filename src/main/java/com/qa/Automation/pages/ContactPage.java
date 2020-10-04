package com.qa.Automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Automation.base.TestBase;


public class ContactPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//object Repo
	
	@FindBy(id="id_contact")
	WebElement subjectHeading;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="id_order")
	WebElement orderField;
	 
	@FindBy(id="submitMessage")
	WebElement submitButton;
	
	@FindBy(id="message")
	WebElement messageField;
	
	@FindBy(xpath="//*[text()='Your message has been successfully sent to our team.']")
	 WebElement confirmationMessage;
	
	
	//fields
	
	public void selectDropDown() {
		Select obj = new Select(subjectHeading);
		obj.selectByIndex(1);
	}
	
	public void inputValuesInField(String email, String order,String message) {
	emailField.sendKeys(email);
	orderField.sendKeys(order);
	messageField.sendKeys(message);
	}
	
	public boolean submitButtonMethod()
	{
		submitButton.click();
		wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
		return confirmationMessage.isDisplayed();
		
	}
}


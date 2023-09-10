package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmailAdress(String emailText)
	{
		emailField.sendKeys(emailText);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	public void clickLoginButton()
	{
		loginbutton.click();;
	}
}

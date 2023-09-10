package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;

public class HomePage 
{
	WebDriver driver;
	private ElementsUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public void clickonMyAccount()
	{
		elementUtils.clickOnElements( myAccountDropMenu, 15);
	}
	
	public void selectLoginOption()
	{
		loginOption.click();
	}
}

package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils 
{
	WebDriver driver;
	public ElementsUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickOnElements(WebElement element, long durationInSeconds ) 
	{
		
		WebElement webElement = waitForElement(element, durationInSeconds);	
		webElement.click();
	}

	public void typeTextIntoElement (WebElement element, String textToBeTyped, long durationInSeconds  )
	{
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds )
	{
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.deselectByVisibleText(dropDownOption);			
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e){
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement elemnt, long durationInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElemnt = wait.until(ExpectedConditions.visibilityOf(elemnt));
		
		Actions action = new Actions(driver);
		action.moveToElement(webElemnt).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement elemnt, long durationInSeconds)
	{
		WebElement webElemnt = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElemnt = wait.until(ExpectedConditions.visibilityOf(elemnt));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return  webElemnt;
	}
	
	public void javaScriptClick(WebElement elemnt, long durationInSeconds, String textToBeTyped)
	{
		WebElement webElemnt = waitForElement(elemnt, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value'"+textToBeTyped+"'", webElemnt);
	}
	
}

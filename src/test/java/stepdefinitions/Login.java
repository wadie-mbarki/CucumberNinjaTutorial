package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Driver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Login 
{
	WebDriver driver;
	private LoginPage loginPage = new LoginPage(driver);
	//scenario1
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() 
	{
		 driver = DriverFactory.getDriver();
		 HomePage homePage = new HomePage(driver);
		 homePage.clickonMyAccount();
		 homePage.selectLoginOption();
		 
	}

	@When("User entered valid mail {string}")
	public void user_entered_valid_mail(String string) 
	{

		
		loginPage.enterEmailAdress(string);
	}

	@And("User entered valid password {string}")
	public void user_entered_valid_password(String string) 
	{
		loginPage.enterPassword(string);
		
	}

	@And("Userclick on login button")
	public void userclick_on_login_button() 
	{
		loginPage.clickLoginButton();
	}

	@Then("User should get successfuly logged in")
	public void user_should_get_successfuly_logged_in() 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/ul[1]/li[1]/a")).isDisplayed());
	}
	// scenario2
	@When("User entered invalid mail {string}")
	public void user_entered_invalid_mail(String string) 
	{
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(string);
	}

	@When("User entered invalid password {string}")
	public void user_entered_invalid_password(String string) {
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(string);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).click();
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() 
	{
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@id='account-login']/div[1]/text()")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
//scenario 3
	@When("User dont entered mail")
	public void user_dont_entered_mail() 
	{
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("");
	}

	@When("User dont entered password")
	public void user_dont_entered_password() 
	{
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("");
	}

}

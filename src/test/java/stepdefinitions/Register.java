package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register 
{
	WebDriver driver;
	@Given("User navigates to register Acoount page")
	public void user_navigates_to_register_acoount_page() 
	{
		 driver = DriverFactory.getDriver();
		 driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a")).click();
		 driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a")).click();
	}

	@When("USer enters the details into below fields")
	public void u_ser_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) 
	{
	  Map <String, String> dataMap = dataTable.asMap(String.class, String.class );
	  driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys(dataMap.get("firstName"));
	  driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys(dataMap.get("lastName"));
	  driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(dataMap.get("email"));
	  driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys(dataMap.get("telephone"));
	  driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(dataMap.get("password"));
	  driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys(dataMap.get("password"));
	   
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() 
	{
		 driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[1]")).click();
	}

	@When("User click on Continue button")
	public void user_click_on_continue_button() 
	{
		driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() 
	{
	   //Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//*[@id='content']/h1")).getText());
	}

	@When("User select yes for NEwsletter")
	public void user_select_yes_for_n_ewsletter()
	{
	    driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[1]/input")).click();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() 
	{
	  // Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning E-mailAdress is already registred!"));
	}

	@When("USer dont enters any details into fields")
	public void u_ser_dont_enters_any_details_into_fields() 
	{
	    
	}

	@Then("User should get a proper warning for every mandatory field")
	public void user_should_get_a_proper_warning_for_every_mandatory_field()
	{
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning E-mailAdress is already registred!"));
		//Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText());
	}


}

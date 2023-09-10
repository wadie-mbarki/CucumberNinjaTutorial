package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search 
{
	WebDriver driver;
	@Given("User opens the application")
	public void user_opens_the_application() 
	{
	    driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String string)
	{
	   driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys(string);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() 
	{
	  driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
	}

	@Then("User sould get valid product diplayed in search results")
	public void user_sould_get_valid_product_diplayed_in_search_results() 
	{
	  //Assert.assertTrue(driver.findElement(By.xpath("///*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")).isDisplayed());
	}

	@Then("User sould get a message about no product matching")
	public void user_sould_get_a_message_about_no_product_matching() 
	{
		//Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("///*[@id='content']/p[2]")).getText());
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field()
	{
		 driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("");
	}


}

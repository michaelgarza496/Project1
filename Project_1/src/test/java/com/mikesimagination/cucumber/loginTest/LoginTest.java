package com.mikesimagination.cucumber.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

	WebDriver driver = null;
	
	@Before
	public void chromeDriver(){
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^I am on initek's website$")
	public void goToInitekWebsite(){
		driver.navigate().to("http://localhost:8085/Project_1/");
	}
	
	@When("^I enter username as \"(.*)\" and I enter password as \"(.*)\"$")
	public void enterUserName(String username, String password){
		driver.findElement(By.id("usernameTextBox")).sendKeys(username);
		driver.findElement(By.id("passwordTextBox")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("^Login should pass$")
	public void employeeHomePageLoaded(){
		if(driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8085/Project_1/app.html")){
			System.out.println("Login successful.");
		}else{
			System.out.println("Login failed.");
		}
	}
}

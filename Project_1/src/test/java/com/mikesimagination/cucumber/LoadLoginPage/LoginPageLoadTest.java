package com.mikesimagination.cucumber.LoadLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPageLoadTest {
	
	WebDriver driver = null;
	
	@Given("^I have open the browser$")
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	
	@When("^I open Initek Website$")
	public void goToInitek(){
		driver.navigate().to("http://localhost:8085/Project_1/");
	}
	
	@Then("^Login Button should exists$")
	public void loginButton(){
		if(driver.findElement(By.id("loginButton")).isEnabled()){
			System.out.println("Test 1 passed");
		} else{
			System.out.println("Test 1 failed");
		}
		driver.close();
	}
}















//@Given("^I have open the browser$")
//public void openBrowser(){
//	driver = new RemoteWebDriver(DesiredCapabilities.chrome());
//	driver.get("http://localhost:8085/Project_1/");
//}
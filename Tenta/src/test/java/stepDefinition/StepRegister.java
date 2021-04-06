package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepRegister {

	private WebDriver driver;
	int num = (int) (Math.random() * 100000);
	String longnam = "kjhsdhsdjhvfjsdgvhsdbjgvhsködjgfdsasfkjnfsnhlösajkgsnbvbvnöjgsdhnjnbsaäasijrgnsdghklndfknkjsdlökgjks";

	@Given("I go to the Mailchimp website")
	public void i_go_to_the_mailchimp_website() {

		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser("chrome");
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}

	@Given("I want to write a {string}")
	public void i_want_to_write_a(String email) {
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		WebElement mail = driver.findElement(By.id("email"));
		if (email.equals("mahdialnajm")) {

			mail.sendKeys(email + num + "@gmail.com");
		} else {
			mail.sendKeys("");
		}
	}

	@Given("I want also to write a {string}")
	public void i_want_also_to_write_a(String username) {

		WebElement user = driver.findElement(By.id("new_username"));

		if (username.equals("name")) {
			user.sendKeys("mahdi09" + num);

		} else if (username.equals("longname")) {

			user.sendKeys(longnam);
		} else if (username.equals("busyname")) {

			user.sendKeys("mahdi09");
		}
	}

	@Given("I finaly want to write a {string}")
	public void i_finaly_want_to_write_a(String password) {

		WebElement pass = driver.findElement(By.id("new_password"));
		pass.sendKeys(password + num);
	}

	@When("I click on sign up button")
	public void i_click_on_sign_up_button() {

		driver.findElement(By.id("create-account")).click();
	}

	@Then("I verify {string}")
	public void i_verify(String result) {
		boolean signin;

		if (result.equals("registed")) {
			WebElement registed = driver.findElement(By.className("margin-bottom--lv5"));
			System.out.println(registed.getAttribute("outerText"));

			signin = registed.isDisplayed();
			assertEquals(true, signin);
			System.out.println("registed");

		} else if (result.equals("char100")) {
			WebElement registed100 = driver.findElement(By.className("invalid-error"));
			System.out.println(registed100.getAttribute("textContent"));

			signin = registed100.isDisplayed();
			assertEquals(true, signin);
			System.out.println("100 char");

		} else if (result.equals("trayagain")) {
			WebElement error = driver.findElement(By.className("invalid-error"));
			System.out.println(error.getAttribute("textContent"));

			signin = error.isDisplayed();
			assertEquals(true, signin);
			System.out.println("busy username");

		} else if (result.equals("missingemail")) {
			WebElement missing = driver.findElement(By.className("invalid-error"));
			System.out.println(missing.getAttribute("textContent"));

			signin = missing.isDisplayed();
			assertEquals(true, signin);
			System.out.println("missing email");
		}

		driver.quit();

	}
}

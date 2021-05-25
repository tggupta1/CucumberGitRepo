package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Tarun\\eclipse-workspace\\Cucumber\\CucumberFramework\\src\\test\\java\\CucumberFramework"
						+ "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^User clicks on SignIn button$")
	public void user_clicks_on_SignIn_button() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Log in']")).click();
	}

	/*
	 * @Given("^User enters a valid username$") public void
	 * user_enters_a_valid_username() throws Throwable {
	 * driver.findElement(By.xpath("//*[text()='Email']/parent::div/div/input")).
	 * sendKeys("tggupta22@gmail.com"); }
	 */

	//@Given("^User enters a valid username \"([^\"]*)\"$")
	@Given("^User enters a valid username \"(.*)\"$")
	public void user_enters_a_valid_username(String string)  throws Throwable{
		driver.findElement(By.xpath("//*[text()='Email']/parent::div/div/input")).sendKeys(string);
	}
	

	@Given("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12@Jammu");
	}

	@When("^User clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Log in' and @name='submit-button']")).click();
	}

	@Then("^User should be taken to Login Page successfully$")
	public void user_should_be_taken_to_Login_Page_successfully() throws Throwable {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Ask Question')]"))));
		if (driver.findElement(By.xpath("//*[contains(text(),'Ask Question')]")).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Then("User should LogOut portal")
	public void user_should_LogOut_portal() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='svg-icon iconStackExchange']")).click();
		driver.findElement(By.xpath("//a[text()='log out']")).click();
		driver.quit();
	}

}

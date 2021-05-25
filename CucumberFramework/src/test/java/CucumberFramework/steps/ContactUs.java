package CucumberFramework.steps;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class ContactUs {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Tarun\\eclipse-workspace\\Cucumber\\CucumberFramework\\src\\test\\java\\CucumberFramework"
						+ "\\resources\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("I access webdriveruniversity.com")
	public void i_access_webdriveruniversity_com() {
		//driver.get("http://www.webdriveruniversity.com/");
		driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("nnn "+driver.getTitle());
	}

	@When("I click on Contact us button")
	public void i_click_on_Contact_us_button() {
		driver.findElement(By.xpath("//*[text()='CONTACT US']")).click();
	}

	@When("I enter a valid username and password")
	public void i_enter_a_valid_username_and_password() throws InterruptedException {
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String win: windows) {
			if(win.contains("WebDriver | Contact Us")) {
				driver.switchTo().window("WebDriver | Contact Us");
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("FName1");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("LName1");
	}

	@When("I enter valid email address")
	public void i_enter_valid_email_address() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test1@gmail.com");
	}

	@When("I enter comments")
	public void i_enter_comments(DataTable args1) {
		List<List<String>> data=args1.asLists(String.class);
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(data.get(0).get(0));
	}

	@When("I click on Submit button")
	public void i_click_on_Submit_button() {

	}

	@Then("Information should be successfully be submitted to contact us page")
	public void information_should_be_successfully_be_submitted_to_contact_us_page() {

	}

}

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Facebook {
	WebDriver driver = null;
	
	@Given("^Open Facebook login page$")
	public void goToFacebook() {
		System.setProperty("webdriver.chrome.driver", "/Users/chandra/Downloads/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--enable-popup-blocking");
		options.addArguments("no-sandbox");
		options.addArguments("ignore-certificate-errors");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--disble-infobars");
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability("chrome.binary", "/Users/chandra/Downloads/chromedriver");
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void enterUsername(String arg1) {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void enterPassword(String arg1) {
		driver.findElement(By.id("pass")).sendKeys(arg1);
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
	}

	@Then("^Login should fail$")
	public void checkFail() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
			System.out.println("Test1 Pass");
		} else {
			System.out.println("Test1 Failed");
		}
		//driver.close();
	}
	
	@Then("^Login should pass$")
	public void checkPass() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com")) {
			System.out.println("Test3 Pass");
		} else {
			System.out.println("Test3 Failed");
		}
		//driver.close();
	}

	@Then("^Relogin option should be available$")
	public void checkRelogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
			System.out.println("Test2 Pass");
		} else {
			System.out.println("Test2 Failed");
		}
		driver.close();
	}
	
	@Then("^Post a status message: \"([^\"]*)\"$")
	public void postStatus(String message) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose Post' or text()='Make Post']"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-describedby,'placeholder')]"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-describedby,'placeholder')]"))).sendKeys(message);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']/span[text()='Post']"))).click();
		System.out.println("test");
		driver.close();
	}
}
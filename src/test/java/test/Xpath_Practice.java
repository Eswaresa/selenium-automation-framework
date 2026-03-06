package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Practice {

	WebDriver driver;

	@BeforeMethod()
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test()
	public void test_Part2() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student ");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();

		String curUrl = driver.getCurrentUrl();

		Assert.assertTrue(curUrl.contains("https://practicetestautomation.com/practice-test-login/"));
	}

	@Test(enabled = false)
	public void test_Part3() {
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("student");
		driver.findElement(By.xpath("//input[starts-with(@id,'pass')]")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		WebElement text = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations')]"));
		String val = text.getText();

		// String title = driver.getTitle();

		Assert.assertTrue(val.contains("Congratulations") || val.contains("successfully logged in"));
		// strong[contains(text(),'Congratulations')]
	}

	@AfterMethod()
	public void teartDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

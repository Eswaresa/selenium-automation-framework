package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Css_Practice {

	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@Test()
	public void test_Css() {

		WebElement usrnm = driver.findElement(By.cssSelector("input[id='username']"));
		WebElement pwd = driver.findElement(By.cssSelector("input[id='password']"));
		WebElement sbmt = driver.findElement(By.cssSelector("button#submit"));

		usrnm.sendKeys("stud");
		pwd.sendKeys("Password123");
		sbmt.click();

		String title = driver.getTitle();

		WebElement err = driver.findElement(By.cssSelector("div#error"));
		String errmsg = err.getText();

		if (title.contains("Logged In Successfully")) {
			System.out.println("Pass");

		} else {

			System.out.println("Failed - " + errmsg);
		}

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}

package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cssTest {

	WebDriver driver;
	
	String usrnm = "student";
	String pwd = "Password123";
	

	
	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test()
	public void testCss() {
		
		//Q1 Used ID attribute instead of #username as the locator is not unique
		driver.findElement(By.cssSelector("input[id = 'username']")).sendKeys(usrnm);
		//Q2 Used ID attribute instead of #password as the locator is not unique
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(pwd);
		//Q3 Used ID attribute instead of #password as the locator is not unique
		driver.findElement(By.cssSelector("button#submit")).click();
		
		
	}
	
	
	

}

package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_2 {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {

		//WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	
	@AfterMethod()
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}

package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		//WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/dropdown");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	
	@AfterMethod()
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
}

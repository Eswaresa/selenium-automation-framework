package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Simple_Test {

	protected  WebDriver driver;

	@BeforeMethod()
	public void setUp() throws IOException {

		ConfigReader config = new ConfigReader();

		String URL = config.getURL();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

	}

	@AfterMethod()
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

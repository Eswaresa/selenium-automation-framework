package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class salesForceBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SO-20260212-15345731

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://test.salesforce.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("eswar.palaniappan@landsend.com.qa");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("PraneelThendral@08");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		
		

	}
}
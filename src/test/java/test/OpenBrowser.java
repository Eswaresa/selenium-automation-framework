package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
//Core Webdriver Methods
		driver.get("https://www.google.com/");
		driver.navigate().to("");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

//Browser Information Methods

		driver.getTitle();
		driver.getCurrentUrl();
		driver.getPageSource();

// Window Control
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
//Close Vs Quit        
        driver.close();
		driver.quit();
// Find Elements Basics
		driver.findElement(By.id(""));
		driver.findElement(By.name(""));
		//driver.findElement(By.className("");
		driver.findElement(By.linkText(""));
		driver.findElement(By.xpath(""));
		
		
		

	}

}

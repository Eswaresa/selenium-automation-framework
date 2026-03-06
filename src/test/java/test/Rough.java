package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		WebElement usrnm = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement curAddr = driver.findElement(By.id("currentAddress"));
		WebElement perAddr = driver.findElement(By.id("permanentAddress"));
		WebElement submit = driver.findElement(By.id("submit"));
		usrnm.sendKeys("eswar");
		email.sendKeys("abcd@123.com");
		curAddr.sendKeys("abcd, abcdaddress");
		perAddr.sendKeys("abcd, abcdaddress");
		submit.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='name']")));

		List<WebElement> output = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']"));
		for (WebElement outputs : output) {
			System.out.println(outputs.getText());
		}
		WebElement nm = driver.findElement(By.xpath("//p[@id='name']"));
		String nme = nm.getText();

		if (nme != null) {

			System.out.println("Q8 Passed");
		} else {
			System.out.println("The Q8 Code Has Error");
		}
	}

}

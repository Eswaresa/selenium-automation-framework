package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RhaulShetty_Practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElements(By.name("name")).get(0).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test.mail@test.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Monday*123");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();

		Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		gender.selectByVisibleText("Female");

		driver.findElement(By.id("inlineRadio2")).click();

		// driver.findElements(By.xpath("//input[@class='form-control']")).get(1).sendKeys("12/10/1992");

		driver.findElement(By.name("bday")).sendKeys("1998-08-15");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementsByName('bday')[0].value='1998-08-15'");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

		String sucessMsg = msg.getText();

		System.out.println(sucessMsg);

	}

}

package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DropDown_Incremental_Test extends Base_2 {

	@Test
	public void Test_1() {

		WebElement passengers = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		passengers.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='hrefIncAdt']")));

		for (int i = 2; i <= 3; i++) {

			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}

		driver.findElement(By.id("btnclosepaxoption"));

		String val = passengers.getText();
		System.out.println(val);
	}

}

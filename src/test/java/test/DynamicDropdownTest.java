package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicDropdownTest extends Base_3 {

	// Click → Type → Wait → Capture List → Loop → Click

	@Test()
	public void test1() {
		WebElement dydrpdwn = driver.findElement(By.id("tags"));
		dydrpdwn.click();
		dydrpdwn.sendKeys("bas");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[contains(@class,'ui-menu')]//li")));

		List<WebElement> opt = driver.findElements(By.xpath("//ul[contains(@class,'ui-menu')]//li"));

		String drpval = "";

		for (WebElement options : opt) {

			drpval = options.getText();
			System.out.println(drpval);

		}

		

	}

}

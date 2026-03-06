package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown_select_Test extends Base_Test {

	@Test()
	public void Test_1() {

		WebElement drp_element = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropDown = new Select(drp_element);

		dropDown.selectByIndex(2);
		String res = dropDown.getFirstSelectedOption().getText();
		System.out.println(res);
		Assert.assertEquals(res, "Option 2");

	}

	@Test()
	public void Test_2() {
		WebElement drp_element = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropDown = new Select(drp_element);
		dropDown.selectByVisibleText("Option 2");
		String res = dropDown.getFirstSelectedOption().getText();
		Assert.assertEquals(res, "Option 2");

	}

}

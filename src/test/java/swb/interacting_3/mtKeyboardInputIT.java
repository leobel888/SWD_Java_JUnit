package swb.interacting_3;

import org.junit.Ignore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import swb.framework.WebDriverRunner;
import swb.factory.ElementBy;

import javax.inject.Inject;
import static org.junit.Assert.assertNotEquals;

@RunWith(WebDriverRunner.class)
public class mtKeyboardInputIT <W extends WebDriver & HasInputDevices> {
	
	@Inject
		private W driver;
/*		
	@Test
	public void completingAForm() throws Exception {
		
        
		driver.get("/login");
        driver
				.findElement(By.id("user_name")) // locate the user name input
				.sendKeys("Demo2"); // you enter text here into the input
		
		driver.getKeyboard().sendKeys(Keys.TAB); // now you tab to the checkbox
		
		driver
				.switchTo().activeElement() // change to the currently active element
				.sendKeys("12345678");
				
		driver.getKeyboard().sendKeys(Keys.TAB);
		
		driver
				.switchTo().activeElement() // change to the currently active element
				.sendKeys(" ");
		
		driver.getKeyboard().pressKey(Keys.ENTER);
		driver.getKeyboard().releaseKey(Keys.ENTER);
	}
*/	
	@Test
//	@Ignore("this test does not work on Firefox")
	public void enteringCheckBox() throws Exception {
		driver.get("/login");
		
		WebElement form = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		WebElement checkbox = form.findElement(By.cssSelector("input[type='checkbox']"));
		
		if(!checkbox.isSelected()) {
			checkbox.sendKeys(" ");
		}
	}
}
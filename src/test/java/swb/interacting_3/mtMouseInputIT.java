package swb.interacting_3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import swb.framework.WebDriverRunner;
import swb.factory.ElementBy;

import javax.inject.Inject;
import static org.junit.Assert.assertEquals;

@RunWith (WebDriverRunner.class)
public class mtMouseInputIT {
	
	@Inject
	private WebDriver driver;
	
	@Test
	public void completeAFormUsingBothMouseAndKeyboard() throws Exception {
		driver.get("/login");
		
		WebElement form = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		form
				.findElement(By.id("user_name"))
				.sendKeys("Demo2");
		
		form
				.findElement(By.id("user_password"))
				.sendKeys("12345678");
				
		form
				.findElement(By.className("remember-me-label"))
				.click(); // #A click the checkbox
		
		WebElement submitButton = form.findElement(By.cssSelector("input[type='submit']")); //#B find the double submit button
		
		new Actions(driver) // #C create actions from the driver
				.doubleClick(submitButton) // #D add a double-click to the sequence
				.perform(); // #E perform the sequence
	}
	//Developed test for label tag. Show the issue with name and id
	
	@Test
	public void CheckLabelTagByMouse() throws Exception {
		driver.get("/login");
		
		WebElement form = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		form
				.findElement(By.className("remember-me-label"))
				.click(); // #A click the checkbox
		
		assertEquals(true, 
						form.findElement(By.cssSelector("input[type='checkbox']"))
						.isSelected());
	}
}
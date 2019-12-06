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
		
	@Test
	public void completingAForm() throws Exception {
		
		driver.get("/login");
		
		driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		WebElement loginForm = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		WebElement UserName = loginForm.findElement(By.name("user_name"));
		UserName.clear();
		UserName.sendKeys("Demo2");
		
		WebElement UserPassword = loginForm.findElement(By.name("user_password"));
		UserPassword.clear();
		UserPassword.sendKeys("12345678");
		
		loginForm.findElement(By.cssSelector("input[type='submit']"))
			.click();
		}
}
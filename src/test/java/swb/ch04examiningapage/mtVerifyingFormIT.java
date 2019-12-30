package swb.ch04examiningapage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import swb.factory.InputBy;
import swb.factory.ElementBy;

import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(WebDriverRunner.class)
public class mtVerifyingFormIT {
	
	@Inject
	private WebDriver driver;
		
	@Inject
	private URI baseUrl;
	
	private static List<String> selectedText(WebElement interestsElement) {
		
		List<String> selectedText = new ArrayList<>();
		
		for (WebElement option : new Select(interestsElement).getAllSelectedOptions()) {
			selectedText.add(option.getText());
		}
		
		Collections.sort(selectedText);
		
		return selectedText;
	}
	
	@Test
	public void verifyAForm() throws Exception {
		driver.get(baseUrl + "/login");
		
		WebElement loginForm = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		//will prevent the alert from appearing.
		((JavascriptExecutor) driver).executeScript("Array.prototype.slice.call(" +
				"document.getElementsByTagName('input')).forEach(function(e){" +
				"  e.type=e.type=='password'?'text':e.type;" +
				"});");
		
		WebElement UserName = loginForm.findElement(By.name("user_name"));
		UserName.clear();
		UserName.sendKeys("Demo2");
		
		WebElement UserPassword = loginForm.findElement(By.name("user_password"));
		UserPassword.clear();
		UserPassword.sendKeys("12345678");
		
		WebElement checkbox = loginForm.findElement(By.cssSelector("input[type='checkbox']"));
		if(!checkbox.isSelected()) {
			checkbox.sendKeys(" ");
		}
		
		WebElement nameInput = loginForm.findElement(By.name("user_name"));	
		assertEquals("Demo2", nameInput.getAttribute("value"));
		
		WebElement passwordInput = loginForm.findElement(By.name("user_password"));
		assertEquals("12345678", passwordInput.getAttribute("value"));
		
		assertTrue(loginForm.findElement(InputBy.label("Remember")).isSelected());
				
	}
}
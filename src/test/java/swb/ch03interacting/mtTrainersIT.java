package swb.interacting_3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import swb.framework.WebDriverRunner;
import swb.factory.ElementBy;
import swb.factory.InputBy;

import javax.inject.Inject;
import java.net.URI;

@RunWith(WebDriverRunner.class)
public class mtTrainersIT {
 /*   @Inject
    private WebDriver driver;
    @Inject
    private URI baseUrl;
	
	@Test
	public void completingLoginForm() throws Exception {
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
		
		loginForm.findElement(By.cssSelector("input[type='submit']"))
			.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		
		
		WebElement element = driver
										.findElements(By.tagName("a"))
										.stream()
										.filter(e -> e.getText().contains("TRAINERS"))
										.findFirst()
										.get();
										
		element.click();
			
		}*/
}
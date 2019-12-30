package swb.ch04examiningapage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swb.framework.WebDriverRunner;
import swb.factory.ElementBy;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import java.net.URI;

import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class mtVerifyingStylesIT {
	
	@Inject 
	private WebDriver driver;
	
	@Inject
	private URI baseUrl;
	
	@Test
	public void mainMenucheckColorActive() throws Exception {
		driver.get(baseUrl + "/"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		
		WebElement activElem = driver
										.findElements(By.tagName("li"))
										.stream()
										.filter(e -> e.getAttribute("class").contains("active"))
										.findFirst()
										.get();	
										
//		activElem.click();
		
		WebElement a = activElem.findElement(By.tagName("a"));
		assertEquals("rgba(0, 174, 239, 1)", a.getCssValue("color"));
		
	}
	
	@Test
	public void cssShortHand() throws Exception {
		driver.get(baseUrl + "/login");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		
		WebElement loginForm = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		WebElement input = loginForm.findElement(By.id("user_name"));
		
		assertEquals("rgb(0, 0, 0)", input.getCssValue("border-color"));
		assertEquals("2px", input.getCssValue("border-width"));
		assertEquals("rgb(0, 0, 0)", input.getCssValue("color"));
		assertEquals("rgb(232, 240, 254)", input.getCssValue("background-color"));
	}
}

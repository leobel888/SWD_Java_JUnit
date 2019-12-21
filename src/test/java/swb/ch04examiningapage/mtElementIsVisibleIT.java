package swb.ch04examiningapage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.framework.WebDriverRunner;

import swb.factory.AllBy;

import javax.inject.Inject;
import java.net.URI;

import static org.junit.Assert.assertTrue;

@RunWith(WebDriverRunner.class)
public class mtElementIsVisibleIT {
	@Inject
	private WebDriver driver;
	@Inject
	private URI baseUrl;
	
	@Test
	public void visibleElementIsDisplayed() throws Exception {
		driver.get(baseUrl + "/");
		
		assertTrue(driver.findElement(By.id("lightbox")).isDisplayed());
	}
}
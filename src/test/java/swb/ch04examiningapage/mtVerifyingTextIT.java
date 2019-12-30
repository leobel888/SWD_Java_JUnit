package swb.ch04examiningapage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.factory.ElementBy;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URI;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(WebDriverRunner.class)
public class mtVerifyingTextIT {
	@Inject
	private WebDriver driver;
	@Inject
	private URI baseUrl;	
	
	@Test
	public void easyToFindElement() throws Exception {
		driver.get(baseUrl + "/");
		
		assertThat(driver.findElement(By.tagName("h2")).getText(),
				containsString("Incredibly Responsive"));
	}	
	
	@Test
	public void pageSourceMethod() throws Exception {
		driver.get(baseUrl + "/");
		
		assertThat(driver.getPageSource(),
				containsString("Incredibly Responsive"));
	}	
	
	@Test
	public void pageSourceMethodPrint() throws Exception {
		driver.get(baseUrl + "/");
		
		String pagesource = driver.getPageSource();
		System.out.print("-------> " + pagesource + " <-------");
	}
	
	@Test
	public void streamMethod() throws Exception {
		driver.get(baseUrl + "/");
		
		assertTrue(
				driver
						.findElements(By.cssSelector("*"))
						.stream()
						.anyMatch(
								e -> e.isDisplayed() &&
										e.getText().contains("Superior Typography")
		
						)
		);
	}
}



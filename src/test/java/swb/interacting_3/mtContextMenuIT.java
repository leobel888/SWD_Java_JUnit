package swb.interacting_3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URI;

@RunWith(WebDriverRunner.class)
public class mtContextMenuIT {
	
	@Inject
	private WebDriver driver;
	@Inject
	private URI baseUrl;
	
	@Test public void showContextMenu() throws Exception {
		driver.get(baseUrl + "/bookstore/context-menu.html");
		
		new Actions(driver)
				.contextClick(driver.findElement(By.id("hascontextmenu")))
				.perform();
	}
}
package swb.ch05pageobjects.fluentbuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import swb.framework.WebDriverRunner;
import swb.factory.ElementBy;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class mtLoginFormIT{
	@Inject
	private WebDriver driver;
	
	@Test
	public void checkLoginForm() throws Exception {
		driver.get("/login");
		
		new mtLoginForm(driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0))))
					.username("demo2")
					.password("12345678")
					.submit();
					
		new WebDriverWait(driver, 2)	
					.until((WebDriver input)-> "user".equals(driver.getTitle()));
	}
}
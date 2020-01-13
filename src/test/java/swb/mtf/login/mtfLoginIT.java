package swb.mtf.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class mtfLoginIT {
	@Inject
    private WebDriver driver;
	
	@Test
	public void UserloginProcess() throws Exception {
	
		//will prevent the alert from appearing.
		((JavascriptExecutor) driver).executeScript("Array.prototype.slice.call(" +
				"document.getElementsByTagName('input')).forEach(function(e){" +
				"  e.type=e.type=='password'?'text':e.type;" +
				"});");
				
		mtfLogin login = LoadingPageFactory.get(driver, mtfLogin.class);
		login.loginInfo("Demo2", "12345678");
		
		assertEquals(true, login.getLabel()
								.findElement(By.cssSelector("input[type='checkbox']"))
								.isSelected());
		
		login.submit();
	}
}
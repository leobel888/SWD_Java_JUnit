package swb.ch05pageobjects.pagefactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class mtLoginFIT {
	@Inject
    private WebDriver driver;
	
	@Test
	public void pageFactory() throws Exception {
		driver.get("/login");
		mtLoginF loginF = PageFactory.initElements(driver, mtLoginF.class);
		loginF.loginFor("Demo2", "12345678");
	}
	
}
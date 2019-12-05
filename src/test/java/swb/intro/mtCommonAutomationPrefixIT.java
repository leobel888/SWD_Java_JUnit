package swb.intro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import swb.factory.ElementBy;

import static org.junit.Assert.assertEquals;

public class mtCommonAutomationPrefixIT {
	
	WebDriver driver;
	String exePath = "C:\\Server\\chromedriver.exe";
		
	@Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
    }

    @After
    public void tearDown() throws Exception {
		driver.quit();
    }
	
	@Test
	public void commonPrefix() throws Exception {
		assertEquals("Remember me for 2 weeks",
				driver.findElement(By.className(String.format("wd-loginform-item-%d", 0)))
							.getText());
	}
	
	@Test
	public void CommonPrefixFactory() throws Exception {
		assertEquals("Remember me for 2 weeks",
				driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)))
							.getText());
	}
}
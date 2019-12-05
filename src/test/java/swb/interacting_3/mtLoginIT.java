package swb.interacting_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import swb.factory.ElementBy;

public class mtLoginIT {
	
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
//		driver.quit();
    }
	
	@Test
	public void completingAForm() throws Exception {
		
		driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		WebElement loginForm = driver.findElement(ElementBy.automationId(String.format("loginform-item-%d", 0)));
		
		WebElement UserName = loginForm.findElement(By.name("user_name"));
		UserName.clear();
		UserName.sendKeys("Demo2");
		
		WebElement UserPassword = loginForm.findElement(By.name("user_password"));
		UserPassword.clear();
		UserPassword.sendKeys("12345678");
		
		loginForm.findElement(By.cssSelector("input[type='submit']"))
			.click();
		}
}


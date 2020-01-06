package swb.intro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class mtHelloWebDriverIT {

    WebDriver driver;
	String exePath = "C:\\Server\\chromedriver.exe";
	

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
//		driver.get("http://localhost:8080/hello-webdriver.html");
//		driver.get("http://google.com");
		driver.get("http://localhost:8080");
    }

    @After
    public void tearDown() throws Exception {
//		driver.quit();
    }

/*  @Test
	public void helloWebDriver() throws Exception {
		WebElement pageHeading = driver.findElement(By.id("header"));
//		assertEquals("Hello WebDriver!", pageHeading.getText());
	}
	
	@Test
    public void chainedLocators() throws Exception {

        driver
                .findElement(By.xpath("//*[contains(normalize-space(.),'Home')]"))
                .findElement(By.tagName("a"));
	}
	
	@Test
    public void chainedStreamLocators() throws Exception {
		
		List<WebElement> mainMenuElements = driver.findElements(By.tagName("a"));
													
		//HOME
		WebElement homeElement = mainMenuElements		
							.stream()
							.filter(e -> e.getText().toLowerCase().contains("home"))
							.findFirst()
							.get();
		//PROFILES
		WebElement profilesElement = mainMenuElements		
							.stream()
							.filter(e -> e.getText().toLowerCase().contains("profiles"))
							.findFirst()
							.get();
	}
*/	
	
	@Test	
	@SuppressWarnings("unused")
	public void chainedFormLocatorsLoginForm() throws Exception {

		WebElement loginForm = driver.findElement(By.cssSelector("div[class='login-box']>form"));
		WebElement usernameInput = loginForm.findElement(By.name("user_name"));
		WebElement usernamePassword = loginForm.findElement(By.name("user_password"));
		WebElement labelRememberMe = loginForm.findElement(By.className("remember-me-label"));
		WebElement inputRememberMe = labelRememberMe.findElement(By.name("set_remember_me_cookie"));
		System.out.println("--getText--> " + labelRememberMe.getText());
	}
	
	
	@Test	
	@SuppressWarnings("unused")
	public void chainedFormLocatorsSendMessageForm() throws Exception{
		
		WebElement SendMessageForm = driver.findElement(By.id("main-contact-form")); // #1 locate the form itself
		WebElement nameInput = SendMessageForm.findElement(By.name("name"));
		WebElement emailInput = SendMessageForm.findElement(By.name("email"));
		WebElement textareaMessage = SendMessageForm.findElement(By.id("message"));
	} 	
}

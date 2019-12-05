package swb.intro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.WebElement;

import swb.factory.AllBy;
import swb.factory.AnyBy;
import swb.factory.NotBy;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class mtLocatorCompositionIT {
	
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
	public void locateIDorName() throws Exception {
		driver.findElement(new ByIdOrName("main-contact-form"));
	}
	
	@Test
	public void byChained() throws Exception {
		driver.findElement(
				new ByChained(
						By.xpath("//*[contains(concat('',normalize-space(@class),''),'contact-form ')]"),
						By.xpath("//*[contains(.,'Send a message')]"),
						By.id("main-contact-form"),
						By.tagName("input")
			)
		);
	}
	
	@Test //Login Form
    public void byAnd() throws Exception {
        assertEquals("user_name",
                driver.findElement(AllBy.all(By.tagName("input"), By.name("user_name")))
                        .getAttribute("name"));
    }
	
	@Test //Contact Form
	public void byAndCntForm() throws Exception {
		assertEquals("contact-form",
				driver.findElement(AllBy.all(By.tagName("form"), By.name("contact-form")))
						.getAttribute("name"));
	}
	
	@Test 
	public void byAny() throws Exception {
		assertEquals("user_name",
				driver.findElement(AnyBy.any(By.id("user_name"), By.name("user_name")))
						.getAttribute("name"));
	}

	@Test
	public void byExcludes() throws Exception {
						
		WebElement navBar = driver.findElement(By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), ' navbar-nav ')]"));		
		List<WebElement> navBarList =	navBar.findElements(
						AllBy.all(
								By.tagName("li"),
								NotBy.not(By.className("active"))
						)
				);
		
//		navBarList.get(1).click();
		System.out.print(" --element 2-> " + navBarList.get(2).getText());
		
		for (WebElement element : navBarList) {
			
			System.out.print("---elements------->" + element.getText());
			
		}
	}
}


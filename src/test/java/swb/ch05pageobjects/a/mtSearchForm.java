package swb.ch05pageobjects.a;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import swb.factory.ElementBy;

import javax.inject.Inject;

public class mtSearchForm<W extends WebDriver & HasInputDevices> {
    
	@Inject
    private final W driver;

	public mtSearchForm(W driver) {
		this.driver = driver;
	}
	
	public void searchFor(String query, String expectedPlaceholder) {
		
		ClickSearchSign(driver);
		
		if (!expectedPlaceholder.equals("")) {
			verifyPlaceholder(expectedPlaceholder);
		}

		driver.findElement(By.cssSelector("input[class='search-form']"))
                .sendKeys(query);
		
		driver.getKeyboard().pressKey(Keys.ENTER);
        driver.getKeyboard().releaseKey(Keys.ENTER);
	}
	
	private void ClickSearchSign(W driver) {
//		driver.findElement(By.cssSelector("i[class='fa-search']")); //  find the search button
//		driver.findElement(By.className("fa-search"))
//		driver.findElement(By.xpath("//*[contains(concat('',normalize-space(@class),''),' fa-search')]"))
//		driver.findElement(ElementBy.automationId(String.format("searchform-item-%d", 0))))    
		
		new Actions(driver)
				.moveToElement(driver.findElement(ElementBy.automationId(String.format("searchform-item-%d", 0))))
				.click()
                .perform();
	}
	
	private void verifyPlaceholder(String expectedPlaceholder) {
		String actualPlaceholder = driver.findElement(By.cssSelector("input[class='search-form']")).getAttribute("placeholder");
        if (!expectedPlaceholder.equals(actualPlaceholder)) {
            throw new IllegalStateException("expected " + expectedPlaceholder + " but got " + actualPlaceholder);
        }
    }
	
}

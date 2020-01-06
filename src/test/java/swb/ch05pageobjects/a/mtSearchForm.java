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
		
//		WebElement searchButton = driver.findElement(By.cssSelector("i[class='fa-search']")); //  find the search button
//		WebElement searchButton = driver.findElement(By.className("fa-search")); 
//		By.xpath("//*[contains(concat('',normalize-space(@class),''),' fa-search')]"),
//		new mtLoginForm(driver.findElement(ElementBy.automationId(String.format("searchform-item-%d", 0))))       
	   
		new Actions(driver) // #C create actions from the driver
                .moveToElement(driver.findElement(ElementBy.automationId(String.format("searchform-item-%d", 0))))
				.click() // #D add a-click to the sequence
                .perform();
		}
	
	public void setQuery(String query) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.cssSelector("input[class='search-form']"))
                .sendKeys(query);
	}

    public void submit() {
		driver.getKeyboard().pressKey(Keys.ENTER); // #F submit the form
        driver.getKeyboard().releaseKey(Keys.ENTER);
    }
}

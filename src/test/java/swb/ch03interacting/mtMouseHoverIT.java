package swb.ch03interacting;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import swb.framework.WebDriverRunner;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class mtMouseHoverIT {

    @Inject
    private WebDriver driver;

    @Test
    public void hoverOver() throws Exception {
        driver.get("/bookstore/mouse-hover.html");

        new Actions(driver)
                .moveToElement(driver.findElement(By.id("target")))
                .perform();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 		
    }
}
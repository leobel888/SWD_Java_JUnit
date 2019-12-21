package swb.ch04examiningapage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.framework.WebDriverRunner;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//import static org.junit.Assert.assertThat;


@RunWith(WebDriverRunner.class)
public class mtElementIsPresentIT {
	@Inject
	private WebDriver driver;
	@Inject
	private URI baseUrl;
	
	@Test
	public void checkingAnElementIsPresent() throws Exception {
		driver.get(baseUrl + "/");
		
		List<WebElement> divContainersList = driver.findElements(By.className("container"));
			
			for (WebElement element : divContainersList) {
				
				System.out.print("---elements-----Width-------> " + element.getSize().getWidth() + " <----- ");
				assertThat(element.getSize().getWidth(), equalTo(970));
			}
	
		assertThat(divContainersList, hasSize(1));
	}
	
	
	
}
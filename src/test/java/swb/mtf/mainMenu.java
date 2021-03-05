package swb.mtf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainMenu {
	
	public void clickMenu(String items, WebDriver driver) {	

		WebElement element = driver
									.findElements(By.tagName("a"))
									.stream()	
									.filter(e -> e.getText().contains(items))	
									.findFirst()	
									.get();		
		element.click();
	}
}
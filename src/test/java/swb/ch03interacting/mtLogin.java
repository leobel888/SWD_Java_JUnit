package swb.ch03interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mtLogin {
	
/*	private final WebDriver driver;
	
	@FindBy(className = String.format("wd-loginform-item-%d", 0));
	private WebElement loginForm;
	
	WebElement name = loginForm.findElement(By.name("user_name"));
	WebElement password = loginForm.findElement(By.name("user_password"));
	WebElement submit = loginForm.findElement(By.cssSelector("input[type='submit']"));
	
	public void setLogin(String name, String password) {
		this.name.sendKeys(name);
		this.password.sendKeys(password);
	}
	
	public void submit() {
			
		//will prevent the alert from appearing.
		((JavascriptExecutor) driver).executeScript("Array.prototype.slice.call(" +
				"document.getElementsByTagName('input')).forEach(function(e){" +
				"  e.type=e.type=='password'?'text':e.type;" +
				"});");
		submit.click();
	}*/
}

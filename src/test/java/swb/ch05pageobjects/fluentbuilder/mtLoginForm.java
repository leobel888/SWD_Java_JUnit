package swb.ch05pageobjects.fluentbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mtLoginForm {
	private final WebElement loginForm;
	
	public mtLoginForm(WebElement loginForm) {
		this.loginForm = loginForm;
	}
	
	public void submit() {
		loginForm.findElement(By.cssSelector("input[type='submit']"))
				.click();
	}
	
	public mtLoginForm username(String name) {
		loginForm.findElement(By.cssSelector("input[name='user_name']"))
				.sendKeys(name);
		return this;
	}
	
	public mtLoginForm password(String password) {
		loginForm.findElement(By.cssSelector("input[name='user_password']"))
				.sendKeys(password);
		return this;
	}
	
}
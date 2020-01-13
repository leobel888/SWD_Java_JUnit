package swb.ch05pageobjects.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mtLoginF {
	
//	@FindBy(id = "user_name")
	private WebElement user_name;
	
	@FindBy(name = "user_password")
	private WebElement password;
	
	@FindBy(css = "label[class=remember-me-label]")
	private WebElement label;
	
	@FindBy(css = "input[type=submit]")
	private WebElement submit;
	
	public void loginFor(String name, String password) {
		this.user_name.sendKeys(name);
		this.password.sendKeys(password);
		this.label.click();
		this.submit.click();
	}
	
}
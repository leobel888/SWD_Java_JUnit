package swb.mtf.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Path("/login")
@Verify(title = "login", xpath = "//h2[text()='Login here']")

public class mtfLogin {
	
	@FindBy(name = "user_name")
	private WebElement name;
	@FindBy(name = "user_password")
	private WebElement password;
	@FindBy(css = "label[class=remember-me-label]")
	private WebElement label;
	@FindBy(css = "input[type=submit]")
	private WebElement submit;
	
	public void loginInfo(String name, String password) {
		this.name.sendKeys(name);
		this.password.sendKeys(password);
		this.label.click();
	}
	
	public void submit(){
		this.submit.click();
	}
	
	public WebElement getLabel() {
		return this.label;
	}
	
}
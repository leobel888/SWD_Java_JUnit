package swb.mtf.trainers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import swb.mtf.pagefactory.Path;
import swb.mtf.pagefactory.Verify;

@Path("/trainer")
@Verify(title = "trainer")

public class mtfTrainers {
	
	@FindBy(id = "type")
	private WebElement type;
 
	@FindBy(id = "level")
	private WebElement level;
 
	@FindBy(id = "step")
	private WebElement step;
 
	@FindBy(id = "start")
	private WebElement start;
	
	@FindBy(id = "response")
	private WebElement response;
	
 	public void selectType(String type) {
		Select selectedType = new Select(this.type);
		selectedType.selectByVisibleText(type);
	}
	
	public void selectLevel(String level) {
		Select selectedLevel = new Select(this.level);
		selectedLevel.selectByVisibleText(level);
	}
	
	public void assignStep(String step) {
		this.step.clear();
		this.step.sendKeys(step);
	}
	
	public void clickStart() {
		this.start.click();
	}
	
	public void putAnswer(String response) {
		this.response.sendKeys(response);
	} 
}




 
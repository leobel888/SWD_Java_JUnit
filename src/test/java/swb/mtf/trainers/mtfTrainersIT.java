package swb.mtf.trainers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swb.framework.WebDriverRunner;
import swb.mtf.login.mtfLogin;
import swb.mtf.pagefactory.LoadingPageFactory;
import swb.mtf.mainMenu;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;

import javax.inject.Inject;
import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class mtfTrainersIT<W extends WebDriver & HasInputDevices> {
	@Inject
    private W driver;
	
	private void UserloginProcess() throws Exception {
		
		mtfLogin login = LoadingPageFactory.get(driver, mtfLogin.class);
		login.loginInfo("Demo2", "12345678");
		login.getLabel();
		login.submit(); 
	}
	
	/*	- Scenario: After Login the user should be able to open url page "Trainers", 
					set up mode for task, get expression, put the answer  
						
		- Given: The user is on The Home Page
			AND: The user is log out 
		
		-  When: The user go to login Page url
			AND: The user input name (Demo2), password (12345678)
			AND: The user put label "Remember me for 2 weeks"
		-  Then: The user is log in 	
		
		-  When: The user navigate to url page "Trainers"	
		-  Then: The user on the "Trainers" page	
			
		-  When: The user select type "Addition", level "Brothers", step 3 
			AND: The user press Start
			AND: in the answer field user input answer (number)	
		 - Then: The user get expression	
			AND: The numbers is on the field
		
		-  When: The user press "Enter"
		 - Then: the answer fiels is empty
		 - AND:	 The user get the next expression
	
	 */
	@Test
	public void TrainersProcess() throws Exception {
		
		UserloginProcess();

		mtfTrainers trainer = LoadingPageFactory.get(driver, mtfTrainers.class);
		
		trainer.selectType("Addition");
		trainer.selectLevel("Brothers");
		trainer.assignStep("3");
		trainer.clickStart();
		trainer.putAnswer("123");
		
		driver.getKeyboard().pressKey(Keys.ENTER); // #F submit the form
        driver.getKeyboard().releaseKey(Keys.ENTER); 
		
		/* driver
				.switchTo().activeElement()// #D change to the currently active element, in this case the checkbox
				.sendKeys("256"); // #E press space to check the box */
		
		/* mainMenu menu = new mainMenu();
		menu.clickMenu("HOME", driver);
		menu.clickMenu("PROFILE", driver);
		menu.clickMenu("DASHBOARD", driver);
		menu.clickMenu("MY NOTES", driver);
		menu.clickMenu("TRAINERS", driver);
		menu.clickMenu("PAGES", driver);  */

	}
}
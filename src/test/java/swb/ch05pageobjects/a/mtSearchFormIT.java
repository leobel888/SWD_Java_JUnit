package swb.ch05pageobjects.a;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URI;

@RunWith(WebDriverRunner.class)
public class mtSearchFormIT {

    @Inject
    private WebDriver driver;
    @Inject
    private URI baseUrl;

    @Test
    public void search() throws Exception {

        driver.get(baseUrl + "/");

        mtSearchForm searchForm = new mtSearchForm(driver);

        searchForm.setQuery("funny cats");
        searchForm.submit();
    }
}

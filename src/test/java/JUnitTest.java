import fr.zeniry.academywass.Enum.Browser;
import fr.zeniry.academywass.PageObjects.LoginPage;
import fr.zeniry.academywass.config.Properties;
import fr.zeniry.academywass.manager.WebDriverManager;
import org.testng.annotations.*;

import java.util.Objects;

public class JUnitTest {
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional String browser){
        //if(!Objects.isNull(browser)) Properties.Config.setBrowser(browser);
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
    }

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.NavigateTo();
        loginPage.ClickOnUser("UTILISATEUR");
        loginPage.setLogin("tester1");
        loginPage.setPassword("tester1");
        loginPage.clickOnLogin();
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().quit();
    }

}

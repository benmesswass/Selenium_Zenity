package fr.zenity.academywass;

import fr.zenity.academywass.Enum.Browser;
import fr.zenity.academywass.pageObjects.LoginPage;
import fr.zenity.academywass.config.Properties;
import fr.zenity.academywass.manager.WebDriverManager;
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
        loginPage.ClickOnUserType("UTILISATEUR");
        loginPage.setLogin("tester1");
        loginPage.setPassword("tester1");
        loginPage.clickOnLogin();
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().quit();
    }

}

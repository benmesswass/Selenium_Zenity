package fr.zenity.academywass.runner;

import fr.zenity.academywass.Enum.Browser;
import fr.zenity.academywass.config.Properties;
import fr.zenity.academywass.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

import java.util.Objects;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional String browser){
        System.out.println("---------------------------------------------------------------------------------n");
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
        System.out.println("-------------------------------INIT--------------------------------------------------n");
    }


    @AfterMethod
    public void tearDown() {
        System.out.println("-------------------------------IN TEAR SOWN--------------------------------------------------n");
        WebDriverManager.getInstance().quit();
        System.out.println("-------------------------------INIT--------------------------------------------------n");
    }
}

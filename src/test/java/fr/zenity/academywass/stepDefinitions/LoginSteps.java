package fr.zenity.academywass.stepDefinitions;

import fr.zenity.academywass.pageObjects.LoginPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class LoginSteps implements En {

    private WebDriver driver;
    //private LoginPage loginPage= new LoginPage();

    public LoginSteps(LoginPage loginPage) {
        Given("^user is on the login page$", () -> {
            //System.out.println("Given");
            loginPage.NavigateTo();
        });

        When("^user is logging-in with \"([^\"]*)\" \"([^\"]*)\"$", (String username, String password) -> {
            loginPage.setLogin(username);
            loginPage.setPassword(password);
            loginPage.clickOnLogin();
            });

        Then("^he should be at the home page$", () -> {
            loginPage.checkLoginPassed();
        });


    }
}

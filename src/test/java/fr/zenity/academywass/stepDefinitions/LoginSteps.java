package fr.zenity.academywass.stepDefinitions;

import fr.zenity.academywass.pageObjects.LoginPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class LoginSteps implements En {

    private WebDriver driver;
    //private LoginPage loginPage= new LoginPage();

    public LoginSteps(LoginPage loginPage) {
        Given("^user is on the login page$", () -> {
            System.out.println("first Given");
            //System.out.println("first Given");
            loginPage.NavigateTo();
            System.out.println("first Given");

        });

        When("^user is logging-in with \"([^\"]*)\" \"([^\"]*)\"$", (String username, String password) -> {
            System.out.println("first Given");
            System.out.println("first when");
            loginPage.setLogin(username);
            loginPage.setPassword(password);
            loginPage.clickOnLogin();
            System.out.println("first Given");
        });

        Then("^he should be at the home page$", () -> {
            System.out.println("first then");
            loginPage.checkLoginPassed();
        });

        Then("^he should not be able to go to the home page$", () -> {
            System.out.println("wrong then");
            loginPage.checkLoginFailed();
        });
    }
}

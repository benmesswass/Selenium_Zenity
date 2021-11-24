package fr.zenity.academywass.pageObjects;

import org.testng.Assert;
import fr.zenity.academywass.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment()+"/login";

    @FindBy(className = "MuiTab-wrapper")
    private List<WebElement> userEntrepriseBtn;

    @FindBy(css = "input[id='user-login']")
    private WebElement login;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[class='MuiButtonBase-root MuiButton-root MuiButton-contained jss45 MuiButton-containedPrimary MuiButton-fullWidth']")
    private WebElement loginBtn;

    @FindBy (css = "button[aria-label='open drawer']")
    private WebElement openDrawerBtn;

    @FindBy (css = "p[class='MuiFormHelperText-root Mui-error']")
    private WebElement invalidPasswordMsg;


public void NavigateTo(){driver.get(URL);}

public void ClickOnUserType(String type){
    clickOn(userEntrepriseBtn.stream()
            .filter(element -> element.getText().equals(type))
            .findFirst()
            .orElseThrow(()->new RuntimeException("Element "+ type + " not Found")));
}

    public void setLogin(String user) {
        wait.until(ExpectedConditions.visibilityOf(login));
        login.sendKeys(user);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        clickOn(loginBtn);
    }

    public void checkLoginPassed() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(openDrawerBtn));
        //Assert.assertTrue(openDrawerBtn.isDisplayed());
    }

    public void checkLoginFailed() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(invalidPasswordMsg));
        //String wrongMsg = "Le couple login / mot de passe saisi est incorrect.";
        //Assert.assertEquals(wrongMsg, invalidPasswordMsg.getText());
    }

}

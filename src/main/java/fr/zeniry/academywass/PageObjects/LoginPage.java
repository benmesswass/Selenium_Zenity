package fr.zeniry.academywass.PageObjects;

import fr.zeniry.academywass.config.Properties;
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
    s
public void NavigateTo(){driver.get(URL);}

public void ClickOnUser(String type){
    clickOn(userEntrepriseBtn.stream()
            .filter(element -> element.getText().equals(type))
            .findFirst()
            .orElseThrow(()->new RuntimeException("Element "+ type + " not Found")));
}

public void setLogin(String user){
    wait.until(ExpectedConditions.visibilityOf(login));
    login.sendKeys(user);
}

public void setPassword(String password){
    wait.until(ExpectedConditions.visibilityOf(passwordInput));
    passwordInput.sendKeys(password);
}

public void clickOnLogin(){
    clickOn(loginBtn);
}

}

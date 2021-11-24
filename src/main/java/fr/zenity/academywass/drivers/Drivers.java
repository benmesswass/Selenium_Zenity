package fr.zenity.academywass.drivers;

import org.openqa.selenium.WebDriver;

public interface Drivers {

    void quit();
    void close();
    WebDriver getDriver();
}

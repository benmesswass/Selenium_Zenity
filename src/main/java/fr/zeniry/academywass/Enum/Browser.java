package fr.zeniry.academywass.Enum;

import fr.zeniry.academywass.config.Properties;

import java.util.Objects;

public enum Browser {

    CHROME ("chrome"),
    FIREFOX("gecko");

    private final String webDriverProperty;

    Browser(String browserType) {
        webDriverProperty = Objects.requireNonNull(browserType);
    }

    public String getBrowserName(){return webDriverProperty.equals("gecko") ? "firefox" : webDriverProperty;}

    public String webDriverProp(){return String.format("webdriver.%s.driver", webDriverProperty);}

    public String webDriverPath(){return Properties.Config.getWebDriverPath();}

}


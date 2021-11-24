package fr.zenity.academywass.Enum;

import fr.zenity.academywass.config.PropertiesLoader;

import java.util.Objects;

public enum Urls {
    PRODUCTION,
    PREPROD,
    INTEGRATION;

    private String environment;

    public String getEnvironment(){

        if(Objects.isNull(environment))
            PropertiesLoader
                    .of("environments")
                    .forEach((String key, String value)->Urls.valueOf(key.toUpperCase()).setUrl(value));

        return environment;
    }

    private void setUrl(String url){
        environment = url;
    }

}

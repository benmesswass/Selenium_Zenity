package fr.zenity.academywass.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        //monochrome = false,
        glue = {"fr.zenity.academywass.stepDefinitions", "fr/zenity/academywass/pageObjects"},
        plugin = {"pretty"}
)


public class CucumberTestRunner extends BaseRunner {
}

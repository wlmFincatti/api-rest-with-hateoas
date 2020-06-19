package br.com.wfincatti.userapi;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        glue = "br.com.wfincatti.userapi.stepdefinitions",
        features = "src/test/resources/features",
        strict = true
)
@RunWith(Cucumber.class)
public class CucumberTest {
}

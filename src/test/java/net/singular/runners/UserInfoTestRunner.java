package net.singular.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/UserInfo.feature",
        glue = "",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class UserInfoTestRunner {
}


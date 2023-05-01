package ru.egor.qa.selenidetest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        glue = {"ru.egor.qa.selenidetest.steps"},
        features = {"src/test/resources/feature"},
        tags = "@All"
)
public class RunnerProjectTest {
}

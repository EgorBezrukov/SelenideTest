package ru.egor.qa.selenidetest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        glue = {"ru.egor.qa.selenidetest.steps"},
        features = {"src/test/resources/feature"},
        tags = "@CheckStatusCode200"
)
public class RunnerProjectTest {
}

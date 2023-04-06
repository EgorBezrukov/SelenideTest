package ru.egor.qa.selenidetest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"ru.egor.qa.selenidetest.steps"},
        features = {"src/test/resources/feature"},
        tags = "@Test"
)
public class RunnerProjectTest {
}

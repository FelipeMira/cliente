package com.fiap.grupo.dois.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = { "com.fiap.grupo.dois.steps" }, format = {"pretty", "html:target/reports/cucumber/html",
        "json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml"})
public class CucumberIntegrationIT {
}

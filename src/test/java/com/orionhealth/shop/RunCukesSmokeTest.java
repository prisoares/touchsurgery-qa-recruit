package com.orionhealth.shop;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/orionhealth/shop", tags = "@smoke")
public class RunCukesSmokeTest {

}

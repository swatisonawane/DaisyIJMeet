package com.testingshastra.util;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features="src/test/resources/Features", glue="com.testingshastra.stepdefinations",
//			      tags="@Regression", dryRun=true)
@CucumberOptions(features="src/test/resources/Features", glue="com.testingshastra.stepdefinations")
public class RunnerTest extends AbstractTestNGCucumberTests {

}

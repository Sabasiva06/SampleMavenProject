package org.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\jira.feature" }, glue = {
		"org.step" }, dryRun = false, monochrome = true)

public class TestRunner {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Rest Assured ");
		System.out.println("hii");
		System.out.println("dkbdbbssckn");
		
	}

}

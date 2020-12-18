package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.sun.tools.xjc.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import groovyjarjarpicocli.CommandLine.Spec;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\jira.feature" }, glue = {
		"org.step" }, dryRun = false, monochrome = true)

public class TestRunner {

	@AfterClass
	public void afterClass() {
		System.out.println("update");
		Driver.getBuildID();
		System.out.println("clone");
		System.out.println("update");
		Driver.getBuildID();
		System.out.println("clone");
	}
}

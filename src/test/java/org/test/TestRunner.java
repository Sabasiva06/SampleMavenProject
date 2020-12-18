package org.test;

<<<<<<< HEAD
import org.junit.AfterClass;
=======
import org.junit.BeforeClass;
>>>>>>> 8a4a7bb384ecbc221dcef8336a5d724dc5dddab4
import org.junit.runner.RunWith;

import com.sun.tools.xjc.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import groovyjarjarpicocli.CommandLine.Spec;

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

package org.step;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.path.OutputData;
import org.path.RequestSpe;
import org.requestspec.InputBody;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class StepDefenition {
	RequestSpecification body;
	Response post;
	OutputData as;
	Response response;
	String id;
	String key;
	String self;
	String jiraIssueId;

	@Given("user need to add payload {string},{string}")
	public void user_need_to_add_payload(String summary, String description) throws FileNotFoundException, IOException {
		body = RestAssured.given().log().all().spec(InputBody.requestSpecBuilder())
				.body(RequestSpe.creatPost(summary, description));

	}

	@When("User need to pass post method")
	public void user_need_to_pass_post_method() {
		post = body.when().post("/rest/api/2/issue/");

	}

	@Then("User used validate status code {int}")
	public void user_used_validate_status_code(Integer int1) {
		OutputData as = post.then().assertThat().statusCode(int1).extract().as(OutputData.class);
		id = as.getId();
		key = as.getKey();
		self = as.getSelf();
		System.out.println("ID :" + id);
		System.out.println("Key :" + key);
		System.out.println("Self :" + self);

	}

	@Then("User should validate self data {string}")
	public void user_should_validate_self_data(String string) {
		Assert.assertTrue("Verify words contains in self", self.contains(string));

	}

	@Given("user to update payload {string},{string} and {string}")
	public void user_to_update_payload_and(String summary, String description, String string3)
			throws FileNotFoundException, IOException {
		body = RestAssured.given().spec(InputBody.requestSpecBuilder())
				.body(RequestSpe.UpdatePost(summary, description));

	}

	@When("User need to pass http method")
	public void user_need_to_pass_http_method() {

		post = body.when().put("/rest/api/2/issue/" + key);

	}

	@Then("User should validate update status code {int}")
	public void user_should_validate_update_status_code(Integer int1) {
		ResponseBodyExtractionOptions body2 = post.then().assertThat().statusCode(int1).extract().body();
		System.out.println(body2);

	}

	@When("user should add  http method for gettting all issues")
	public void user_should_add_http_method_for_gettting_all_issues() throws FileNotFoundException, IOException {

		response = RestAssured.given().log().all().spec(InputBody.requestSpecBuilder()).get("/rest/api/2/search");

	}

	@Then("user should verify the Status code {int}")
	public void user_should_verify_the_Status_code(Integer int1) {
		ResponseBodyExtractionOptions body2 = response.then().assertThat().statusCode(int1).extract().body();
		System.out.println(body2.asString());

	}

	@Given("user need to add  {string}")
	public void user_need_to_add(String string) {

	}

	@When("User need to pass http method as delete")
	public void user_need_to_pass_http_method_as_delete() {

	}

	@Then("User used validate delete status code {int} in jira")
	public void user_used_validate_delete_status_code_in_jira(Integer int1) {

	}

	// RequestSpecification body;
	// Response post;
	// OutputData as;
	// Response response;
	// String id;
	// String key;
	// String self;
	// String jiraIssueId;
	//
	// @Given("user need to add payload {string},{string}")
	// public void user_need_to_add_payload(String summary, String description)
	// throws FileNotFoundException, IOException {
	// body = RestAssured.given().spec(InputBody.requestSpecBuilder())
	// .body(RequestSpe.creatPost(summary, description));
	//
	// }
	//
	// @When("User need to pass post method")
	// public void user_need_to_pass_post_method() {
	// post = body.when().post("/rest/api/2/issue/");
	// }
	//
	// @Then("User used validate status code {int}")
	// public void user_used_validate_status_code(Integer int1) {
	//
	// OutputData as =
	// post.then().assertThat().statusCode(int1).extract().as(OutputData.class);
	// id = as.getId();
	// key = as.getKey();
	// self = as.getSelf();
	// System.out.println("ID :" + id);
	// System.out.println("Key :" + key);
	// System.out.println("Self :" + self);
	//
	// }
	//
	// @Then("User should validate self data {string}")
	// public void user_should_validate_self_data(String string) {
	//
	// Assert.assertTrue("Verify words contains in self", self.contains(string));
	//
	// }
	//
	// @Given("user need to update payload {string},{string} and {string}")
	// public void user_need_to_update_payload(String summary, String
	// description,String issueId)
	// throws FileNotFoundException, IOException {
	// jiraIssueId=issueId;
	// body = RestAssured.given().spec(InputBody.requestSpecBuilder())
	// .body(RequestSpe.UpdatePost(summary, description));
	// }
	//
	// @When("User need to pass http method")
	// public void user_need_to_pass_http_method() {
	// post = body.when().put("/rest/api/2/issue/"+key);
	//
	// }
	// @When("user should verify the Status code {int}")
	// public void user_should_verify_the_Status_code1(Integer int1) {
	// ResponseBodyExtractionOptions body2 =
	// response.then().assertThat().statusCode(int1).extract().body();
	// System.out.println(body2.asString());
	// }
	//
	// @When("user should add the getIssueAPI with http method")
	// public void user_should_add_the_getIssueAPI_with_http_method() throws
	// FileNotFoundException, IOException {
	// response =
	// RestAssured.given().spec(InputBody.requestSpecBuilder()).get("/rest/api/2/search");
	//
	// }
	//
	// @When("user should verify the Status code {int}")
	// public void user_verify_the_code(Integer int1) {
	// ResponseBodyExtractionOptions body2 =
	// response.then().assertThat().statusCode(int1).extract().body();
	// System.out.println(body2.asString());
	// }
	//
	// @Given("user need to add {string}")
	// public void user_need_to_add(String issueId) throws FileNotFoundException,
	// IOException {
	// jiraIssueId=issueId;
	// body = RestAssured.given().spec(InputBody.requestSpecBuilder());
	//
	// }
	//
	// @When("User need to pass delete http method")
	// public void user_need_to_pass_delete_http_method() {
	// post = body.when().post("/rest/api/3/issue/"+jiraIssueId);
	//
	// }
	//
	// @Given("user need to add payload {string},{string}")
	// public void user_need_to_add_payload_and(String summary, String description)
	// throws FileNotFoundException, IOException {
	// body =
	// RestAssured.given().spec(InputBody.requestSpecBuilder()).body(RequestSpe.UpdatePost(summary,
	// description));
	// }
	//
	// @When("User need to pass http method")
	// public void user_need_to_pass_http_method() {
	// post = body.when().post("/rest/api/2/issue/"+as.getId());
	// }
	//
	// @Given("user need to add {string}")
	// public void user_need_to_add(String string) {
	//
	//
	// }

}

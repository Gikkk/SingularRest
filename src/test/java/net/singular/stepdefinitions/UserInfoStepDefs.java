package net.singular.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.singular.api.responsemodel.UserInfoResponse;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static net.singular.common.Utils.generateToken;

public class UserInfoStepDefs {

    RequestSpecification requestSpecification;
    UserInfoResponse userInfoResponse = new UserInfoResponse();

    @Given("a session is established with username {string} and password {string}")
    public void aSessionIsEstablished(String username, String password) {
        requestSpecification = given()
                .header("Authorization", "Bearer " + generateToken(username, password));
    }

    @Given("an invalid session is established")
    public void anInvalidSessionIsEstablished() {
        requestSpecification = RestAssured.given();
    }

    @When("a user requests their information")
    public void aUserRequestsTheirInformation() {
        userInfoResponse = requestSpecification
                .get("/info")
                .then()
                .extract()
                .as(UserInfoResponse.class);
    }


    @Then("the user information should be retrieved successfully with message {string}")
    public void theUserInfoShouldBeRetrievedSuccessfully(String expectedMessage) {
        Assert.assertEquals(expectedMessage, userInfoResponse.getMessage());
    }


    @Then("the user information request should fail")
    public void theUserInfoRequestShouldFail() {
        Assert.assertNull(userInfoResponse.getMessage());
    }

}

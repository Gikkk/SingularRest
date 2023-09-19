package net.singular.hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class CucumberHooks {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://ayco69dbm3.execute-api.us-east-1.amazonaws.com/singular_qa";
    }
}


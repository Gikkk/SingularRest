package net.singular.common;

import io.restassured.http.ContentType;
import net.singular.api.requestmodel.TokenRequest;
import net.singular.api.responsemodel.TokenResponse;

import static io.restassured.RestAssured.given;

public class Utils {
    public static String generateToken(String username, String password){
        TokenResponse tokenResponse = given()
                .contentType(ContentType.JSON)
                .body(new TokenRequest(username, password))
                .post("/authorize")
                .then()
                .statusCode(200)
                .extract()
                .as(TokenResponse.class);

        return tokenResponse.getToken();
    }
}

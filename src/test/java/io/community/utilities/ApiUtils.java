package io.community.utilities;

import io.community.step_deffinitions.Login_stepdef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response request(String URI,String request ) {
     Response response = given().headers(
             "Authorization",
             "Bearer " + Login_stepdef.token,
             "Content-Type", "application/json").body(request).when().post(URI);
     return response;
 }
}

package io.community.step_deffinitions;


import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import java.time.LocalDate;
import static io.restassured.RestAssured.*;

@Slf4j
public class Login_stepdef {
  public static   String token ="";
    Response response;
    JsonPath jsonPath=null;
    LocalDate date=LocalDate.now();
    String oldPassword="";
    String newPassword="";


    @Given("user sign in with valid credentials {string} {string}")
    public void user_sign_in_with_valid_credentials(String username, String password) {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\""+username+"\\\", password: \\\""+password+"\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));
        jsonPath =response.jsonPath();
        token= jsonPath.getString("data.signInUser.accessToken");
            log.info("accessToken "+token);


    }

    @Given("user sign in with valid credentials to Dev Environment  {string} {string}")
    public void user_sign_in_with_valid_credentials_to_dev_environment(String username, String password) {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\""+username+"\\\", password: \\\""+password+"\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("devURI"));
        jsonPath =response.jsonPath();
        token= jsonPath.getString("data.signInUser.accessToken");

        log.info("accessToken "+token);
    }

    @Given("user sign in with valid credentials {string} username {string} password in {string} envirenment")
    public void user_sign_in_with_valid_credentials_username_password_in_envirenment(String username, String password, String env) {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\""+username+"\\\", password:\\\""+password+"\\\"\\n\\tcaptchaResponseToken:\\\"8ff59b3f88294dc888fb1e07170ffc9d\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";

        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get(env));
        jsonPath =response.jsonPath();
        token= jsonPath.getString("data.signInUser.accessToken");

        log.info("accessToken "+token);
    }


    @Then("Status Code Should be {int}")
    public void satus_Code_Should_be(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());
    }

    @When("User send request for my profile request")
    public void user_send_request_for_latest_quests() {
       String requestInformation ="{\"query\":\"query{\\n\\tmyProfile{\\n\\t\\tnotificationGroups\\n\\t}\\n}\"}";
       response= given().headers(
                "Authorization",
                "Bearer "+token,
                "Content-Type", "application/json").body(requestInformation).when().post(ConfigurationReader.get("testURI"));


        log.info(response.body().prettyPrint());

    }
    @Given("user try to sign in invalid userName {string} {string}")
    public void user_try_to_sign_in_invalid_user_name(String username, String password) {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\""+username+"\\\", password: \\\""+password+"\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));

        log.info(response.body().prettyPrint());
    }




    @Then("User should get {string} message")
    public void user_should_get_message(String expectedResult) {
        jsonPath =response.jsonPath();
       String actualResult= jsonPath.getString("errors.message");
       Assert.assertTrue(actualResult.contains(expectedResult));

        log.info("actualResult = " + actualResult);
    }

    @Given("user try to sign in invalid password {string} {string}")
    public void user_try_to_sign_in_invalid_password(String username, String password) {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\""+username+"\\\", password: \\\""+password+"\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));

        log.info(response.body().prettyPrint());
    }


    @Given("user sign in with valid credentials new password")
    public void user_sign_in_with_valid_credentials_new_password() {

        String body="{\"query\":\"query {\\n  signInUser(username: \\\"passwordTest\\\", password: \\\"Test12345\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";

        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));
        jsonPath=response.jsonPath();
        token= jsonPath.getString("data.signInUser.accessToken");

    }
    @When("user send request for Change Password")
    public void user_send_request_for_change_password() {

      newPassword="Test"+String.valueOf(date.getYear())+String.valueOf(date.getDayOfMonth());

        String request="{\"query\":\"mutation{\\n\\tupdateMyPassword(\\n\\t oldPassword:\\\"Test12345\\\"\\n\\tnewPassword : \\\""+newPassword+"\\\"\\n\\t)\\n}\"}";

      response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();


    }
    @Then("response should be {string}")
    public void response_should_be(String expectedResult) {
       log.info("updateMyPassword= " + jsonPath.getString("data.updateMyPassword"));
        Assert.assertEquals(jsonPath.getString("data.updateMyPassword"),expectedResult);
    }
    @Then("user should not be able to login with old password")
    public void user_should_not_be_able_to_login_with_old_password() {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\"passwordTest\\\", password: \\\"Test12345\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";

        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));
       jsonPath=response.jsonPath();
        String actualResult= jsonPath.getString("errors.message");
        Assert.assertTrue(actualResult.contains("Bad credentials"));


    }
    @Then("user sign in with new password")
    public void user_sign_in_with_new_password() {
        String body="{\"query\":\"query {\\n  signInUser(username: \\\"passwordTest\\\", password: \\\""+newPassword+"\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";

        response = given().accept(ContentType.JSON).body(body).when()
                .post(ConfigurationReader.get("testURI"));
        jsonPath=response.jsonPath();
        token= jsonPath.getString("data.signInUser.accessToken");

    }

    @Then("user re-enters old password")
    public void user_re_enters_old_password() {

        String request="{\"query\":\"mutation{\\n\\tupdateMyPassword(\\n\\t oldPassword:\\\""+newPassword+"\\\"\\n\\tnewPassword : \\\"Test12345\\\"\\n\\t)\\n}\"}";

        response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();

    }




}

package io.community.step_deffinitions;

import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

@Slf4j
public class Users_stepdef {
    Response response=null;
    JsonPath jsonPath=null;
    int beforeOrganizedTournamentCount=0;
    int beforeTeamsCount=0;


    @When("user should be able to send request for user information")
    public void user_should_be_able_to_send_request_for_user_information() {
     String request="{\"query\":\"query{\\n\\tgetAdditionalUserInformation{\\n\\t\\taverageTeamSize\\n\\t\\tteamsCount\\n\\t\\tfavouriteGamesCount\\n\\t\\tjoinedTournamentCount\\n\\t\\torganizedTournamentCount\\n\\t}\\n}\"}";
     response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
     jsonPath=response.jsonPath();
      log.info("userInformation= " +response.prettyPrint());


    }
    @Then("user should be able to see personal information data")
    public void user_should_be_able_to_see_personal_information_data() {
        Assert.assertTrue(!jsonPath.getString("data.getAdditionalUserInformation.averageTeamSize").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getAdditionalUserInformation.teamsCount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getAdditionalUserInformation.favouriteGamesCount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getAdditionalUserInformation.joinedTournamentCount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getAdditionalUserInformation.organizedTournamentCount").isEmpty());
         beforeOrganizedTournamentCount= Integer.parseInt(jsonPath.getString("data.getAdditionalUserInformation.organizedTournamentCount"));
         beforeTeamsCount= Integer.parseInt(jsonPath.getString("data.getAdditionalUserInformation.teamsCount"));
    }
    @Then("Organized Tournament Count should be an increase")
    public void organized_tournament_count_should_be_an_increase() {
        String request="{\"query\":\"query{\\n\\tgetAdditionalUserInformation{\\n\\t\\taverageTeamSize\\n\\t\\tteamsCount\\n\\t\\tfavouriteGamesCount\\n\\t\\tjoinedTournamentCount\\n\\t\\torganizedTournamentCount\\n\\t}\\n}\"}";
        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
        jsonPath=response.jsonPath();
        int afterOrganizedTournamentCount=Integer.parseInt(jsonPath.getString("data.getAdditionalUserInformation.organizedTournamentCount"));


        Assert.assertTrue(beforeOrganizedTournamentCount<afterOrganizedTournamentCount);

    }
    @When("user post request for create  a team")
    public void user_post_request_for_create_a_team() {
        Faker faker =new Faker();
        String createdTeamName= faker.name().fullName();

        String request="{\"query\":\"mutation{\\n\\tcreateTeam(\\n\\t\\tname: \\\""+createdTeamName+"\\\",\\n\\t\\tinviteeIds: [\\\"test_user_1\\\"],\\n\\t\\tinviteeEmails:[]\\n\\t){\\n\\t\\tid\\n\\t}\\n}\"}";
      response= ApiUtils.request(ConfigurationReader.get("devURI"),request);


    }
    @Then("Teams count should be an increase")
    public void teams_count_should_be_an_increase() {

        String request="{\"query\":\"query{\\n\\tgetAdditionalUserInformation{\\n\\t\\taverageTeamSize\\n\\t\\tteamsCount\\n\\t\\tfavouriteGamesCount\\n\\t\\tjoinedTournamentCount\\n\\t\\torganizedTournamentCount\\n\\t}\\n}\"}";
        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
        jsonPath=response.jsonPath();
        int afterTeamsCount=Integer.parseInt(jsonPath.getString("data.getAdditionalUserInformation.teamsCount"));
        Assert.assertTrue(beforeTeamsCount<afterTeamsCount);
    }

    @When("organizer send a request for registration question")
    public void organizer_send_a_request_for_registration_question() {
      String request="{\"query\":\"query{\\n\\tgetRegistrationQuestionsResponses(\\n\\ttournamentId:\\\"313568b1-5b14-4237-bbb4-9cd2b79c5f44\\\"\\n\\t)\\n\\t{\\n\\t\\tregistrationQuestionId\\n\\t\\tresponses{\\n\\t\\t\\tanswer\\n\\t\\t\\tquestion\\n\\t\\t}\\n\\t\\t\\n\\t}\\n}\"}";

      response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
      jsonPath=response.jsonPath();
      log.info("registration answers= " + jsonPath.getString("data.getRegistrationQuestionsResponses.responses"));


    }
    @Then("organizer should be able to see registration answers")
    public void organizer_should_be_able_to_see_registration_answers() {
      Assert.assertTrue(!jsonPath.getString("data.getRegistrationQuestionsResponses.responses").isEmpty());

    }
    @When("participant send a request for registration question")
    public void participant_send_a_request_for_registration_question() {
        String request="{\"query\":\"query{\\n\\tgetRegistrationQuestionsResponses(\\n\\ttournamentId:\\\"313568b1-5b14-4237-bbb4-9cd2b79c5f44\\\"\\n\\t)\\n\\t{\\n\\t\\tregistrationQuestionId\\n\\t\\tresponses{\\n\\t\\t\\tanswer\\n\\t\\t\\tquestion\\n\\t\\t}\\n\\t\\t\\n\\t}\\n}\"}";

        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
        jsonPath=response.jsonPath();
        log.info("registration answers= " + jsonPath.getString("data.getRegistrationQuestionsResponses.responses"));



    }
    @Then("participant should be able to see registration answers")
    public void participant_should_be_able_to_see_registration_answers() {
        Assert.assertTrue(!jsonPath.getString("data.getRegistrationQuestionsResponses.responses").isEmpty());
    }
    @When("user send a request for registration question")
    public void user_send_a_request_for_registration_question() {
        String request="{\"query\":\"query{\\n\\tgetRegistrationQuestionsResponses(\\n\\ttournamentId:\\\"313568b1-5b14-4237-bbb4-9cd2b79c5f44\\\"\\n\\t)\\n\\t{\\n\\t\\tregistrationQuestionId\\n\\t\\tresponses{\\n\\t\\t\\tanswer\\n\\t\\t\\tquestion\\n\\t\\t}\\n\\t\\t\\n\\t}\\n}\"}";

        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
        jsonPath=response.jsonPath();
        log.info("registration answers= " + jsonPath.getString("data.getRegistrationQuestionsResponses.responses"));

    }
    @Then("user should  be able to see registration answers")
    public void user_should_not_be_able_to_see_registration_answers() {
        Assert.assertTrue(!jsonPath.getString("data.getRegistrationQuestionsResponses.responses").isEmpty());
    }
    @Given("useraddd")
    public void useraddd() {
        int i=1;
        for (int j=1 ;j<=5000;j++) {
            String userName = "testUser" + i;
            String body = "{\"query\":\"query {\\n  signInUser(username: \\\"" + userName + "\\\", password: \\\"testUser1234\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
            response = given().accept(ContentType.JSON).body(body).when()
                    .post(ConfigurationReader.get("dev4URI"));
            jsonPath = response.jsonPath();
            String token = jsonPath.getString("data.signInUser.accessToken");

            log.info("accessToken " + token);

            String body2 = "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\"f13912f9-8991-4982-8c97-6634303d873e\\\",\\nteamId:\\\"test_user_" + i + "\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\"}";

            Response response = given().headers(
                    "Authorization",
                    "Bearer " +token,
                    "Content-Type", "application/json").body(body2).when().post(ConfigurationReader.get("dev4URI"));
            log.info(response.prettyPrint());
            i++;
        }

    }


}

package io.community.step_deffinitions;

import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Tournament_stepdef {

    Faker faker = new Faker();
    String multipleTournamentID="";
    String expectedStartTournamentErrorMessage="";
    String actualResult="";
    Response response=null;
    JsonPath jsonPath=null;
    String singleTournamentID=null;
    String singleBracketID=null;
    String singleBracketMatchID=null;



    @When("user post CreateTournament With Multiple Brackets")
    public void user_post_CreateTournament_With_Multiple_Brackets() {

        String request =" {\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\"swiss-1"+faker.name().firstName()+"\\\"\\n    bracketType: SWISS\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"autoapprove1\\\"\\n    description: \\\"testing by Bipek lkdsanflksdjnfşjsdanbfkjsdabfkjbsdakljfbsdakjfbsadkjbsdkajbfksadjbfksljadfksadjbfksajbdfksajdbflskajdbfksjdabfksajdbfksajdbfksdajbfksadjbfksjdbfksajdbksadjbfkasjbfksadjbksadjbksaljdbksajdbfksajbfalskjf\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 10\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: SWISS,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\tswissDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\tnumberOfTeams : 1,\\n        roundCount : 4,\\n\\t\\t\\t\\tswissScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\n\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n  }\\n}\"} ";

        response= ApiUtils.request(ConfigurationReader.get("testURI"),request);

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        jsonPath =response.jsonPath();

        multipleTournamentID=jsonPath.getString("data.createTournament.id");
        System.out.println("multipleTournamentID = " + multipleTournamentID);
    }
    @When("user post CreateTournament With Multiple Brackets for Dev Environment")
    public void user_post_CreateTournament_With_Multiple_Brackets_for_Dev_Environment() {

        String request =" {\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\"swiss-1"+faker.name().firstName()+"\\\"\\n    bracketType: SWISS\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"autoapprove1\\\"\\n    description: \\\"testing by Bipek lkdsanflksdjnfşjsdanbfkjsdabfkjbsdakljfbsdakjfbsadkjbsdkajbfksadjbfksljadfksadjbfksajbdfksajdbflskajdbfksjdabfksajdbfksajdbfksdajbfksadjbfksjdbfksajdbksadjbfkasjbfksadjbksadjbksaljdbksajdbfksajbfalskjf\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 10\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: SWISS,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\tswissDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\tnumberOfTeams : 1,\\n        roundCount : 4,\\n\\t\\t\\t\\tswissScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\n\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n  }\\n}\"} ";

        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        jsonPath =response.jsonPath();

        multipleTournamentID=jsonPath.getString("data.createTournament.id");
        System.out.println("multipleTournamentID = " + multipleTournamentID);
    }

    @When("user try to start tournament")
    public void user_try_to_start_tournament() {
        String request ="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+multipleTournamentID+"\\\") {\\n    id,\\n    \\n  }\\n}\"}";

        response=ApiUtils.request(ConfigurationReader.get("testURI"),request);

        jsonPath= response.jsonPath();

        expectedStartTournamentErrorMessage=jsonPath.getString("errors.message");

    }

    @Then("user should get message Bracket is empty message")
    public void user_should_get_Bracket_is_empty_message() {
        System.out.println(expectedStartTournamentErrorMessage);
        Assert.assertTrue(expectedStartTournamentErrorMessage.contains("not Found"));
    }

    @When("user send request for upcoming tournament")
    public void user_send_request_for_upcoming_tournament() {
       String request="{\"query\":\"mutation{\\n\\t\\n\\taddParticipant (\\ntournamentId:\\\"310afdd9-4e86-46e7-8ede-c99380b04233\\\",\\nteamId:\\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"mrbrooks\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t}\\n\\t\\n\\t\\n}\\n\"}";
       response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
       jsonPath= response.jsonPath();
       actualResult = jsonPath.getString("data.addParticipant.participants.id");

    }
    @Then("participant ids should include added team id")
    public void participant_ids_should_include_added_team_id() {
       String expectedResult = "4bb60918-e961-40a2-949a-ff1ee7443c1e";
       Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @When("user send request for Unenroll from Tournament")
    public void user_send_request_for_unenroll_from_tournament() {
     String request="{\"query\":\"mutation{\\n\\tremoveParticipant(tournamentId:\\\"310afdd9-4e86-46e7-8ede-c99380b04233\\\"\\n\\tteamId:\\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\"\\n\\t)\\n\\t{\\n\\t\\tid\\n\\t\\tparticipants{\\n\\t\\t\\tid\\n\\t\\t\\n\\t\\t}\\n\\t}\\n\\t\\n}\"}";

        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());
        jsonPath= response.jsonPath();

        actualResult = jsonPath.getString("data.removeParticipant.participants.id");
    }
    @Then("added team id should be deleted from participant id list")
    public void added_team_id_should_deleted_from_participant_id_list() {
        String expectedResult = "4bb60918-e961-40a2-949a-ff1ee7443c1e";
        Assert.assertFalse(actualResult.contains(expectedResult));
    }

    @Given("user send request for past tournament detail id {string}")
    public void user_send_request_for_past_tournament_detail_id(String tournamentID) {
      String request="{\"query\":\"query {\\n  tournament(id:\\\""+tournamentID+"\\\"){\\n\\t\\tid\\n\\t\\tparticipants{\\n\\t\\t\\tid\\n\\t\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tautoApprovalMinute\\n\\t}\\n}\"}";

     response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
      jsonPath =response.jsonPath();
    }
    @Then("user should be able to see participants")
    public void user_should_be_able_to_see_participants() {
        System.out.println("participants= "+jsonPath.getString("data.tournament.participants.id"));
       Assert.assertTrue(!jsonPath.getString("data.tournament.participants.id").isEmpty());
    }
    @Then("tournament approval should {string}")
    public void tournament_approval_should(String status) {
        System.out.println("isAutoApprovalEnabled = " + jsonPath.getString("data.tournament.isAutoApprovalEnabled"));
        Assert.assertEquals(jsonPath.getString("data.tournament.isAutoApprovalEnabled"),status);


    }
    @Given("organizer create tournament with single elemination")
    public void organizer_create_tournament_with_single_elemination() {
        String alias= faker.name().firstName()+ApiUtils.date();
        String request ="{\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\""+alias+"\\\"\\n    bracketType: SINGLE_ELIMINATION\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2022-11-19T21:59:08.454Z\\\"\\n    name: \\\"CreatedForRewardCheckOnAPI\\\"\\n    description: \\\"asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 10\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"testBrk\\\",\\n        bracketStartDate: \\\"2022-03-16T21:59:08.454Z\\\",\\n        bracketType: SINGLE_ELIMINATION,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\t\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n\\t\\tbracketType\\n\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t}\\n  }\\n}\"}";

        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());
         jsonPath=response.jsonPath();
         singleTournamentID=jsonPath.getString("data.createTournament.id");
        String test=jsonPath.getString("data.createTournament.bracketList.id");
        System.out.println("singleBracketID = " + singleBracketID);
        singleBracketID= test.substring(1,37);
        System.out.println("test = " + test);


    }
    @Given("Add participant mrbrooks2")
    public void add_participant_mrbrooks2() {
        String request= "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+singleTournamentID+"\\\",\\nteamId:\\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\\n\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());

    }
    @Given("Add participant mrbrooks")
    public void add_participant_mrbrooks() {
       String request = "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+singleTournamentID+"\\\",\\nteamId:\\\"cdf0746b-e72d-4b17-8a38-7964f37b87cb\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\\n\"}";
       response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());
    }
    @Given("organizer generates bracket")
    public void organizer_generates_bracket() {
     String request ="{\"query\":\"mutation {\\n  generateBracket(\\n    bracketId:\\\""+singleBracketID+"\\\", \\n    allowCheckedInOnly: false, \\n    participantIds: [\\\"cdf0746b-e72d-4b17-8a38-7964f37b87cb\\\", \\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\"]) \\n  {\\n    bracketInformation {id,bracketName,bracketType},\\n    eliminationBracketDetail {upperBracket {team1Id}, lowerBracket {team1Id}, bracketSize, bracketStatus}\\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());


    }
    @Given("organizer starts tournament")
    public void organizer_starts_tournament() {
      String request="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+singleTournamentID+"\\\") {\\n    id,\\n\\t\\tbracketInformation{\\n\\t\\t\\tbracketName\\n\\t\\t\\t\\n\\t\\t}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());
    }
    @Given("organizer enters score")
    public void organizer_enters_score() {
      String requestMatchid="{\"query\":\"query {\\n  getBracket(bracketId: \\\""+singleBracketID+"\\\") {\\n    id,\\n    bracketInformation {id,bracketName,bracketStatus,publishBrackets,participantIds},\\n    eliminationBracketDetail {upperBracket {team1Id,id, team2Id}, lowerBracket {team1Id, team2Id,id}, bracketSize, bracketStatus}\\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestMatchid);
        System.out.println(response.prettyPrint());
        jsonPath= response.jsonPath();
        String match = jsonPath.getString("data.getBracket.eliminationBracketDetail.upperBracket.id");
        singleBracketMatchID=match.substring(1,37);
        System.out.println(response.prettyPrint());

        String requestEnterScore="{\"query\":\"mutation {\\n  matchScore(\\n\\tteam1Score:5\\n\\tteam2Score:3\\n\\t\\tmatchId:\\\""+singleBracketMatchID+"\\\"\\n\\t\\tbracketId:\\\""+singleBracketID+"\\\"\\n\\t\\t\\n\\t)\\n\\n{\\n\\tbracketInformation{\\n\\t\\tbracketName\\n\\t\\tid\\n\\t\\t\\n\\t}\\n\\teliminationBracketDetail{\\n\\t\\tbracketSize\\n\\t}\\n\\tid\\n}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestEnterScore);
        System.out.println(response.prettyPrint());
    }
    @Given("organizer ends tournament")
    public void organizer_ends_tournament() {
       String request="{\"query\":\"mutation {\\n  rectifyBracketAndDetermineWinners(\\nbracketId:\\\""+singleBracketID+"\\\")\\n{\\n\\tbracketName\\n\\tbracketStatus\\n\\tbracketStartDate\\n}\\t\\t\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        System.out.println(response.prettyPrint());
    }






}

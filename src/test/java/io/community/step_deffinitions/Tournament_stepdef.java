package io.community.step_deffinitions;

import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.BrowserUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
@Slf4j
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
    String mrbrooks2Rewards=null;
    String upcomingTournament=null;
    String progressTournament=null;
    String completedTournament=null;
    String tournametID_RR_SE=null;
    String brackedList_RR_SE=null;
    String alias=null;
    String bracketIDRR=null;
    String bracketIDSE=null;
    List<Object>bracketList=new ArrayList<>();



    @When("user post CreateTournament With Multiple Brackets")
    public void user_post_CreateTournament_With_Multiple_Brackets() {

        String request =" {\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\"swiss-1"+faker.name().firstName()+"\\\"\\n    bracketType: SWISS\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"autoapprove1\\\"\\n    description: \\\"testing by Bipek lkdsanflksdjnfşjsdanbfkjsdabfkjbsdakljfbsdakjfbsadkjbsdkajbfksadjbfksljadfksadjbfksajbdfksajdbflskajdbfksjdabfksajdbfksajdbfksdajbfksadjbfksjdbfksajdbksadjbfkasjbfksadjbksadjbksaljdbksajdbfksajbfalskjf\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 10\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: SWISS,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\tswissDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\tnumberOfTeams : 1,\\n        roundCount : 4,\\n\\t\\t\\t\\tswissScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\n\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n  }\\n}\"} ";

        response= ApiUtils.request(ConfigurationReader.get("testURI"),request);


        log.info(response.prettyPrint());
        jsonPath =response.jsonPath();

        multipleTournamentID=jsonPath.getString("data.createTournament.id");
       log.info("multipleTournamentID = " + multipleTournamentID);

    }
    @When("user post CreateTournament With Multiple Brackets for Dev Environment")
    public void user_post_CreateTournament_With_Multiple_Brackets_for_Dev_Environment() {

        String request =" {\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\"swiss-1"+faker.name().firstName()+"\\\"\\n    bracketType: SWISS\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"autoapprove1\\\"\\n    description: \\\"testing by Bipek lkdsanflksdjnfşjsdanbfkjsdabfkjbsdakljfbsdakjfbsadkjbsdkajbfksadjbfksljadfksadjbfksajbdfksajdbflskajdbfksjdabfksajdbfksajdbfksdajbfksadjbfksjdbfksajdbksadjbfkasjbfksadjbksadjbksaljdbksajdbfksajbfalskjf\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 10\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: SWISS,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\tswissDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\tnumberOfTeams : 1,\\n        roundCount : 4,\\n\\t\\t\\t\\tswissScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\n\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n  }\\n}\"} ";

        response= ApiUtils.request(ConfigurationReader.get("devURI"),request);
        log.info(response.prettyPrint());

        jsonPath =response.jsonPath();

        multipleTournamentID=jsonPath.getString("data.createTournament.id");
        log.info("multipleTournamentID = " + multipleTournamentID);

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
       log.info(expectedStartTournamentErrorMessage);

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
        log.info(response.prettyPrint());
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
       log.info("participants= "+jsonPath.getString("data.tournament.participants.id"));
       Assert.assertTrue(!jsonPath.getString("data.tournament.participants.id").isEmpty());
    }
    @Then("tournament approval should {string}")
    public void tournament_approval_should(String status) {
       log.info("isAutoApprovalEnabled = " + jsonPath.getString("data.tournament.isAutoApprovalEnabled"));
        Assert.assertEquals(jsonPath.getString("data.tournament.isAutoApprovalEnabled"),status);


    }
    @Given("organizer create tournament with single elemination")
    public void organizer_create_tournament_with_single_elemination() {
        String alias= faker.name().firstName()+ApiUtils.date();
        String request ="{\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\""+alias+"\\\"\\n    bracketType: SINGLE_ELIMINATION\\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2022-11-19T21:59:08.454Z\\\"\\n    name: \\\"CreatedForRewardCheckOnAPI\\\"\\n    description: \\\"asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 100\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 30, \\n    bracketList: [\\n    {\\n        bracketName: \\\"testBrk\\\",\\n        bracketStartDate: \\\"2022-03-16T21:59:08.454Z\\\",\\n        bracketType: SINGLE_ELIMINATION,\\n        maxParticipantCount: 8,\\n        isSelfReportAllowed: true,\\n\\t\\t\\t\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n\\t\\tbracketType\\n\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t}\\n  }\\n}\"}";

        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
       log.info(response.prettyPrint());
         jsonPath=response.jsonPath();
         singleTournamentID=jsonPath.getString("data.createTournament.id");
        String test=jsonPath.getString("data.createTournament.bracketList.id");
        log.info("singleBracketID = " + singleBracketID);
        singleBracketID= test.substring(1,37);



    }
    @Given("Add participant mrbrooks2")
    public void add_participant_mrbrooks2() {
        String request= "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+singleTournamentID+"\\\",\\nteamId:\\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\\n\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());

    }
    @Given("Add participant mrbrooks")
    public void add_participant_mrbrooks() {
       String request = "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+singleTournamentID+"\\\",\\nteamId:\\\"cdf0746b-e72d-4b17-8a38-7964f37b87cb\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\\n\"}";
       response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());
    }
    @Given("organizer generates bracket")
    public void organizer_generates_bracket() {
     String request ="{\"query\":\"mutation {\\n  generateBracket(\\n    bracketId:\\\""+singleBracketID+"\\\", \\n    allowCheckedInOnly: false, \\n    participantIds: [\\\"cdf0746b-e72d-4b17-8a38-7964f37b87cb\\\", \\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\"]) \\n  {\\n    bracketInformation {id,bracketName,bracketType},\\n    eliminationBracketDetail {upperBracket {team1Id}, lowerBracket {team1Id}, bracketSize, bracketStatus}\\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());


    }
    @Given("organizer starts tournament")
    public void organizer_starts_tournament() {
      String request="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+singleTournamentID+"\\\") {\\n    id,\\n\\t\\tbracketInformation{\\n\\t\\t\\tbracketName\\n\\t\\t\\t\\n\\t\\t}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());
    }
    @Given("organizer enters score")
    public void organizer_enters_score() {
      String requestMatchid="{\"query\":\"query {\\n  getBracket(bracketId: \\\""+singleBracketID+"\\\") {\\n    id,\\n    bracketInformation {id,bracketName,bracketStatus,publishBrackets,participantIds},\\n    eliminationBracketDetail {upperBracket {team1Id,id, team2Id}, lowerBracket {team1Id, team2Id,id}, bracketSize, bracketStatus}\\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestMatchid);
       log.info(response.prettyPrint());
        jsonPath= response.jsonPath();
        String match = jsonPath.getString("data.getBracket.eliminationBracketDetail.upperBracket.id");
        singleBracketMatchID=match.substring(1,37);
        log.info(response.prettyPrint());

        String requestEnterScore="{\"query\":\"mutation {\\n  matchScore(\\n\\tteam1Score:5\\n\\tteam2Score:3\\n\\t\\tmatchId:\\\""+singleBracketMatchID+"\\\"\\n\\t\\tbracketId:\\\""+singleBracketID+"\\\"\\n\\t\\t\\n\\t)\\n\\n{\\n\\tbracketInformation{\\n\\t\\tbracketName\\n\\t\\tid\\n\\t\\t\\n\\t}\\n\\teliminationBracketDetail{\\n\\t\\tbracketSize\\n\\t}\\n\\tid\\n}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestEnterScore);
        log.info(response.prettyPrint());
    }
    @Given("organizer ends tournament")
    public void organizer_ends_tournament() {
       String request="{\"query\":\"mutation {\\n  rectifyBracketAndDetermineWinners(\\nbracketId:\\\""+singleBracketID+"\\\")\\n{\\n\\tbracketName\\n\\tbracketStatus\\n\\tbracketStartDate\\n}\\t\\t\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());
    }

    @When("user get rewards")
    public void user_get_rewards() {
       String request="{\"query\":\"query {\\n  getRewardsByUser(userId: \\\"6611e97e-1048-439b-9f53-9cd3505af2a1\\\") {\\n rewards{\\n\\tdate\\n\\tgame{\\n\\t\\tid\\n\\t\\tname\\n\\t\\turl\\n\\t\\t\\n\\t}\\n\\tposition\\n\\treward{\\n\\t\\tid\\n\\t}\\n}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath = response.jsonPath();

        log.info(response.prettyPrint());
        String rewardid= jsonPath.getString("data.getRewardsByUser.rewards.reward.id");

        mrbrooks2Rewards=rewardid.substring(2,38);
        log.info("mrbrooks2Rewards"+mrbrooks2Rewards);


    }
    @When("user claim off chain reward")
    public void user_claim_off_chain_reward() {

        String request="{\"query\":\"mutation{\\n\\tclaimOffChainTournamentReward(\\n\\t\\trewardId:\\\""+mrbrooks2Rewards+"\\\"\\n\\t\\tpaypalId: \\\"213123121212123\\\"\\n\\t\\t\\t)\\n\\n\\t\\n}\\n\"}";

        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath = response.jsonPath();

        log.info(response.prettyPrint());
        Assert.assertTrue(jsonPath.getString("data.claimOffChainTournamentReward").contains("true"));
    }

    @Then("tournament should list in upcoming tournament")
    public void tournament_should_list_in_upcoming_tournament() {
       String request ="{\"query\":\"query {\\n  upcomingTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
       response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
         jsonPath=response.jsonPath();
         upcomingTournament=jsonPath.getString("data.upcomingTournaments");
         log.info("upcoming Tournaments"+upcomingTournament);
         Assert.assertTrue(upcomingTournament.contains(singleTournamentID));
    }
    @Then("tournament should list in progress tournament")
    public void tournament_should_list_in_progress_tournament() {
      String request="{\"query\":\"query {\\n  liveTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
        response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        progressTournament=jsonPath.getString("data.liveTournaments");
        log.info("progress Tournaments"+progressTournament);
        Assert.assertTrue(progressTournament.contains(singleTournamentID));
    }
    @Then("tournament should list in completed tournament")
    public void tournament_should_list_in_completed_tournament() {
       String request="{\"query\":\"query {\\n  completedTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
        response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        completedTournament=jsonPath.getString("data.completedTournaments");
        log.info("progress Tournaments"+completedTournament);
        Assert.assertTrue(completedTournament.contains(singleTournamentID));
    }
    @Then("tournament should not list in progress tournament")
    public void tournament_should_not_list_in_progress_tournament() {
        String request="{\"query\":\"query {\\n  liveTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
        response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        progressTournament=jsonPath.getString("data.liveTournaments");
        log.info("progress Tournaments"+progressTournament);
        Assert.assertTrue(!progressTournament.contains(singleTournamentID));
    }
    @Then("tournament should not list in completed tournament")
    public void tournament_should_not_list_in_completed_tournament() {
        String request="{\"query\":\"query {\\n  completedTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
        response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        completedTournament=jsonPath.getString("data.completedTournaments");
        log.info("progress Tournaments"+completedTournament);
        Assert.assertTrue(!completedTournament.contains(singleTournamentID));
    }
    @Then("tournament should not list in upcoming tournament")
    public void tournament_should_not_list_in_upcoming_tournament() {
        String request ="{\"query\":\"query {\\n  upcomingTournaments{\\n\\t\\tid\\n\\t}\\n}\"}";
        response =ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        upcomingTournament=jsonPath.getString("data.upcomingTournaments");
        log.info("upcoming Tournaments"+upcomingTournament);
        Assert.assertTrue(!upcomingTournament.contains(singleTournamentID));
    }

    @When("organizer create tournament with Multiple Bracket \\(RoundRobin-Single Elemination)")
    public void organizer_create_tournament_with_multiple_bracket_round_robin_single_elemination() {

        alias=faker.name().firstName()+ApiUtils.date();
        log.info(alias);
       String request="{\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\""+alias+"\\\"\\n   \\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"CreatedForPhaseTest\\\"\\n    description: \\\"asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 1000\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: 4, \\n    bracketList: [\\n    {\\n\\t\\t\\tphaseIndex:1,\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: ROUND_ROBIN,\\n        maxParticipantCount: 4,\\n        isSelfReportAllowed: true,\\n\\t\\t\\troundRobinDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\tteamsPerGroup:2,\\n\\t\\t\\t\\tnumberOfGroups : 2,\\n\\t\\t\\t\\troundRobinScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\t\\n\\t\\t\\t\\t}\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t\\t{\\n\\t\\t\\tphaseIndex:2,\\n        bracketName: \\\"asd\\\",\\n        bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\",\\n        bracketType: SINGLE_ELIMINATION,\\n        maxParticipantCount: 2,\\n        isSelfReportAllowed: true,\\n\\t\\t\\n\\t\\t\\t\\n    }\\n\\t\\t]\\n  }) {\\n    id\\n\\t\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t}\\n  }\\n}\"}";
       response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
       jsonPath=response.jsonPath();
       tournametID_RR_SE=jsonPath.getString("data.createTournament.id");
       brackedList_RR_SE=jsonPath.getString("data.createTournament.bracketList.id");
       bracketIDSE=jsonPath.getString("data.createTournament.bracketList.id[1]");
       log.info(jsonPath.prettyPrint());
       log.info(" tournametID_RR_SE="+tournametID_RR_SE);
       log.info(" brackedList_RR_SE"+brackedList_RR_SE);



    }
    @When("Add participant mrbrooks2 for RR SE")
    public void add_participant_mrbrooks2_for_rr_se() {
        String request= "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+tournametID_RR_SE+"\\\",\\nteamId:\\\"4bb60918-e961-40a2-949a-ff1ee7443c1e\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\\n\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());
    }
    @When("fill tournament with participants")
    public void fill_tournament_with_participants() {
        String request="{\"query\":\"mutation {\\n  fillTournamentWithParticipants(id: \\\""+alias +"\\\") {id}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
    }
    @When("generate bracket for RR")
    public void generate_bracket_for_rr() {
        bracketIDRR= brackedList_RR_SE.substring(1,37);
        String request="{\"query\":\"mutation {\\n  generateBracketRR(\\n    bracketId:\\\""+bracketIDRR+"\\\", \\n  \\n    participantIds: [\\\"test_user_4\\\", \\\"test_user_1\\\",\\\"test_user_2\\\",\\\"test_user_3\\\"]) \\n  {\\n    bracketName\\n\\t\\tbracketStatus\\n\\t\\troundRobinBracketDetail{\\n\\t\\t\\tteamsPerGroup\\n\\t\\t}\\n   \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();

    }

    @Then("bracket Status should be Seeded")
    public void bracket_status_should_be_seeded() {
       String bracketStatus=jsonPath.getString("data.generateBracketRR.bracketStatus");
       log.info("RRBracketStatus"+bracketStatus);
        Assert.assertTrue(bracketStatus.contains("SEEDED"));

    }
    @When("organizer starts tournament for MultipleBracket RR-SE")
    public void organizer_starts_tournament_for_multiple_bracket_rr_se() {
       String request="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+tournametID_RR_SE+"\\\") {\\n    id,\\n\\t\\tbracketInformation{\\n\\t\\t\\tbracketName\\n\\t\\t\\tbracketStatus\\n\\t\\t\\t\\n\\t\\t}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        log.info(response.prettyPrint());

    }
    @Then("bracket Status should be Live")
    public void bracket_status_should_be_live() {
       String bracketStatus=jsonPath.getString("data.startTournament.bracketInformation.bracketStatus");
       log.info("bracketStatus"+bracketStatus);
       Assert.assertTrue(bracketStatus.contains("LIVE"));
    }
    @When("organizer enters the score for RR")
    public void organizer_enters_the_score_for_rr() {
       String requestForRoundRR="{\"query\":\"query {\\n  getRoundRR(bracketId: \\\""+bracketIDRR+"\\\"\\n\\troundIndex:1\\n\\t\\n\\t) {\\n  bracketId,\\n\\t\\tgroupMatches{\\n\\t\\t\\tid,\\n\\t\\t\\tgroupIndex,\\n\\t\\t\\tteam1Id,\\n\\t\\t\\tteam2Id\\n\\t\\t}\\n\\t}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestForRoundRR);
        log.info("getRoundRR="+response.prettyPrint());
        jsonPath=response.jsonPath();
        String matchID1=jsonPath.getString("data.getRoundRR.groupMatches.id[0]");
        String matchID2=jsonPath.getString("data.getRoundRR.groupMatches.id[1]");
        log.info("matchID1"+matchID1);
        log.info("matchID2"+matchID2);
        String matchID1Result=matchID1.substring(1,37);

        String team1_1ID=jsonPath.getString("data.getRoundRR.groupMatches.team1Id[0]");
        String team1_2ID=jsonPath.getString("data.getRoundRR.groupMatches.team2Id[0]");
        log.info("team1_1ID"+team1_1ID);
        log.info("team1_2ID"+team1_2ID);
        String team2_1ID=jsonPath.getString("data.getRoundRR.groupMatches.team1Id[1]");
        String team2_2ID =jsonPath.getString("data.getRoundRR.groupMatches.team2Id[1]");
        log.info("team2_1ID"+team2_1ID);
        log.info("team2_2ID"+team2_2ID);
        String team1_1IDResult=team1_1ID.substring(1,11);

        String requestForEnterScore="{\"query\":\"mutation {\\n reportMatchScoreRR(\\n\\t\\n\\t\\tmatchId:\\\""+matchID1Result+"\\\"\\n\\t\\tbracketId:\\\""+bracketIDRR+"\\\"\\n\\t\\tscores:{\\n\\t\\t\\tscore:{\\n\\t\\t\\t\\tfirst:2\\n\\t\\t\\t\\tsecond:5\\n\\t\\t\\t}\\n\\t\\n\\t\\t\\twinnerId:\\\""+team1_1IDResult+"\\\"\\n\\t\\t}\\n\\t)\\n\\n{\\n\\t\\n\\tbracketId\\n\\tmatchResult\\n\\tmatchStatus\\n\\t\\n\\tid\\n}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestForEnterScore);
        log.info("firstMatchResultRR"+response.prettyPrint());




    }
    @When("organizer enters the score for RR second match")
    public void organizer_enters_the_score_for_rr_second_match() {

        String requestForRoundRR="{\"query\":\"query {\\n  getRoundRR(bracketId: \\\""+bracketIDRR+"\\\"\\n\\troundIndex:1\\n\\t\\n\\t) {\\n  bracketId,\\n\\t\\tgroupMatches{\\n\\t\\t\\tid,\\n\\t\\t\\tgroupIndex,\\n\\t\\t\\tteam1Id,\\n\\t\\t\\tteam2Id\\n\\t\\t}\\n\\t}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestForRoundRR);
        log.info("getRoundRR="+response.prettyPrint());
        jsonPath=response.jsonPath();
        String matchID1=jsonPath.getString("data.getRoundRR.groupMatches.id[0]");
        String matchID2=jsonPath.getString("data.getRoundRR.groupMatches.id[1]");
        log.info("matchID1"+matchID1);
        log.info("matchID2"+matchID2);
        String matchID2Result=matchID2.substring(1,37);
        log.info("matchID1Result"+matchID2Result);

        String team1_1ID=jsonPath.getString("data.getRoundRR.groupMatches.team1Id[0]");
        String team1_2ID=jsonPath.getString("data.getRoundRR.groupMatches.team2Id[0]");
        log.info("team1_1ID"+team1_1ID);
        log.info("team1_2ID"+team1_2ID);
        String team2_1ID=jsonPath.getString("data.getRoundRR.groupMatches.team1Id[1]");
        String team2_2ID =jsonPath.getString("data.getRoundRR.groupMatches.team2Id[1]");
        log.info("team2_1ID"+team2_1ID);
        log.info("team2_2ID"+team2_2ID);
        String team2_2IDResult=team2_2ID.substring(1,11);
        String requestForEnterScore2="{\"query\":\"mutation {\\n reportMatchScoreRR(\\n\\t\\n\\t\\tmatchId:\\\""+matchID2Result+"\\\"\\n\\t\\tbracketId:\\\""+bracketIDRR+"\\\"\\n\\t\\tscores:{\\n\\t\\t\\tscore:{\\n\\t\\t\\t\\tfirst:1\\n\\t\\t\\t\\tsecond:2\\n\\t\\t\\t}\\n\\t\\n\\t\\t\\twinnerId:\\\""+team2_2IDResult+"\\\"\\n\\t\\t}\\n\\t)\\n\\n{\\n\\t\\n\\tbracketId\\n\\tmatchResult\\n\\tmatchStatus\\n\\t\\n\\tid\\n}\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),requestForEnterScore2);
        log.info("secondMatchResultRR"+response.prettyPrint());
    }


    @When("organizer generates bracket  for SE")
    public void organizer_generates_bracket_for_se() {
       String request="{\"query\":\"mutation {\\n  generateBracket(\\n    bracketId:\\\""+bracketIDSE+"\\\", \\n    allowCheckedInOnly: false, \\n    participantIds: [\\\"test_user_1\\\", \\\"test_user_2\\\"]) \\n  {\\n    bracketInformation {id,bracketName,bracketType},\\n    eliminationBracketDetail {upperBracket {team1Id}, lowerBracket {team1Id}, bracketSize, bracketStatus}\\n  }\\n}\"}";
       response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
       log.info("generatedBracket Details="+response.prettyPrint());
    }
    @When("organizer starts bracket for SE")
    public void organizer_starts_bracket_for_se() {
      String request="{\"query\":\"mutation {\\n  startBracket(bracketId: \\\""+bracketIDSE+"\\\") {\\n    id\\n  }\\n}\"}";
      response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
      log.info("startedBracket"+response.prettyPrint());
    }
    @When("organizer enters the score for SE")
    public void organizer_enters_the_score_for_se() {
       String requestForgetBracket="{\"query\":\"query {\\n  getBracket(bracketId: \\\""+bracketIDSE+"\\\") {\\n    id,\\n    bracketInformation {id,\\n\\t\\t\\tbracketName,\\n\\t\\t\\tbracketStatus,publishBrackets,\\n\\t\\t\\tparticipantIds},\\n    eliminationBracketDetail {\\n\\t\\t\\tupperBracket {team1Id,id, team2Id\\n\\t\\t\\t}, \\n\\t\\t\\tlowerBracket {team1Id, team2Id,id\\n\\t\\t\\t}, \\n\\t\\t\\tbracketSize, \\n\\t\\t\\tbracketStatus}\\n  }\\n}\"}";
       response=ApiUtils.request(ConfigurationReader.get("testURI"),requestForgetBracket);
       jsonPath=response.jsonPath();
       log.info(response.prettyPrint());
       String matchID=jsonPath.getString("data.getBracket.eliminationBracketDetail.upperBracket.id");
       log.info("matchID_SE"+matchID);
       String matchIDresult=matchID.substring(1,37);
        log.info("matchIDresult"+matchIDresult);

       String requestForenterScore="{\"query\":\"mutation {\\n  matchScore(\\n\\tteam1Score:5\\n\\tteam2Score:3\\n\\t\\tmatchId:\\\""+matchIDresult+"\\\"\\n\\t\\tbracketId:\\\""+bracketIDSE+"\\\"\\n\\t\\t\\n\\t)\\n\\n{\\n\\tbracketInformation{\\n\\t\\tbracketName\\n\\t\\tid\\n\\t\\t\\n\\t}\\n\\teliminationBracketDetail{\\n\\t\\tbracketSize\\n\\t}\\n\\tid\\n}\\n}\"}";
        response=ApiUtils.request(ConfigurationReader.get("testURI"),requestForenterScore);
        jsonPath=response.jsonPath();
        log.info(response.prettyPrint());

    }
    @When("organizer ends the tournament for RR-SE")
    public void organizer_ends_the_tournament_for_rr_se() {
       String request="{\"query\":\"mutation {\\n  rectifyBracketAndDetermineWinners(\\nbracketId:\\\""+bracketIDSE+"\\\")\\n{\\n\\tbracketName\\n\\tbracketStatus\\n\\tbracketStartDate\\n}\\t\\t\\n}\"}";
       response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
       jsonPath=response.jsonPath();
       log.info(response.prettyPrint());

    }
    @Then("bracket Status should be Complete")
    public void bracket_status_should_be_complete() {
        String bracketStatus=jsonPath.getString("data.rectifyBracketAndDetermineWinners.bracketStatus");
        Assert.assertTrue(bracketStatus.contains("COMPLETE"));

    }
    @Then("Winner List should contains ID")
    public void winner_list_should_contains_id() {

        String request="{\"query\":\"query {\\n  tournament(id:\\\""+alias+"\\\"){\\n\\t\\tid\\n\\t\\tparticipants{\\n\\t\\t\\tid\\n\\t\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tautoApprovalMinute\\n\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t\\t\\n\\t\\t}\\n\\t\\tmatchesL{\\n\\t\\t\\tid\\n\\t\\t}\\n\\t\\tmatchIds\\n\\t\\tmatches{\\n\\t\\t\\tid\\n\\t\\t\\t\\n\\t\\t}\\n\\t\\t\\n\\t\\t\\n\\t\\twinners{\\n\\t\\t\\tuserId\\n\\t\\t\\tteamId\\n\\t\\t\\tteamPosition\\n\\t\\t\\tpaypalId\\n\\t\\t}\\n\\t}\\n}\"}";
        response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info("Tournament Detail= "+response.prettyPrint());
        jsonPath=response.jsonPath();


    }
    @Then("tournament status should be Complete")
    public void tournament_status_should_be_complete() {
       String winner1=jsonPath.getString("data.tournament.winners");
       String winner2=jsonPath.getString("data.tournament.winners");
       Assert.assertTrue(!winner1.isEmpty());
       Assert.assertTrue(!winner2.isEmpty());

    }

    @When("Organizer create a Tournament {int} {int} Swiss bracket as {int} {int} {int} {int} {int} and single elemination as {int} {int}")
    public void organizer_create_a_tournament_swiss_bracket_as_and_single_elemination_as(Integer teamSize, Integer maxTeams, Integer phaseIndeSW, Integer maxParticipantCountSW, Integer gamesPerRoundSW, Integer playPerTeamsSW, Integer roundCountSW, Integer phaseIndexSE, Integer maxParticipantCountSE) {
    String swbracket=ApiUtils.swiss(phaseIndeSW,maxParticipantCountSW,gamesPerRoundSW,playPerTeamsSW,roundCountSW);
    String sEbracket=ApiUtils.singleElemination(phaseIndexSE,maxParticipantCountSE);
    alias=faker.name().firstName()+ApiUtils.date();
    String request="{\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\""+alias+"\\\"\\n   \\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: "+teamSize+"\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2021-11-19T21:59:08.454Z\\\"\\n    name: \\\"CreatedForPhaseTest\\\"\\n    description: \\\"asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd\\\"\\n    gameId: \\\"cs_go\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 1000\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t  maxTeams: "+maxTeams+", \\n    bracketList: [\\n "+swbracket+"\\n\\t"+sEbracket+"\\n\\t\\t]\\n  }) {\\n    id\\n\\t\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t}\\n  }\\n}\"}";

    response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
    jsonPath=response.jsonPath();
    log.info(response.prettyPrint());

    multipleTournamentID=jsonPath.getString("data.createTournament.id");
    bracketList=jsonPath.getList("data.createTournament.bracketList.id");
    log.info(bracketList.toString()+"bracket first="+bracketList.get(0));

    }

    @Given("generate bracket swiss")
    public void generate_bracket_swiss() {
        String request = "{\"query\":\"query {\\n  tournament(id:\\\""+alias+"\\\"){\\n\\t\\tid\\n\\t\\tparticipants{\\n\\t\\t\\tid\\n\\t\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tautoApprovalMinute\\n\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t\\t\\n\\t\\t}\\n\\t\\tmatchesL{\\n\\t\\t\\tid\\n\\t\\t}\\n\\t\\tmatchIds\\n\\t\\tmatches{\\n\\t\\t\\tid\\n\\t\\t\\t\\n\\t\\t}\\n\\t\\t\\n\\t\\t\\n\\t\\twinners{\\n\\t\\t\\tuserId\\n\\t\\t\\tteamId\\n\\t\\t\\tteamPosition\\n\\t\\t\\tpaypalId\\n\\t\\t}\\n\\t}\\n}\"}";

        response = ApiUtils.request(ConfigurationReader.get("testURI"), request);
        jsonPath = response.jsonPath();
        List<String> participants = new ArrayList<>();
        participants = jsonPath.getList("data.tournament.participants.id");

        List<List<String>> listOfList = new ArrayList<>();


        for (int i = 0; i < participants.size(); i += 2) {

            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < 1; j++) {

                tempList.add(participants.get(i));
                tempList.add(participants.get(i + 1));

            }
            listOfList.add(tempList);
        }
        System.out.println("listOfList = " + listOfList);


        String participantadd = "";
        for (int i = 0; i < listOfList.size() ; i++) {

            for(int j = 0; j<1; j++) {
                participantadd = participantadd + "," + "{team1Id:\\\"" + listOfList.get(i).get(j) + "\\\"," +
                        "team2Id:\\\"" + listOfList.get(i).get(j+1) + "\\\"}";

            }
        }System.out.println("participantadd = " + participantadd.substring(1));

       String request4="{\"query\":\"\\nmutation {\\n\\tgenerateBracketSwiss(bracketId: \\\""+bracketList.get(0)+"\\\",\\n\\tmatchParticipantsList:["+participantadd.substring(1)+"]){\\n\\t\\tid\\n\\t}\\n}\"}";
       log.info(request4);
        response=ApiUtils.request(ConfigurationReader.get("testURI"),request4);
        jsonPath=response.jsonPath();
        log.info(response.prettyPrint());
        Assert.assertTrue(!jsonPath.getString("data.generateBracketSwiss.id").isEmpty());
        }
    @When("organizer starts tournament for MultipleBracket")
    public void organizer_starts_tournament_for_multiple_bracket() {
        String request="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+multipleTournamentID+"\\\") {\\n    id,\\n\\t\\tbracketInformation{\\n\\t\\t\\tbracketName\\n\\t\\t\\t\\n\\t\\t}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info(response.prettyPrint());
    }




}









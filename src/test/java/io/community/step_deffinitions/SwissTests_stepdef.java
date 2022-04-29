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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

@Slf4j
public class SwissTests_stepdef {

 Faker faker=new Faker();
 String alias=null;
 Response response;
 JsonPath jsonPath;
 String tournamentID=null;
 String bracketID=null;

 List<String>participantList=new ArrayList<>();


    @When("Organizer create {int} {int}  {int} Swiss tournament {string} env.")
    public void organizer_create_swiss_tournament(Integer maxTeam, Integer maxParticipantCount, Integer roundCount,String env) {
        alias =faker.lordOfTheRings().character()+faker.name().firstName();

        String request="{\"query\":\"mutation {\\n  createTournament(data: {\\n    alias: \\\""+alias+"\\\"\\n   \\n    externalBrackets: false,\\n    externalDiscordChannelUrl: \\\"\\\"\\n    teamSize: 1\\n    tournamentType: OFF_CHAIN\\n    deadline: \\\"2023-11-19T21:59:08.454Z\\\"\\n    name: \\\"createdForGenerateNextBracketErrorTest\\\"\\n    description: \\\"asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd\\\"\\n    gameId: \\\"axie_infinity\\\"\\n    buyInFee: 0\\n    prizeDistribution: [80,19,0,0,0,0,0]\\n    prizeDescription: \\\"Prizing will be sent out immediately after the tournament ends using PayPal.\\\"\\n    prizeTarget: 421\\n    isGameIdRequired: false\\n    isRegistrationQuestionsRequired: false\\n    isCheckinRequired: false\\n    registrationQuestions: [\\n\\t\\t\\t{question: \\\"adsasd\\\", type: \\\"FILE\\\", required: true, isPublic: true, options: []},\\n\\t\\t\\t{question: \\\"asdadasd\\\", type: \\\"TEXT\\\", required: false, isPublic: true, options: []}\\n\\t\\t]\\n    streamLinks: {}\\n    tokenId: \\\"fiat\\\"\\n    unlisted: false\\n    isSelfReportAllowed: false\\n    isSubstitutePlayersEnabled: false\\n    maxSubstitutePlayerCount: 0\\n \\t " +
                " maxTeams: "+maxTeam+", \\n   " +
                " bracketList: [\\n   {\\n\\t\\t\\n     " +
                "  \\n\\t\\t\\t\\tbracketName: \\\"bigBracket\\\",\\n      " +
                "  bracketStartDate: \\\"2023-01-19T21:59:08.454Z\\\",\\n       " +
                " bracketType: SWISS,\\n        maxParticipantCount: "+maxParticipantCount+",\\n       " +
                " isSelfReportAllowed: true,\\n\\t\\t\\" +
                "tswissDetails:{\\n\\t\\t\\t\\tgamesPerRound:1,\\n\\t\\t\\t\\tplayTimePerTeams:1,\\n\\t\\t\\t\\" +
                "troundCount:"+roundCount+",\\n\\t\\t\\t\\" +
                "tnumberOfTeams:"+maxParticipantCount+"\\n\\t\\t\\t\\n\\t\\t\\t\\t\\n\\t\\t\\t\\tswissScoringRule:{\\n\\t\\t\\t\\t\\twin:3,draw:1,lose:0\\t\\n\\t\\t\\t\\t}\\t\\n\\t\\t\\t}\\n    }\\n\\t\\t\\n\\n\\t\\t\\t\\n\\t\\t]\\n  }) {\\n    id\\n\\t\\t\\tbracketList{\\n\\t\\t\\tid\\n\\t\\t}\\n  }\\n}\"}";

                response= ApiUtils.request(ConfigurationReader.get(env),request);
                jsonPath=response.jsonPath();
                tournamentID=jsonPath.getString("data.createTournament.id");
                bracketID=jsonPath.getString("data.createTournament.bracketList.id");
                log.info(response.prettyPrint());



    }
    @Given("Enter specific tournament info {string} tournamentID {string} bracketID for axieTournament")
    public void enter_specific_tournament_info_tournament_id_bracket_id_for_axie_tournament(String tournamentid, String bracketid) {
        tournamentID=tournamentid;
        bracketID=bracketid;
    }
    @When("Add {int} participant to tournament")
    public void add_participant_to_tournament(Integer participant) {
        int i=1;

        for (int j=1 ;j<=participant;j++) {
            String userName = "testUser" + i;
            String body = "{\"query\":\"query {\\n  signInUser(username: \\\"" + userName + "\\\", password: \\\"testUser1234\\\") {\\n    accessToken\\n  }\\n}\\n\\n\"}";
            response = given().accept(ContentType.JSON).body(body).when()
                    .post(ConfigurationReader.get("dev4URI"));
            jsonPath = response.jsonPath();
            String token = jsonPath.getString("data.signInUser.accessToken");

            log.info("accessToken " + token);

            String body2 = "{\"query\":\"mutation{\\n\\taddParticipant (\\ntournamentId:\\\""+tournamentID+"\\\",\\nteamId:\\\"test_user_" + i + "\\\",\\nsquadIds:[],\\nsubstituteIds:[],\\nresponses: [\\\"Game1\\\", \\\"Ukraine\\\", \\\"test1\\\"],\\ngameIds:[]\\n\\t)\\n\\t{\\n\\t\\tid\\n\\tparticipants{\\n\\t\\tid\\n\\t}\\n\\t\\tisAutoApprovalEnabled\\n\\t\\tisPrizeTargetInUSD\\n\\t\\tmaxTeams\\n\\t\\t\\n\\t\\t\\n\\t}\\n}\"}";

            Response response = given().headers(
                    "Authorization",
                    "Bearer " +token,
                    "Content-Type", "application/json").body(body2).when().post(ConfigurationReader.get("dev4URI"));
           // log.info(response.prettyPrint());
            jsonPath = response.jsonPath();
            participantList=jsonPath.getList("data.addParticipant.participants.id");
            i++;


        }

    }
    @Given("organizer generate first swiss bracket")
    public void organizer_generate_first_swiss_bracket() {

        List<List<String>> listOfList = new ArrayList<>();


        for (int i = 0; i < participantList.size(); i += 2) {

            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < 1; j++) {

                tempList.add(participantList.get(i));


                tempList.add(participantList.get(i + 1));

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
        }//System.out.println("participantadd = " + participantadd.substring(1));

        String request4="{\"query\":\"\\nmutation {\\n\\tgenerateBracketSwiss(bracketId: \\\""+bracketID.substring(1,37)+"\\\",\\n\\tmatchParticipantsList:["+participantadd.substring(1)+"]){\\n\\t\\tid\\n\\t}\\n}\"}";
        log.info(request4);
        response=ApiUtils.request(ConfigurationReader.get("dev4URI"),request4);
        jsonPath=response.jsonPath();
        log.info(response.prettyPrint());
        Assert.assertTrue(!jsonPath.getString("data.generateBracketSwiss.id").isEmpty());

    }

    @When("Organizer starts tournament")
    public void organizer_starts_tournament() {
        String request="{\"query\":\"mutation {\\n  startTournament(tournamentId: \\\""+tournamentID+"\\\") {\\n    id,\\n\\t\\tbracketInformation{\\n\\t\\t\\tbracketName\\n\\t\\t\\t\\n\\t\\t}\\n    \\n  }\\n}\"}";
        response = ApiUtils.request(ConfigurationReader.get("dev4URI"),request);
        log.info(response.prettyPrint());
    }
    @When("Organizer enter the scores and generate next bracket for {int} round {int} participants")
    public void organizer_enter_the_scores_and_generate_next_bracket_for_round_participants(Integer round, Integer participant) {
        List<String> matchID= new ArrayList<>();
        int x=0;
        int k=1;

        for (int i = 1; i <= round; i++) {
            for (int l=0;l<(participant/2);l++) {
                String requestForMatchID = "{\"query\":\"query{\\n\\tgetRoundSwissPage(bracketId:\\\""+bracketID.substring(1,37)+"\\\", ,roundIndex:"+i+",pageCount:"+l+",size:1) \\n\\t{\\n\\tbracketId\\n\\t\\tcontentPage{\\n\\t\\t\\tcontent{\\n\\t\\t\\t\\tid\\n\\t\\t\\t}\\n\\t\\t}\\n\\t}\\n\\t\\n}\"}";
                response = ApiUtils.request(ConfigurationReader.get("dev4URI"), requestForMatchID);
                jsonPath = response.jsonPath();
                log.info(response.prettyPrint());
                matchID.add(jsonPath.getString("data.getRoundSwissPage.contentPage.content.id"));
                System.out.println("matchID.toString() = " + matchID.toString());
            }


            for (int j = 1; j <= (participant / 2); j++) {
                Random rand = new Random(); //instance of random class
                int firstScore = rand.nextInt(10);
                int secSocre = rand.nextInt(10);
                String requestForMatchReport = "{\"query\":\"mutation {\\n\\treportMatchScoreSwiss(\\n\\t\\tbracketId: \\\"" + bracketID.substring(1,37) + "\\\",\\n    matchId: \\\"" + matchID.get((x)).substring(1,37) + "\\\",\\n    scores: [\\n        {\\n            scoreIndex: 0,\\n            winnerId: \\\"\\\",\\n            score: {\\n                first: " + firstScore + ",\\n                second: " + secSocre + "\\n            }\\n    }\\n    ]\\n\\t){\\n\\t\\tid\\n\\t}\\n}\"}";
                response = ApiUtils.request(ConfigurationReader.get("dev4URI"), requestForMatchReport);
                jsonPath = response.jsonPath();
                log.info(response.prettyPrint());
                x++;

            }
            k++;
            if(k>round){break;}
            String requestForNextRound="{\"query\":\"mutation {\\n\\tgenerateNextRoundSwiss(bracketId: \\\""+bracketID.substring(1,37)+"\\\"){\\n\\t\\tgroupMatches{\\n\\t\\t\\tteam1Id\\n\\t\\t\\tteam2Id\\n\\t\\t}\\n\\t}\\n}\"}";
            response = ApiUtils.request(ConfigurationReader.get("dev4URI"), requestForNextRound);
            jsonPath = response.jsonPath();
            log.info(response.prettyPrint());
        }

    }



}

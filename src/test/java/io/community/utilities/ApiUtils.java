package io.community.utilities;

import io.community.step_deffinitions.Login_stepdef;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response request(String URI,String request ) {
     Response response = given().headers(
             "Authorization",
             "Bearer " + Login_stepdef.token,
             "Content-Type", "application/json").body(request).when().post(URI);
     return response;
 }
   public static String date(){
       LocalDate date=LocalDate.now();
       int i=date.getDayOfMonth();
       DateTimeFormatter dateTimeFormatter
               =DateTimeFormatter.ofPattern("YYYY-MM-dd");

       String startDate= dateTimeFormatter.format(date);
       return startDate;


   }

   public static String roundRobin(int phaseIndex,int maxParticipantCount,int gamesPerRound,int playPerTeams,int teamsPerGroup,int numberofGroups){

        String roundRobin ="{phaseIndex:"+phaseIndex+"," +
                "bracketName: \\\"createdForAutomationTest\\\"," +
                "bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\"," +
                "bracketType: ROUND_ROBIN," +
                "maxParticipantCount: "+maxParticipantCount+"," +
                "isSelfReportAllowed: true," +
                "roundRobinDetails:{gamesPerRound:"+gamesPerRound+"," +
                "playTimePerTeams:"+playPerTeams+"," +
                "teamsPerGroup:"+teamsPerGroup+"," +
                "numberOfGroups : "+numberofGroups+"," +
                "roundRobinScoringRule:{win:3,draw:1,lose:0\\t}\\t}}";

        return roundRobin;
   }

   public static String swiss(int phaseIndex,int maxParticipantCount,int gamesPerRound,int playPerTeams,int roundCount){
        String swiss ="{phaseIndex:"+phaseIndex+"," +
                "bracketName: \\\"createdForAutomationTest\\\"," +
                "bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\"," +
                "bracketType: SWISS," +
                "maxParticipantCount:"+maxParticipantCount+"," +
                "isSelfReportAllowed: true," +
                "swissDetails:{gamesPerRound:"+gamesPerRound+"," +
                "playTimePerTeams:"+playPerTeams+"," +
                "numberOfTeams:"+maxParticipantCount+","+
                "roundCount:"+roundCount+"," +
                "swissScoringRule:{win:3,draw:1,lose:0}}}";
        return swiss;
   }

   public static String singleElemination(int phaseIndex,int maxParticipantCount){
        String singleElemination="{phaseIndex:"+phaseIndex+"," +
                "bracketName: \\\"asd\\\"," +
                "bracketStartDate: \\\"2022-01-19T21:59:08.454Z\\\"," +
                "bracketType:SINGLE_ELIMINATION," +
                "maxParticipantCount: "+maxParticipantCount+"," +
                "isSelfReportAllowed: true,}";
        return singleElemination;
   }

}

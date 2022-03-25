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

}

package io.community.step_deffinitions;
import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Quests_stepdef {
    Response response=null;
    JsonPath jsonPath=null;
    String questID=null;
    Faker faker =new Faker();
    String questName=null;


    @When("admin should be able to create new quest for test environment")
    public void admin_should_be_able_to_create_new_quest_for_test_environment() {
        LocalDate date=LocalDate.now();
        LocalDate tomorrow =date.plusDays(1);
        DateTimeFormatter dateTimeFormatter
                =DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String startDate= dateTimeFormatter.format(tomorrow);
        questName=faker.name().fullName();
        System.out.println(startDate);
        String request="{\"query\":\"mutation{\\n\\tcreateQuest(\\n\\t\\tquest: {\\n\\t\\t\\tname:\\\""+questName+"\\\",\\n\\t\\t\\ticonUrl: \\\"https://assets.communitygaming.io/quest/icon/123asdtest.png\\\"\\n\\t\\t\\tsponsoredName:\\\"Test123\\\"\\n\\t\\t\\tstartDate:\\\""+startDate+"T00:00:00.000Z\\\",\\n\\t\\t\\tendDate: \\\"2050-03-28T00:00:08.454Z\\\",\\n\\t\\t\\ttype: SPONSORED,\\n\\t\\t\\tactions:[\\n\\t\\t\\t\\t{\\n\\t\\t\\t\\t\\tname: \\\"login  standard 111 day\\\",\\n\\t\\t\\t\\t\\tactionType:LOGIN,\\n\\t\\t\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype:NON_CRYPTO,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\tschedule:{\\n\\t\\t\\t\\t\\t\\ttype:ACTION_COUNT,\\n\\t\\t\\t\\t\\t\\tactionCount: 1\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t}\\n\\t\\t\\t]\\n\\t\\t\\tuserFilter: {\\n\\t\\t\\t\\tuserType: ACTIVE_USER\\n\\t\\t\\t}\\n\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype: COIN,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t}\\n\\t){\\n\\t\\tid\\n\\t}\\n}\"}";
       response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
       jsonPath=response.jsonPath();
        System.out.println(response.prettyPrint());
        questID=jsonPath.getString("data.createQuest.id");
        System.out.println("questID= "+questID);

    }
    @Then("Quest id should be created")
    public void quest_id_should_be_created() {
        Assert.assertTrue(!questID.isEmpty());
    }
    @When("admin should be able to delete quest")
    public void admin_should_be_able_to_delete_quest() {
     String request="{\"query\":\"mutation{\\n\\tdeleteQuest(\\n\\t\\tquestId: \\\""+questID+"\\\"\\n\\t)\\n}\"}";

     response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
     jsonPath=response.jsonPath();

    }
    @Then("admin search for deleted quest should get not found message")
    public void admin_search_for_deleted_quest_should_get_not_found_message() {
        String request="{\"query\":\"query{\\n\\tgetQuest(questId:\\\""+questID+"\\\"){\\n\\t\\tid\\n\\t\\tname\\n\\t\\tstartDate\\n\\t\\tendDate\\n\\t\\tsponsoredName\\n\\t\\ticonUrl\\n\\t\\tactions{\\n\\t\\t\\tid\\n\\t\\t\\tname\\n\\t\\t\\tdayIndex\\n\\t\\t\\tactionType\\n\\t\\t\\tstartDate\\n\\t\\t\\tendDate\\n\\t\\t}\\n\\t\\tuserFilter{\\n\\t\\t\\tuserType\\n\\t\\t\\tusers\\n\\t\\t}\\n\\t}\\n}\"}";

      response=  ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath =response.jsonPath();
        System.out.println(response.prettyPrint());
        System.out.println(jsonPath.getString("errors.message"));
        Assert.assertTrue(jsonPath.getString("errors.message").contains("not Found"));

    }

    @When("user try to delete active quest")
    public void user_try_to_delete_active_quest() {
        String request="{\"query\":\"mutation{\\n\\tdeleteQuest(\\n\\t\\tquestId: \\\"c754ead3-7813-4397-8b1b-d09429d4807b\\\"\\n\\t)\\n}\"}";
        response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        System.out.println(response.prettyPrint());

    }
    @Then("user should get Cannot delete active quest message")
    public void user_should_get_cannot_delete_active_quest_message() {
     Assert.assertTrue(jsonPath.getString("errors.message").contains("Cannot delete active quest"));

    }

    @When("user try to create quest with today")
    public void user_try_to_create_quest_with_today() {
        LocalDate date=LocalDate.now();
        DateTimeFormatter dateTimeFormatter
                =DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String startDate= dateTimeFormatter.format(date);
        System.out.println(startDate);
        String request="{\"query\":\"mutation{\\n\\tcreateQuest(\\n\\t\\tquest: {\\n\\t\\t\\tname:\\\"Tek Sef2erlik Quest\\\",\\n\\t\\t\\ticonUrl: \\\"https://assets.communitygaming.io/quest/icon/123asdtest.png\\\"\\n\\t\\t\\tsponsoredName:\\\"Test123\\\"\\n\\t\\t\\tstartDate:\\\""+startDate+"T00:00:00.000Z\\\",\\n\\t\\t\\tendDate: \\\"2050-03-28T00:00:08.454Z\\\",\\n\\t\\t\\ttype: SPONSORED,\\n\\t\\t\\tactions:[\\n\\t\\t\\t\\t{\\n\\t\\t\\t\\t\\tname: \\\"login  standard 111 day\\\",\\n\\t\\t\\t\\t\\tactionType:LOGIN,\\n\\t\\t\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype:NON_CRYPTO,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\tschedule:{\\n\\t\\t\\t\\t\\t\\ttype:ACTION_COUNT,\\n\\t\\t\\t\\t\\t\\tactionCount: 1\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t}\\n\\t\\t\\t]\\n\\t\\t\\tuserFilter: {\\n\\t\\t\\t\\tuserType: ACTIVE_USER\\n\\t\\t\\t}\\n\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype: COIN,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t}\\n\\t){\\n\\t\\tid\\n\\t}\\n}\"}";
        response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        System.out.println(response.prettyPrint());


    }
    @Then("user should get Start date cannot be before tomorrow\"")
    public void user_should_get_start_date_cannot_be_before_tomorrow() {
       Assert.assertTrue(jsonPath.getString("errors.message").contains("Start date cannot be before tomorrow"));
    }

    @When("admin try to create same quest again")
    public void admin_try_to_create_same_quest_again() {
        LocalDate date=LocalDate.now();
        LocalDate tomorrow =date.plusDays(1);
        DateTimeFormatter dateTimeFormatter
                =DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String startDate= dateTimeFormatter.format(tomorrow);
        String request="{\"query\":\"mutation{\\n\\tcreateQuest(\\n\\t\\tquest: {\\n\\t\\t\\tname:\\\""+questName+"\\\",\\n\\t\\t\\ticonUrl: \\\"https://assets.communitygaming.io/quest/icon/123asdtest.png\\\"\\n\\t\\t\\tsponsoredName:\\\"Test123\\\"\\n\\t\\t\\tstartDate:\\\""+startDate+"T00:00:00.000Z\\\",\\n\\t\\t\\tendDate: \\\"2050-03-28T00:00:08.454Z\\\",\\n\\t\\t\\ttype: SPONSORED,\\n\\t\\t\\tactions:[\\n\\t\\t\\t\\t{\\n\\t\\t\\t\\t\\tname: \\\"login  standard 111 day\\\",\\n\\t\\t\\t\\t\\tactionType:LOGIN,\\n\\t\\t\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype:NON_CRYPTO,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t\\tschedule:{\\n\\t\\t\\t\\t\\t\\ttype:ACTION_COUNT,\\n\\t\\t\\t\\t\\t\\tactionCount: 1\\n\\t\\t\\t\\t\\t}\\n\\t\\t\\t\\t}\\n\\t\\t\\t]\\n\\t\\t\\tuserFilter: {\\n\\t\\t\\t\\tuserType: ACTIVE_USER\\n\\t\\t\\t}\\n\\t\\t\\treward:{\\n\\t\\t\\t\\t\\t\\ttype: COIN,\\n\\t\\t\\t\\t\\t\\tcurrencyId: \\\"kwai\\\",\\n\\t\\t\\t\\t\\t\\tamount: 12\\n\\t\\t\\t\\t\\t}\\n\\t\\t}\\n\\t){\\n\\t\\tid\\n\\t}\\n}\"}";
        response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath=response.jsonPath();
        System.out.println(response.prettyPrint());
    }
    @Then("admin should get Quest name cannot be same already created quest message")
    public void admin_should_get_quest_name_cannot_be_same_already_created_quest_message() {
      Assert.assertTrue(jsonPath.getString("errors.message").contains("Quest name cannot be same already created quest"));
    }





}

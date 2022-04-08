package io.community.step_deffinitions;

import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class MuitipleTraslation_stepdef {
    Response response=null;
    JsonPath jsonPath=null;
    Faker faker =new Faker();
    String id=null;
    String key;
    String text;
    String countryCode;


    @When("User send request for addnig new parameters \\(unique key, status Active-passive)")
    public void user_send_request_for_addnig_new_parameters_unique_key_status_active_passive() {
         key= faker.gameOfThrones().city()+ ApiUtils.date();
         text= faker.gameOfThrones().character();
         countryCode=faker.country().countryCode2();
        String request ="{\"query\":\"mutation{\\n\\taddNewTranslationKey(translationInput:{\\n\\t\\tkey:\\\""+key+"\\\"\\n\\t\\ttext:\\\""+text+"\\\"\\n\\t\\tlanguageCode:\\\""+countryCode+"\\\"\\n\\t\\tstatus:ACTIVE\\n\\t}){\\n\\t\\tid\\n\\t\\tkey\\n\\t\\ttext\\n\\t\\tlanguageCode\\n\\t\\tstatus\\n\\t}\\n}\"}";

        response=ApiUtils.request(ConfigurationReader.get("testURI"),request);
        log.info("Traslation="+response.prettyPrint());
        jsonPath=response.jsonPath();



    }
    @Then("Translation key should be added.")
    public void translation_key_should_be_added() {
       id=jsonPath.getString("data.addNewTranslationKey.id");
        Assert.assertTrue(jsonPath.getString("data.addNewTranslationKey.key").equals(key));
        Assert.assertTrue(jsonPath.getString("data.addNewTranslationKey.text").equals(text));
        Assert.assertTrue(!id.isEmpty());

    }



}

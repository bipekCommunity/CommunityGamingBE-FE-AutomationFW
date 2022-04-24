package io.community.step_deffinitions;

import com.github.javafaker.Faker;
import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class AdminPanel_stepdef {
     Response response;
     JsonPath jsonPath;
     Faker faker=new Faker();
     String id;


    @When("Admin queries by getFinancialTransaction endpoint")
    public void admin_queries_by_get_financial_transaction_endpoint() {
        String request="{\"query\":\"query{\\n\\tgetFinancialTransaction(financialDetailFilter:{\\n\\t\\t,startDate:\\\"2021-11-19T21:59:08.454Z\\\",\\n\\t} count:5 offset:0 sortBy:\\\"originName\\\" sort:ASC\\n\\t\\n\\t)\\n\\t{\\n\\t\\tuserId,\\n\\t\\t\\tamount,\\n\\t\\tamountInUSD,currencyId,chain,from,id,originName,status,to,userId,\\n\\t\\tfinancialTransactionType\\n\\t\\t\\toriginId,\\n\\t\\t\\toriginName\\n\\t\\t}\\n\\t\\t\\n\\t}\\n\"}";
        response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
         jsonPath = response.jsonPath();
         log.info("getFinancialTransaction="+response.prettyPrint());

    }
    @Then("getFinancialTransaction results should be not empty")
    public void get_financial_transaction_results_should_be_not_empty() {
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.userId").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.amount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.amountInUSD").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.currencyId").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.chain").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.id").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.originName").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.status").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.financialTransactionType").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getFinancialTransaction.originId").isEmpty());
    }

    @When("Admin queries by getUserFinancialTransaction endpoint")
    public void admin_queries_by_get_user_financial_transaction_endpoint() {
      String request="{\"query\":\"query{\\n\\tgetUserFinancialTransaction(userId:\\\"6611e97e-1048-439b-9f53-9cd3505af2a1\\\")\\n\\t{\\n\\t\\tuserId,\\n\\t\\tuserName,\\n\\t\\ttotalBalance\\n\\t\\ttournamentTransactions{\\n\\t\\t\\tamount,\\n\\t\\t\\toriginId,\\n\\t\\t\\toriginName\\n\\t\\t}\\n\\t\\tquestTransactions{\\n\\t\\t\\toriginName,amount,\\n\\t\\t\\toriginId,\\n\\t\\t\\toriginName\\n\\t\\t\\t\\n\\t\\t}\\n\\t}\\n}\"}";
       response= ApiUtils.request(ConfigurationReader.get("testURI"),request);
        jsonPath = response.jsonPath();
        log.info("getFinancialTransaction="+response.prettyPrint());
    }
    @Then("getUserFinancialTransaction results should not be empty")
    public void get_user_financial_transaction_results_should_not_be_empty() {
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.userId").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.userName").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.totalBalance").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.tournamentTransactions.amount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.tournamentTransactions.originId").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.tournamentTransactions.originName").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.questTransactions.originName").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.questTransactions.amount").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.getUserFinancialTransaction.questTransactions.originId").isEmpty());

    }

    @When("user try to create new token")
    public void user_try_to_create_new_token() {
      String tokenName=faker.witcher().character();
        String tokenSymbol=faker.currency().code();
        String tokenContract= faker.currency().name();
        String permitSignature= faker.app().name();

        String request="{\"query\":\"mutation {\\n\\taddToken(\\n\\t\\tnewTokenInput: {\\n\\t\\t\\ttokenName: \\\""+tokenName+"\\\"\\n\\t\\t\\ttokenSymbol: \\\""+tokenSymbol+"\\\"\\n\\t\\t\\ttokenContract: \\\""+tokenContract+"\\\"\\n\\t\\t\\tchainType: MAINNET\\n\\t\\t\\tusdPrice: 0.15\\n\\t\\t\\ttokenDecimals: 1812\\n\\t\\t\\tpermitSignature: \\\""+permitSignature+"\\\"\\n\\t\\t}\\n\\t) {\\n\\t\\tid\\n\\t\\tname\\n\\t\\tsymbol\\n\\t\\tchain\\n\\t\\tlogo\\n\\t\\taddress\\n\\t\\tusdPrice\\n\\t\\ttokenVersion\\n\\t\\tdecimals\\n\\t\\tpermitSignature\\n\\t\\tcreatedAt\\n\\t\\tupdatedAt\\n\\t}\\n}\\n\"}";

        response= ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
        log.info(response.prettyPrint());
        jsonPath=response.jsonPath();
        id= jsonPath.getString("data.addToken.id");



    }
    @Then("Input data should be created correctly")
    public void input_data_should_be_created_correctly() {
       Assert.assertTrue(!jsonPath.getString("data.addToken.id").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.name").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.symbol").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.chain").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.logo").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.address").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.usdPrice").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.tokenVersion").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.decimals").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.permitSignature").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.createdAt").isEmpty());
        Assert.assertTrue(!jsonPath.getString("data.addToken.updatedAt").isEmpty());

    }
    @When("user can be able to edit created token's data")
    public void user_can_be_able_to_edit_created_token_s_data() {
        String newTokenName=faker.witcher().character();
        String newTokenSymbol=faker.currency().code();
        String newTokenContract= faker.currency().name();
        String newPermitSignature= faker.app().name();

        String request="{\"query\":\"mutation {\\n\\teditToken(\\n\\t\\teditTokenInput: {\\n\\t\\t\\tid: \\\""+jsonPath.getString("data.addToken.id")+"\\\"\\n\\t\\t\\taddress: \\\""+newTokenContract+"\\\"\\n\\t\\t\\tchain: MAINNET\\n\\t\\t\\tdecimals: 15\\n\\t\\t\\tlogo: \\\"updatedTokenLogo\\\"\\n\\t\\t\\tname: \\\""+newTokenName+"\\\"\\n\\t\\t\\tpermitSignature: \\\""+newPermitSignature+"\\\"\\n\\t\\t\\tsymbol: \\\""+newTokenSymbol+"\\\"\\n\\t\\t\\ttokenVersion: 4\\n\\t\\t\\tusdPrice: 13\\n\\t\\t\\t\\n\\t\\t\\t\\n\\t\\t}\\n\\t) {\\n\\t\\tid\\n\\t\\taddress\\n\\t\\tchain\\n\\t\\tdecimals\\n\\t\\tlogo\\n\\t\\tname\\n\\t\\tpermitSignature\\n\\t\\tsymbol\\n\\t\\ttokenVersion\\n\\t\\tusdPrice\\n\\t}\\n}\\n\"}";
        response= ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
        log.info(response.prettyPrint());
        jsonPath=response.jsonPath();

        Assert.assertEquals(jsonPath.getString("data.editToken.name"),newTokenName);
        Assert.assertEquals(jsonPath.getString("data.editToken.address"),newTokenContract);
        Assert.assertEquals(jsonPath.getString("data.editToken.symbol"),newTokenSymbol);
        Assert.assertEquals(jsonPath.getString("data.editToken.permitSignature"),newPermitSignature);


    }
    @When("user can be able to delete created token")
    public void user_can_be_able_to_delete_created_token() {

        String request="{\"query\":\"mutation {\\n  softDeleteToken(tokenId: \\\""+id+"\\\") \\n  \\n  \\n}\\n\"}";

        response=ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
        log.info(response.prettyPrint());
    }
    @Then("Deleted token should appear in token list")
    public void deleted_token_should_not_list_with_tokens() {
       String request="{\"query\":\"{\\n\\ttokens {\\n\\t\\tid\\n\\t\\tname\\n\\t\\tsymbol\\n\\t\\tchain\\n\\t\\tlogo\\n\\t\\taddress\\n\\t\\tusdPrice\\n\\t\\ttokenVersion\\n\\t\\tdecimals\\n\\t\\tpermitSignature\\n\\t\\tcreatedAt\\n\\t\\tupdatedAt\\n\\t}\\n}\\n\"}";

       response=ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
       jsonPath=response.jsonPath();
        log.info(response.prettyPrint());
     log.info(jsonPath.getString("data.tokens.id"));
        Assert.assertTrue(jsonPath.getString("data.tokens.id").contains(id));
    }


    @When("user try to create new game with valid data")
    public void usertry_to_create_new_game_with_valid_data() {

       String gameName=faker.funnyName().name();
        String urlEnd=faker.name().firstName();

        String request="{\"query\":\"mutation {\\n\\taddGame(\\n\\t\\" +
                "tgameName: \\\""+gameName+"\\\"\\n\\t\\" +
                "timageUrl: \\\"https://assets.communitygaming.io/games/"+urlEnd+"\\\"\\n\\t\\" +
                "ttags: [FPS]\\n\\t) {\\n\\t\\tid\\n\\t\\tname\\n\\t\\turl\\n\\t\\tcreatedAt\\n\\t\\tupdatedAt\\n\\t}\\n}\\n\"}";

        response=ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
        log.info(response.prettyPrint());
        jsonPath=response.jsonPath();
        id=jsonPath.getString("data.addGame.id");
    }
    @Then("game should be created")
    public void game_should_be_created() {

      Assert.assertTrue(!jsonPath.getString("data.addGame.id").isEmpty());
    }
    @Then("user can be able to edit Game info with valid data")
    public void user_can_be_able_to_edit_game_info_with_valid_data() {
        String gameName=faker.funnyName().name();
        String url=faker.name().lastName();

        String request="{\"query\":\"mutation {\\n\\teditGame(\\n\\t\\teditGameInput: {\\n\\t\\t\\tid: \\\""+id+"\\\"\\n\\t\\t\\tname: \\\""+gameName+"\\\"\\n\\t\\t\\turl: \\\"https://assets.communitygaming.io/games/"+url+"\\\"\\n\\t\\t\\tautomatable: false\\n\\t\\t\\ttags: [SPORTS]\\n\\t\\t}\\n\\t) {\\n\\t\\tname\\n\\t\\turl\\n\\t\\tupdatedAt\\n\\t}\\n}\\n\"}";

        response=ApiUtils.request(ConfigurationReader.get("dev2URI"),request);
        log.info(response.prettyPrint());
        jsonPath=response.jsonPath();

        Assert.assertTrue(jsonPath.getString("data.editGame.name").contains(gameName));
        Assert.assertTrue(jsonPath.getString("data.editGame.url").contains(url));

    }




}

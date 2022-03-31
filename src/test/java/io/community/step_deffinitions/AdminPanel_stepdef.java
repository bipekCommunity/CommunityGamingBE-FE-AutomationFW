package io.community.step_deffinitions;

import io.community.utilities.ApiUtils;
import io.community.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class AdminPanel_stepdef {
     Response response;
     JsonPath jsonPath;

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


}

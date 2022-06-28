package io.community.step_deffinitions;

import io.community.pages.MainPage;
import io.community.utilities.BrowserUtils;
import io.community.utilities.Environment;
import io.cucumber.java.en.*;

public class UIMain_stepdef {

    MainPage mainPage=new MainPage();


    @Given("User clicks Sign In button")
    public void user_clicks_sign_in_button() {
     BrowserUtils.clickElement(mainPage.sigInBtn);
    }
    @When("User enters {string} userName  {string} password to fields")
    public void user_enters_user_name_password_to_fields(String userName, String password) {
        BrowserUtils.sendKeys(mainPage.txt_userName,userName);
        BrowserUtils.sendKeys(mainPage.txt_password,password);
    }
    @When("User clicks to sigIn button")
    public void user_clicks_to_sig_in_button() {
        BrowserUtils.clickElement(mainPage.btn_SignIn);
    }
    @Then("User should be able to logged in to CG")
    public void user_should_be_able_to_logged_in_to_cg() {
        BrowserUtils.checkElementsText(mainPage.allHeaderMenu,"My Teams");
    }

}

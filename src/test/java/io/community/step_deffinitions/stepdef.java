package io.community.step_deffinitions;

import io.community.utilities.ConfigurationReader;
import io.community.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class stepdef {


    @Given("openbrowser")
    public void openbrowser() {

       Driver.get().get(ConfigurationReader.get("url"));


    }
    @Then("click sometihng")
    public void click_sometihng() {

       WebElement element= Driver.get().findElement(By.cssSelector(".btn-black[href='/explore']"));

       element.click();

       Driver.closeDriver();



    }

}

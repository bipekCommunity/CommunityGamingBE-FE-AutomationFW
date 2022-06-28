package io.community.step_deffinitions;

import io.community.utilities.ConfigurationReader;
import io.community.utilities.Driver;
import io.community.utilities.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private Scenario scenario;


    

    @Before("@ui")
    public void setUp(){

        Driver.get().get(Environment.URL);
        Driver.get().manage().window().fullscreen();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    @After("@ui")
    public void tearDown(Scenario scenario) throws InterruptedException {


        if (scenario.isFailed ()){
            byte[] screenshot= ((TakesScreenshot) Driver.get ()).getScreenshotAs ( OutputType.BYTES );

            scenario.attach ( screenshot,"image/png","screenshot" );


        }
        Driver.closeDriver ();

        Thread.sleep(2000);
        Driver.closeDriver();

    }
}


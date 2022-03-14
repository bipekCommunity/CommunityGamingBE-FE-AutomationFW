package io.community.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void openBrowser(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().fullscreen();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static void closeBrowser(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()){
            byte[] screenshot= ((TakesScreenshot) Driver.get ()).getScreenshotAs ( OutputType.BYTES );

            scenario.attach ( screenshot,"image/png","screenshot" );

        }
        Driver.closeDriver ();

        Thread.sleep(2000);
        Driver.closeDriver();

    }
}

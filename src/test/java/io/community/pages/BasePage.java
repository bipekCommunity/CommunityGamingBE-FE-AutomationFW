package io.community.pages;

import io.community.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements ( Driver.get (), this );
    }
}

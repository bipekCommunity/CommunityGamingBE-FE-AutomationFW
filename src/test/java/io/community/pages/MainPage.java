package io.community.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(css = "[href='/signIn']")
    public WebElement sigInBtn;

    @FindBy(id = "username")
    public WebElement txt_userName;

    @FindBy(id = "password")
    public WebElement txt_password;

    @FindBy(id = "ButtonSubmit")
    public WebElement btn_SignIn;

    @FindBy(xpath = "//div[@class='menu-item-container first']/a")
    public List<WebElement> allHeaderMenu;





}

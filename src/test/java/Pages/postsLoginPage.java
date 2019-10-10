package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postsLoginPage {
    WebDriver driver;
    public postsLoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='user_pass']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='wp-submit']")
    public WebElement loginButton;
}

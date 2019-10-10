package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyLoginPages {
    WebDriver driver;
    public EtsyLoginPages(){
        driver=Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="sign-in")
    public WebElement signIn;
    @FindBy(id="join_neu_email_field")
    public WebElement emailBox;
    @FindBy (id="join_neu_password_field")
    public WebElement passwordBox;

}

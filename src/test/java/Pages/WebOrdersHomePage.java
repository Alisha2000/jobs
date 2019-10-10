package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

    public class WebOrdersHomePage {

        WebDriver driver;

        public WebOrdersHomePage(){
            driver= Driver.getDriver();
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath = "//a[@href='Process.aspx']")
        public WebElement OrdersButton;

        @FindBy(xpath = "//table[@class='SampleTable']//tr//td[2]")
        public List<WebElement> customerNames;

    }


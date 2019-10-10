package Pages;

import Utilities.Driver;
import gherkin.lexer.Pa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postsPage {
    WebDriver driver;
    public postsPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//a[@class='wp-first-item'])[2]")
    public WebElement posts;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement allPosts;
    @FindBy(xpath = "//a[@class='page-title-action']")
    public WebElement addNew;
    @FindBy(xpath = "//textarea[@id='post-title-0']")
    public WebElement addTitle;
    @FindBy(xpath = "//p[@class='block-editor-rich-text__editable editor-rich-text__editable wp-" +
            "block-paragraph']")
    public WebElement text;
    @FindBy(xpath = "//button[@class='components-button editor-post-publish-panel__" +
            "toggle is-button is-primary']")
    public WebElement publish;
}

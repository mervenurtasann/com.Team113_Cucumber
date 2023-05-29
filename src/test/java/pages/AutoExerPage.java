package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoExerPage {
    public AutoExerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement signUpLinki;
    @FindBy(xpath = "//*[@*='signup-name']")
    public WebElement signUpNameKutusu;
    @FindBy(xpath = "//*[@*='signup-email']")
    public WebElement signUpEmailKutusu;
    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement signUpButonu;
    @FindBy(xpath = "//*[@id='id_gender2']")
    public WebElement mrsButonu;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButonu;
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedYaziElementi;
}

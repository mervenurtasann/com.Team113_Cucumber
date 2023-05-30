package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutoExerPage;
import utilities.Driver;

public class AutomationExerciseStepdefinitions {
    Faker faker = new Faker();
    AutoExerPage autoExerPage = new AutoExerPage();
    String emailAdress;
    String firstName;
    Actions actions;

    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        autoExerPage.signUpLinki.click();
    }

    @Given("user Create an account bolumune name ve email adresi girer")
    public void user_create_an_account_bolumune_name_ve_email_adresi_girer() {
        firstName = faker.name().firstName();
        autoExerPage.signUpNameKutusu.sendKeys(firstName);
        emailAdress = faker.internet().emailAddress();
        autoExerPage.signUpEmailKutusu.sendKeys(emailAdress);
    }

    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        autoExerPage.signUpButonu.click();
    }

    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() throws InterruptedException {
        autoExerPage.mrsButonu.click();
        actions = new Actions(Driver.getDriver());
        actions.click(autoExerPage.mrsButonu)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("6")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1997")
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("07100")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
    }

    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {
        autoExerPage.createAccountButonu.click();

    }

    @Then("hesap olustugunu test edin")
    public void hesap_olustugunu_test_edin() {
        Assert.assertTrue(autoExerPage.accountCreatedYaziElementi.isDisplayed());
    }
    @Then("Login to your account bolumunda email kutusuna @isareti olmayan email adresi yazar")
    public void login_to_your_account_bolumunda_email_kutusuna_isareti_olmayan_email_adresi_yazar() {
        autoExerPage.loginEmailKutusu.sendKeys("ByeByeWorld");
    }
    @Then("password kutusuna bir sifre ve enter’a tiklar")
    public void password_kutusuna_bir_sifre_ve_enter_a_tiklar() {
        autoExerPage.loginPasswordKutusu.sendKeys("SeeYouSoon" + Keys.ENTER);
    }

    @Then("sisteme giris yapilamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {
        Assert.assertTrue(autoExerPage.loginPasswordKutusu.isEnabled());
    }
}

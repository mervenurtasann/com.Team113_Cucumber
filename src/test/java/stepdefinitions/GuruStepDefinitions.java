package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.w3c.dom.stylesheets.LinkStyle;
import pages.Guru99Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuruStepDefinitions {
    List<String> sirketListesi = new ArrayList<>();
    Guru99Page guru99Page = new Guru99Page();

    @Then("Company listesini consola yazdirir")
    public void company_listesini_consola_yazdirir() {
        sirketListesi = ReusableMethods.stringListeCevir(guru99Page.sirketElementList);
        System.out.println(sirketListesi);
    }

    @And("listede {string} oldugunu test eder")
    public void listedeOldugunuTestEder(String istenenSirket) {
        Assert.assertTrue(sirketListesi.contains(istenenSirket));
    }

    @Then("tum sayfa Screenshot alir")
    public void tumSayfaScreenshotAlir() throws IOException {
        ReusableMethods.getScreenshot("Guru99");
    }

    @Given("{string} Prev.Close degerini yazdirir")
    public void prev_close_degerini_yazdirir(String istenenSirket) {
        // //tbody/tr[9]/td[3]
        // sirket ismi   //tbody/tr[?]/td[1] locacter'i ile bulunup
        // previous deger   //tbody/tr[?]/td[3] locater' ile elde edilecek

        // satir sayisini bulalim
        int satirSayisi = guru99Page.satirlarListesi.size();

        for (int i = 1; i < satirSayisi; i++) {
            String dinaminXpath = "//tbody/tr[" + i + "]/td[1]";
            String satirdakiSirketIsmi = 
                    Driver.getDriver().findElement(By.xpath(dinaminXpath)).getText();
            if (satirdakiSirketIsmi.equalsIgnoreCase(istenenSirket)){
                dinaminXpath = "//tbody/tr["+ i +"]/td[3]";
                String istenenSirketPreValue = 
                        Driver.getDriver().findElement(By.xpath(dinaminXpath)).getText();
                System.out.println(istenenSirketPreValue);
            }
        }

    }

}

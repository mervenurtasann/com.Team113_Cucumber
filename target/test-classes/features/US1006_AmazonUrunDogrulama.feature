Feature: US1006 Amazonda aranan urun dogrulamasi
  @wip
  Scenario: TC12 Aranan urunun dogru oldugunu test edilebilmeli
    
    Given Kullanici "amazonUrl" anasayfaya gider
    Then "Nutella" icin arama yapar
    And Ilk urune click yapar
    And Acilan urun isminin "Nutella" icerdigini test eder
    And Sayfayi kapatir
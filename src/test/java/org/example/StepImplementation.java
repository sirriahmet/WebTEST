package org.example;


import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class StepImplementation extends BaseTest {

    @Step("<Key> Saniye Bekle")
    public void waitWithSecond(int Key) throws InterruptedException {
        Gauge.writeMessage("Saniye Bekleniyor");
        TimeUnit.SECONDS.sleep(Key);
    }

    @Step("Css'i <element> olan elemente tıkla.")
    public void clickCSS(String element) {
        driver.findElement(By.cssSelector(element)).click();
    }

    @Step("Id'si <element> olan elemente tıkla.")
    public void clickID(String element) {
        driver.findElement(By.id(element)).click();
    }

    @Step("Xpath'i <element> olan elemente tıkla.")
    public void clickXpath(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    @Step("Id'si <element> olan elementi bul ve <key> değeri yaz")
    public void sendKeysById(String element, String key) {
        driver.findElement(By.id(element)).sendKeys(key);
    }

    @Step("Xpath'i <element> olan elementi bul ve <key> değeri yaz")
    public void sendKeysByXpath(String element, String key) {
        driver.findElement(By.xpath(element)).sendKeys(key);
    }

    @Step("Login kontrolü yapılır")
    public void loginCheck() {
        String expectedText = driver.findElement(
                By.xpath("//span[@class='sf-OldMyAccount-PhY-T']")).getText();
        Assert.assertEquals("Login işlemi başarısız.", "Hesabım", expectedText);

    }

    @Step("Sepet tutar kontrolü")
    public void basketValue() {
        String numberOfItems = driver.findElement((By.id("cartItemCount"))).getText();
        System.out.println(numberOfItems);
    }

    @Step(("Rasgele bir ürün seçilir,isim ve fiyat değeri alınır"))
    public void getProductByXpath() {
        String productName = driver.findElement(By.xpath("//p[@class='hb-pl-cn']")).getText();
        String productPrice = driver.findElement(By.xpath("//span[@class='price product-price']")).getText();

    }


}













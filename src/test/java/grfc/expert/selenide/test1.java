package grfc.expert.selenide;

import com.codeborne.selenide.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class test1 {

    @Before
    public void start() {
        Configuration.timeout = 8000;
        Configuration.browser = "chrome";
        ChromeOptions opts = new ChromeOptions();
        opts.addExtensions(new File("C:\\Users\\psi\\git\\selenide\\selenideui\\CryptoPro Extension for CAdES Browser Plug-in.crx"));
        opts.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(opts);
        WebDriverRunner.setWebDriver(driver);
    }
    @Test
    public void endToEnd() {
        Settings.expTitle = "302";
//        open("http://192.168.71.62");

// MAN:

        LoginPage.login("man");
        CommonPage.openCard(Settings.expTitle);
        ModalPage.appointExperts();
        ModalPage.workWithExpByMan();
        ModalPage.closeModal();
        CommonPage.logout();

        LoginPage.login("groupman");
        CommonPage.viewConfirmTab();
        CommonPage.openCard(Settings.expTitle);
        ModalPage.workWithExpByGroupMan();
        ModalPage.closeModal();
        CommonPage.logout();

        LoginPage.login("topman");
        CommonPage.viewApproveTab();
        CommonPage.openCard(Settings.expTitle);
        ModalPage.workWithExpByTopMan();

//        $(By.xpath("//div[@class='tab-content tab-content_1']//button[descendant::span[contains(.,'Назначить')]]")).shouldBe(disabled);

//        $(By.xpath("//li[contains(.,'Экспертов Руководитель группы')]//div[@class='b-control-button']")).click();
//        $(By.xpath("//li[contains(.,'Рядовой Эксперт')]//div[@class='b-control-button']")).click();

//        $(By.xpath("//div[@class='tab-content tab-content_1']//button[descendant::span[contains(.,'Назначить')]]")).shouldBe(enabled).click();
//        $(By.xpath("//div[@class='text text_default text_project text_bold margin_b_10'][contains(text(),'Эксперты')]")).should(appear);

//        $(By.xpath("//div[@class='card__content__controls padding_t_10']//button[descendant::span[contains(.,'Перейти к экспертизе')]]"))
//                .shouldBe(enabled)
//                .click();
//        $(By.xpath("//span[@class='b-violation-tag__decision']")).click();
//        $(By.xpath("//div[@class='opinion']//textarea")).setValue("testtesttest");
//        $(By.xpath("//div[@class='b-dropzone js-dropzone']/input")).sendKeys("C:\\Users\\psi\\Documents\\_work\\E000-433_18.docx");
//        $(By.xpath("//div[@class='opinion__files']//div[@class='opinion__btn']/button[@class='button button_items button_green']")).exists();
//        $(By.xpath("//button/span[contains(text(),'Внести мнение')]")).click();
//        $(By.xpath("//span[@class='button__inner'][contains(text(),'Отозвать')]")).shouldBe(enabled).click();
//        $(By.xpath("//button/span[contains(text(),'Внести мнение')]")).shouldBe(enabled);
//        $(By.xpath("//button/span[contains(text(),'Вернуть в очередь')]")).shouldBe(enabled);
//        $(By.xpath("//button/span[contains(text(),'Внести мнение')]")).click();
//        $(By.xpath("//div[@class='b-popup-head__close  b-control-close']")).click();
//        $(By.xpath("//span[@class='b-button__label--login'][contains(.,'Выйти')]")).click();

// GROUPMAN:

//        $(By.xpath("//div[@class='b-popup b-popup--login']")).exists();
//        $(By.xpath("//input[@type ='text']")).setValue("groupman");
//        $(By.xpath("//input[@type ='password']")).setValue("pswd");
//        $(By.xpath("//button[@class='b-button--login']")).click();
//        $(By.xpath("//span[@class='b-tab__title'][contains(text(),'Согласовать')]")).click();
//        Selenide.refresh();
//        $(By.xpath("//tr[contains(.,'" + Settings.expTitle + "')]//span[contains(.,'" + Settings.expTitle + "')]")).click();
//        $(By.xpath("//span[@class='b-violation-tag__decision']")).click();
//        $(By.xpath("//button/span[contains(text(),'Вернуть в очередь')]")).shouldBe(enabled);
//        $(By.xpath("//button/span[contains(text(),'Вернуть на доработку')]")).shouldBe(enabled);
//        $(By.xpath("//button/span[contains(text(),'Согласовать')]")).shouldBe(enabled);
//        $(By.xpath("//button/span[contains(text(),'Согласовать')]")).click();
//        $(By.xpath("//span[@class='button__inner'][contains(text(),'Отозвать')]")).shouldBe(enabled);
//        $(By.xpath("//div[@class='b-popup-head__close  b-control-close']")).click();
//        $(By.xpath("//span[@class='b-button__label--login'][contains(.,'Выйти')]")).click();

// TOPMAN:normalize-space

//        $(By.xpath("//div[@class='b-popup b-popup--login']")).exists();
//        $(By.xpath("//input[@type ='text']")).setValue("topman");
//        $(By.xpath("//input[@type ='password']")).setValue("pswd");
//        $(By.xpath("//button[@class='b-button--login']")).click();
        $(By.xpath("//span[@class='b-tab__title'][contains(text(),'Утвердить')]")).click();
        $(By.xpath("//tr[contains(.,'" + Settings.expTitle + "')]//span[contains(.,'" + Settings.expTitle + "')]")).click();
        $(By.xpath("//span[@class='b-violation-tag__decision']")).shouldHave(text("Да"));
        $(By.xpath("//button/span[contains(text(),'Вернуть на доработку')]")).shouldBe(enabled);
        $(By.xpath("//button/span[contains(text(),'Утвердить')]")).shouldBe(enabled).click();

        try {
          Thread.sleep(20000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }
    @After
    public void finish() {
//        WebDriverRunner.closeWebDriver();
    }
}

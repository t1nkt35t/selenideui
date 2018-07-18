package grfc.expert.selenide;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ModalPage {
//buttons
    static String appointBtn = "//div[@class='tab-content tab-content_1']//button[descendant::span[contains(.,'Назначить')]]";
    static String goToExpBtn = "//div[@class='card__content__controls padding_t_10']//button[descendant::span[contains(.,'Перейти к экспертизе')]]";
    static String callBackBtn = "//span[@class='button__inner'][contains(text(),'Отозвать')]";
    static String backtoQueBtn = "//span[@class='button__inner'][contains(text(),'Вернуть в очередь')]";
    static String confirmBtn = "//button/span[contains(text(),'Согласовать')]";
    static String approveBtn = "//button/span[contains(text(),'Утвердить')]";
    static String setOpinionBtn = "//button/span[contains(text(),'Внести мнение')]";
    static String closeBtn = "//div[@class='b-popup-head__close  b-control-close']";
    static String fileDropZoneBtn = "//div[@class='b-dropzone js-dropzone']/input";
    static String backToWorkBtn = "//button/span[contains(text(),'Вернуть на доработку')]";
    static String saveBtn = "//div[@class='card__content__common']//button[contains(.,'Сохранить')]";

    //elements to verify
    static String author = "//li[contains(.,'Экспертов Руководитель группы')]//div[@class='b-control-button']";
    static String coAuthor = "//li[contains(.,'Рядовой Эксперт')]//div[@class='b-control-button']";
    static String authorListBeforeChoose = "//div[starts-with(.,'Добавить в экспертную группу')]//li[contains(.,'Экспертов Руководитель группы')]//div[@class='b-control-button']";
    static String coAuthorListBeforeChoose = "//div[starts-with(.,'Добавить в экспертную группу')]//div[starts-with(.,'Эксперты')]//li[contains(.,'Рядовой Эксперт')]//div[@class='b-control-button']";
    static String authorChosen = "//div[@class='margin_b_30'][starts-with(.,'Выбраны')]//div[@class='padding_t_10'][starts-with(.,'Руководитель экспертной группы')]//div[@class='b-user-list']";
    static String coAuthorChosen = "//div[@class='margin_b_30'][starts-with(.,'Выбраны')]//div[@class='padding_t_10'][starts-with(.,'Эксперты')]//div[@class='b-user-list']";
    static String yesOrNoSwitch = "//span[@class='b-violation-tag__decision']";
    static String commentText = "//div[@class='opinion']//textarea";
    static String backFromUploadComment = "//div[@class='b-control-button'][contains(.,'Назад')]";
    static String uploadComment = "//div[@class='card__content__common']//textarea";

    static void appointExperts () {
        $(By.xpath(appointBtn)).shouldBe(disabled);
        $(By.xpath(coAuthorListBeforeChoose)).shouldBe(visible);
        $(By.xpath(coAuthor)).click();
        $(By.xpath(coAuthorChosen)).shouldBe(visible);
        $(By.xpath(appointBtn)).shouldBe(disabled);
        $(By.xpath(authorListBeforeChoose)).shouldBe(visible);
        $(By.xpath(author)).click();
        $(By.xpath(authorChosen)).shouldBe(visible);
        $(By.xpath(appointBtn)).shouldBe(enabled)
                               .click();
        $(By.xpath(goToExpBtn)).click();
    }

    static void workWithExpByMan () {
        $(By.xpath(yesOrNoSwitch)).click();
        $(By.xpath(commentText)).setValue("testtesttest");
//        Selenide.executeJavaScript("arguments[0].removeAttribute('style')", $(By.xpath(fileDropZoneBtn)));
        $(By.xpath(fileDropZoneBtn)).sendKeys(Settings.uploadFilePath);
        $(By.xpath(backFromUploadComment)).shouldBe(visible);
        $(By.xpath(uploadComment)).sendKeys("tozdtozdtozd");
        $(By.xpath(saveBtn)).click();
        $(By.xpath(setOpinionBtn)).click();
        $(By.xpath(callBackBtn)).click();
        $(By.xpath(backtoQueBtn)).shouldBe(enabled);
        $(By.xpath(setOpinionBtn)).click();
    }

    static void workWithExpByGroupMan () throws InterruptedException {
        $(By.xpath(yesOrNoSwitch)).click();
        $(By.xpath(backToWorkBtn)).shouldBe(enabled);
        $(By.xpath(backtoQueBtn)).shouldBe(enabled);
        $(By.xpath(fileDropZoneBtn)).sendKeys(Settings.uploadFilePath);
        $(By.xpath(backFromUploadComment)).shouldBe(visible);
        $(By.xpath(uploadComment)).sendKeys("tozdtozdtozd");
        $(By.xpath(saveBtn)).click();
        Thread.sleep(2000);
        $(By.xpath(confirmBtn)).click();
        $(By.xpath(callBackBtn)).click();
        $(By.xpath(backtoQueBtn)).shouldBe(enabled);
        $(By.xpath(confirmBtn)).click();
    }

    static void workWithExpByTopMan () {
        $(By.xpath(yesOrNoSwitch)).shouldHave(text("Да"));
        $(By.xpath(backToWorkBtn)).shouldBe(enabled);
        $(By.xpath(approveBtn)).click();
    }

    static void closeModal () {
        $(By.xpath(closeBtn)).click();
        }

}

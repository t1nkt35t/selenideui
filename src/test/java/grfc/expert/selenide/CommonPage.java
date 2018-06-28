package grfc.expert.selenide;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CommonPage {

    static String exitBtn = "//span[@class='b-button__label--login'][contains(.,'Выйти')]";
    static String expCard = "//tr[contains(.,'" + Settings.expTitle + "')]//span[contains(.,'" + Settings.expTitle + "')]";
    static String modal = "//div[contains(@class, 'b-popup b-popup--card')]";
    static String confirmTab = "//span[@class='b-tab__title'][contains(text(),'Согласовать')]";
    static String approveTab = "//span[@class='b-tab__title'][contains(text(),'Утвердить')]";

    static void openCard (String title) {
        $(By.xpath(expCard)).click();
        $(By.xpath(modal)).shouldBe(visible);
    }

    static void viewConfirmTab () {
        $(By.xpath(confirmTab)).click();
        Selenide.refresh();
    }

    static void viewApproveTab () {
        $(By.xpath(approveTab)).click();
        Selenide.refresh();
    }

    static void logout () {
        $(By.xpath(exitBtn)).click();
        $(By.xpath(LoginPage.waitFor)).shouldBe(visible);
    }
}

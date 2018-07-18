package grfc.expert.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static junit.framework.TestCase.assertTrue;

public class LoginPage {

    static String nameField = "//input[@type ='text']";
    static String passField = "//input[@type ='password']";
    static String submitBtn = "//button[@class='b-button--login']";

    static String waitFor = "//div[@class='b-popup b-popup--login']";

       public static void login(String role) {
           open(Settings.ip);
           $(By.xpath(nameField)).setValue(role);
           $(By.xpath(passField)).setValue("pswdpswd");
           $(By.xpath(submitBtn)).click();
           $(By.xpath(waitFor)).should(Condition.disappears);
           assertTrue(url().equals(Settings.ip + "/#/expert/inquiry"));
       }
}

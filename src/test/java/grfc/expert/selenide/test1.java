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
    static WebDriver driver;
    @Before
    public void start() {
        Configuration.timeout = 8000;
        Configuration.browser = "chrome";
        ChromeOptions opts = new ChromeOptions();
        opts.addExtensions(new File("C:\\Users\\psi\\git\\selenide\\selenideui\\CryptoPro Extension for CAdES Browser Plug-in.crx"));
        opts.addArguments("start-maximized");
        driver = new ChromeDriver(opts);
        WebDriverRunner.setWebDriver(driver);
    }
    @Test
    public void endToEnd() throws InterruptedException {
        Settings.expTitle = "131319";
//        open("http://192.168.71.62");

// MAN:

        LoginPage.login("man");
        CommonPage.openCard(Settings.expTitle);
        ModalPage.appointExperts();
        ModalPage.workWithExpByMan();
        ModalPage.closeModal();
        CommonPage.logout();

// GROUPMAN:

        LoginPage.login("groupman");
        CommonPage.viewConfirmTab();
        CommonPage.openCard(Settings.expTitle);
        ModalPage.workWithExpByGroupMan();
        ModalPage.closeModal();
        CommonPage.logout();

// TOPMAN:

        LoginPage.login("topman");
        CommonPage.viewApproveTab();
        CommonPage.openCard(Settings.expTitle);
        ModalPage.workWithExpByTopMan();
    }

//    @Test
//    public void

    @After
    public void finish() {
//        WebDriverRunner.closeWebDriver();
    }
}

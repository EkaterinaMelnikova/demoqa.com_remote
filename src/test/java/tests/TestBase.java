package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;

public class TestBase {

    TestData testData = new TestData();
    PracticeFormPage practiceFormPage= new PracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    void addAttachments() {
        com.kimo.helpers.Attach.screenshotAs("Last screenshot");
        com.kimo.helpers.Attach.pageSource();
        com.kimo.helpers.Attach.browserConsoleLogs();
    }
}

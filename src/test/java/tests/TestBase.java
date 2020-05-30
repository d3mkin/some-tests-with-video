package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.CustomWebDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AttachmentsHelper.attachVideo;


@Epic("QA.GURU automation course")
@Story("Google tests with video")
@Tag("google")
class TestBase {

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        System.setProperty("selenoid_url", "selenoid.autotests.cloud"); // emulate terminale -Dkey=value

        Configuration.browser = CustomWebDriver.class.getName();
    }

    @AfterEach
    void afterEach() {
        attachVideo();
    }
}
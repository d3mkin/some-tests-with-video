package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Epic("QA.GURU automation course")
@Story("Google tests with video")
@Tag("google")
class GoogleTests {

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));

        if(System.getProperty("selenoid_url") != null) {
            Configuration.remote = "http://" + System.getProperty("selenoid_url") + ":4444/wd/hub/";
        }
    }

    @Test
    @Description("Google test, we look for wikipedia")
    @DisplayName("Successful search for wikipedia in google")
    void successfulSearch() {
        open("http://google.com");

        $(byName("q")).val("wikipedia").pressEnter();

        $("html").shouldHave(text("wikipedia.org"));
    }

    @Test
    @Description("Google test, we look for wikipedia, but dont want to find")
    @DisplayName("Unsuccessful search for wikipedia in google")
    void unSuccessfulSearch() {
        open("http://google.com");

        $(byName("q")).val("wikipedia").pressEnter();

        $("html").shouldNotHave(text("wikipedia.org"));
    }

}
package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.WebSteps;

public class StepGitTest {
    String repository = "AnuarAbitay/Lesson_7";
    String number = "1";

    @Test
    void stepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage()
                .searchForRepository(repository)
                .clickOnRepositoryLink(repository)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(number);
    }
}

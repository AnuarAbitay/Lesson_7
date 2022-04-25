package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.WebSteps;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitTest {
    String repository = "AnuarAbitay/Lesson_7";
    String number = "1";


    @Test
    @Feature("Repository Issue")
    @Story("Should see created issue in repo")
    void selenideGitTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository);
        $(".header-search-input").submit();
        $(By.linkText(repository)).click();
        $(By.partialLinkText("Issues")).click();;
        $(withText(number)).should(Condition.visible);
    }

    @Test
    void lambdaGitTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
                    open("https://github.com");
                });
        step("Ищем репозитории" + repository, () ->{
                    $(".header-search-input").click();
                    $(".header-search-input").setValue(repository);
                    $(".header-search-input").submit();
                });
        step("Переходим по ссылке репозитории", () ->{
            $(By.linkText(repository)).click();
        });
        step("Кликаем на таб Issues", () ->{
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issues с номеру" + number, () ->{
            $(withText(number)).should(Condition.visible);
        });
    }

    @Test
    @Feature("Repository Issue")
    @Story("Should see created issue in repo")
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

package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com");

        return this;
    }

    @Step("Переходим по ссылке репозитории")
    public WebSteps searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository);
        $(".header-search-input").submit();

        return this;

    }

    @Step("Переходим по ссылке репозитори {repository}")
    public WebSteps clickOnRepositoryLink(String repository) {
        $(By.linkText(repository)).click();
        return this;
    }

    @Step("Кликаем на таб Issues")
    public WebSteps openIssuesTab() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверяем что существует Issues с номером {number}")
    public WebSteps shouldSeeIssueWithNumber(String number) {
        $(withText(number)).should(Condition.visible);

        return this;
    }
}

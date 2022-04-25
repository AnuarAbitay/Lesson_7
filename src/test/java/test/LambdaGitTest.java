package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaGitTest {
    String repository = "AnuarAbitay/Lesson_7";
    String number = "1";

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
}

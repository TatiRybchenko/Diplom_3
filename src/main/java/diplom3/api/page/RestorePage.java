package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class RestorePage {

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;
    //локатор наименования формы "Восстановление пароля"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Восстановление пароля')]")
    private SelenideElement nameFormRestore;

    @Step("Проверяем текст наименования страницы на форме Восстановление пароля")
    public void checkTextPageFormRestore() {
        nameFormRestore.shouldHave(exactText("Восстановление пароля"));
    }
    @Step("Нажимаем на кнопку Войти")
    public void clickEnterButton() {
        enterButton.click();
    }
}

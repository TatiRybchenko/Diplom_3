package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import configuration.UrlConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    public static final String BASE_URL = ConfigFactory.create(UrlConfig.class).baseUrl();

    //локатор кнопки "Личный Кабинет" вверх страницы
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccountUpButton;
    //локатор кнопки "Войти в акаунт" внизу страницы
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement loginAccountDownButton;

    @Step("Нажимаем на кнопку Личный кабинет, вверх страницы")
    public void clickPersonalAccountUpButton() {
        personalAccountUpButton.click();
    }

    @Step("Нажимаем на кнопку Войти в акаунт, внизу страницы")
    public void clickLoginAccountDownButton() {
        loginAccountDownButton.click();
    }
}

package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPersonalAccountHome {

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement personalAccountRegisterButton;

    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement personalAccountRestorePasswordButton;

    @Step("Нажимаем на кнопку Войти")
    //метод клика по кнопке Войти
    public void clickEnterButton() {
        enterButton.click();
    }
    @Step("Нажимаем на кнопку Зарегистрироваться")
    //метод клика по кнопке Зарегистрироваться
    public void clickPersonalAccountRegisterButton() {
        personalAccountRegisterButton.click();
    }

    @Step("Нажимаем на кнопку Восстановить пароль")
    //метод клика по кнопке Зарегистрироваться
    public void clickPersonalAccountRestorePasswordButton() {
        personalAccountRestorePasswordButton.click();
    }

}

package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.exactText;

public class LoginAccountPage {

    //локатор текста формы "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Вход')]")
    private SelenideElement nameTextPageFormLogin;
    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement enterButton;
    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement personalAccountRegisterButton;
    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement personalAccountRestorePasswordButton;
    //локатор строки "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement lineInputEmail;
    //локатор строки "Пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement lineInputPassword;

    //метод ввода данных в поле Email на форме Вход
    public void fillLineInputEmail(String userEmail) {
        lineInputEmail.setValue(userEmail);    }
    //метод ввода данных в поле Password на форме Вход
    public void fillLineInputPassword(String userPassword) {
        lineInputPassword.setValue(userPassword);    }

    @Step("Нажимаем на кнопку Войти")
    public void clickEnterButton() {
        enterButton.click();
    }
    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickPersonalAccountRegisterButton() {
        personalAccountRegisterButton.click();
    }
    @Step("Нажимаем на кнопку Восстановить пароль")
    public void clickPersonalAccountRestorePasswordButton() {
        personalAccountRestorePasswordButton.click();
    }
    @Step("Проверяем, что выполнен переход на страницу Входа")
    public boolean isTextPageFormLoginDisplayed(){
        return nameTextPageFormLogin.isDisplayed();
    }
    @Step("Проверяем текст наименования страницы на форме Вход")
    public void checkTextPageFormLogin() {
        nameTextPageFormLogin.shouldHave(exactText("Вход"));
    }
    @Step("Заполняем форму логина: почта {userEmail}, пароль {userPassword}")
    public void fillFormLoginUser(String userEmail, String userPassword) {
        fillLineInputEmail(userEmail);
        fillLineInputPassword(userPassword);
    }
}

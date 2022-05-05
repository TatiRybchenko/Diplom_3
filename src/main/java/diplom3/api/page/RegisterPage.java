package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.exactText;

public class RegisterPage {

    //локатор строки "Имя"
    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default']")
    private SelenideElement lineInputName;
    //локатор строки "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement lineInputEmail;
    //локатор строки "Пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement lineInputPassword;
    //локатор формы "Регистрация"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Регистрация')]")
    private SelenideElement nameFormRegister;
    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;
    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;
    //локатор текста сообщение об ошибки "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Некорректный пароль')]")
    private SelenideElement textErrorPassword;

    //метод клика по строке имя
    public void clickLineInputName() {
        lineInputName.click();
    }
    //метод клика по строке Email
    public void clickLineInputEmail() {
        lineInputEmail.click();
    }
    //метод клика по строке Password
    public void clickLineInputPassword() {
        lineInputPassword.click();
    }
    //метод ввода данных в поле имя на форме Регистрация
    public void fillLineInputName(String userName) {
        lineInputName.setValue(userName);
    }
    //метод ввода данных в поле Email на форме Регистрация
    public void fillLineInputEmail(String userEmail) {
        lineInputEmail.setValue(userEmail);
    }
    //метод ввода данных в поле Password на форме Регистрация
    public void fillLineInputPassword(String userPassword) {
        lineInputPassword.setValue(userPassword);
    }
    @Step("Проверяем текст наименования страницы на форме Регистрация")
    public void checkTextPageFormRegister() {
        nameFormRegister.shouldHave(exactText("Регистрация"));
    }
     @Step("Заполняем форму регистрации: имя {userName}, почта {userEmail}, пароль {userPassword}")
    public void fillFormRegisterUser(String userName, String userEmail, String userPassword) {
        fillLineInputName(userName);
        fillLineInputEmail(userEmail);
        fillLineInputPassword(userPassword);
    }
    @Step("Проверяем текст сообщения об ошибке")
    public void checkTextErrorMessageInputPassword(){
        textErrorPassword.shouldHave(exactText("Некорректный пароль"));
    }
    @Step("Нажимаем на кнопку Войти")
    public void clickEnterButton() {
        enterButton.click();
    }
    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        registerButton.click();
    }
}
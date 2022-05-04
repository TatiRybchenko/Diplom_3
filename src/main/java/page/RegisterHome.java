package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterHome {

    //локатор строки "Имя"
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Имя')]")
    private SelenideElement lineInputName;

    //локатор строки "Email"
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Email')]")
    private SelenideElement lineInputEmail;

    //локатор строки "Пароль"
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Пароль')]")
    private SelenideElement lineInputPassword;


    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @Step("Нажимаем на строку ввода имя")
    //метод клика по строке имя
    public void clickLineInputName() {
        lineInputName.click();}

    @Step("Нажимаем на строку ввода Email")
    //метод клика по строке Email
    public void clickLineInputEmail() {
        lineInputEmail.click();}

    @Step("Нажимаем на строку ввода Password")
    //метод клика по строке Password
    public void clickLineInputPassword() {
        lineInputPassword.click();}

    @Step("Нажимаем на кнопку Войти")
    //метод клика по кнопке Войти
    public void clickEnterButton() {
        enterButton.click();
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    //метод клика по кнопке Зарегистрироваться
    public void clickRegisterButton() {
        registerButton.click();}


}
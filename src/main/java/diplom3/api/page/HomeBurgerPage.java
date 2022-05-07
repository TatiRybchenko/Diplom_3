package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import configuration.UrlConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class HomeBurgerPage {
    public static final String BASE_URL = ConfigFactory.create(UrlConfig.class).baseUrl();

    //локатор кнопки "Личный Кабинет" вверх страницы
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccountUpButton;
    //локатор кнопки "Войти в акаунт" внизу страницы
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement loginAccountDownButton;
    //локатор формы "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement nameTextPageFormBurger;
    //локатор перехода вкладки "Булки"
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement bunTub;
    //локатор текста раздела "Булки"
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Булки')]")
    public SelenideElement nameTextBunTub;
    //локатор перехода вкладки "Соусы"
    @FindBy(how = How.XPATH,using = ".//div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement sauceTub;
    //локатор текста раздела "Соусы"
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Соусы')]")
    public SelenideElement nameTextSauceTub;
    //локатор перехода вкладки "Начинки"
    @FindBy(how = How.XPATH,using = ".//div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement toppingsTub;
    //локатор текста раздела "Начинки"
    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Начинки')]")
    public SelenideElement nameTextToppingsTub;

    @Step("Нажимаем на кнопку Личный кабинет, вверх страницы")
    public void clickPersonalAccountUpButton() {
        personalAccountUpButton.click();
    }
    @Step("Нажимаем на кнопку Войти в акаунт, внизу страницы")
    public void clickLoginAccountDownButton() {
        loginAccountDownButton.click();
    }
    @Step("Проверяем текст наименования страницы на форме Соберите бургер")
    public void checkTextPageFormBurger() {
        nameTextPageFormBurger.shouldHave(exactText("Соберите бургер"));
    }
    @Step("Выполнен переход на страницу Соберите бургер")
    public boolean isTextPageFormBurgerDisplayed (){
        return nameTextPageFormBurger.isDisplayed();
    }
    @Step("Переход по клику в раздел «Булки»")
    public void clickBunTub() {
        bunTub.click();
    }
    @Step("Проверяем текст в разделе конструктора «Булки»")
    public boolean isTextBunTubDisplayed (){
        return  nameTextBunTub.isDisplayed();
    }
    @Step("Переход по клику в раздел «Соусы»")
    public void clickSauceTub() {
        sauceTub.click();
    }
    @Step("Проверяем текст в разделе конструктора «Соусы»")
    public boolean isTextSauceDisplayed(){
        return  nameTextSauceTub.isDisplayed();
    }
    @Step("Переход по клику в раздел «Начинки»")
    public void clickToppingsTub() {
        toppingsTub.click();
    }
    @Step("Проверяем текст в разделе конструктора «Начинки»")
    public boolean isTextToppingsDisplayed(){
        return  nameTextToppingsTub.isDisplayed();
    }

}

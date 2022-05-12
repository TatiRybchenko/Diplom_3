package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static diplom3.api.page.HomeBurgerPage.BASE_URL;

public class ProfileAccountPage {

    //локатор линка "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Профиль')]")
    private SelenideElement nameTextLinkProfile;
    //локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;
    //локатор  логотип  "Stellar Burgers"
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButtonSB;
    //локатор  кнопки "Выход"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Выход')]")
    private SelenideElement logOffButton;

     @Step("Переход по клику на «Конструктор»")
    public void clickConstructorButton() {
        constructorButton.click();
    }
    @Step("Переход по клику на логотип «Stellar Burgers», проверяем URL страницы при переходе")
    public void clickLogoButtonSBurger() {
        logoButtonSB.click();
     }
    @Step("Проверяем текст наименования страницы на Профиле")
    public void checkTextPageFormProfile() {
        nameTextLinkProfile.shouldHave(exactText("Профиль"));
    }
    @Step("Проверяем, что выполнен переход на страницу Акаунта")
    public boolean isTextLinkProfileDisplayed(){
        return nameTextLinkProfile.isDisplayed();
    }
    @Step("Нажимаем на кнопку Выход")
    public void clickReloginButton() {
        logOffButton.click();
    }
}

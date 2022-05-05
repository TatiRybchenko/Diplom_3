package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class ProfileAccountPage {

    //локатор линка "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Профиль')]")
    private SelenideElement nameTextLinkProfile;
    //локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;
    //локатор  логотип  "Stellar Burgers"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement logoButtonSB;


    @Step("Проверяем текст наименования страницы на Профиле")
    public void checkTextPageFormProfile() {
        nameTextLinkProfile.shouldHave(exactText("Профиль"));
    }
    @Step("Проверяем, что выполнен переход на страницу Акаунта")
    public boolean isWindowOrderIsProcessedDisplayed (){
        return nameTextLinkProfile.isDisplayed();
    }
}

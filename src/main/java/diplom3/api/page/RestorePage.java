package diplom3.api.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePage {

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterButton;

    @Step("Нажимаем на кнопку Войти")
    //метод клика по кнопке Войти
    public void clickEnterButton() {
        enterButton.click();
    }
}

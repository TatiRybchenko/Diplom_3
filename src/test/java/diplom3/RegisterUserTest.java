package diplom3;

import diplom3.api.User;
import diplom3.api.UserClient;
import diplom3.api.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import diplom3.api.page.HomePage;
import diplom3.api.page.LoginAccountPage;
import diplom3.api.page.RegisterPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest {
    private UserClient userClient;
    private User user;


    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getDataFaker();
            }

    @Test
    @DisplayName("Регистрация нового пользователя. Валидные параметры.")
    @Description("Регистрация нового пользователя. Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctRegisterUserUpPersonalAccount() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickPersonalAccountUpButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.clickPersonalAccountRegisterButton();

        RegisterPage pageRegister = page(RegisterPage.class);
        pageRegister.checkTextPageFormRegister();
        pageRegister.fillFormRegisterUser(user.getName(), user.getEmail(), user.getPassword());
        pageRegister.clickRegisterButton();

        pageLoginPersonalAccount.isWindowOrderIsProcessedDisplayed();

        ValidatableResponse loginResponse = userClient.loginUser(UserCredentials.from(user));
        String accessToken = loginResponse.extract().jsonPath().get("accessToken").toString().replace("Bearer ","");
        userClient.deleteUser(accessToken);

        assertTrue("Переход на страницу Входа, не произошел, пользователь не зарегистрирован", pageLoginPersonalAccount.isWindowOrderIsProcessedDisplayed());
}
    @Test
    @DisplayName("Регистрация нового пользователя. Невалидные параметры.")
    @Description("Регистрация нового пользователя. Пользователь не зарегистрирован, Некорректный пароль, меньше 6 символов ")
    public void invalidRegisterUserUpPersonalAccountErrorPassword() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickPersonalAccountUpButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.clickPersonalAccountRegisterButton();

        RegisterPage pageRegister = page(RegisterPage.class);
        pageRegister.checkTextPageFormRegister();
        pageRegister.fillFormRegisterUser(user.getName(), user.getEmail(), user.getPassword().substring(5));
        pageRegister.clickRegisterButton();
        pageRegister.checkTextErrorMessageInputPassword();

        pageLoginPersonalAccount.isWindowOrderIsProcessedDisplayed();

        assertFalse("Сообщение, что пароль некорректный не сработало, выполнен переход на экранную форму Входа", pageLoginPersonalAccount.isWindowOrderIsProcessedDisplayed());
    }
}


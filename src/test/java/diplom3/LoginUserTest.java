package diplom3;

import diplom3.api.User;
import diplom3.api.UserClient;
import diplom3.api.UserCredentials;
import diplom3.api.page.HomePage;
import diplom3.api.page.LoginAccountPage;
import diplom3.api.page.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginUserTest {
    private UserClient userClient;
    private User user;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getDataFaker();
        userClient.createUser(user);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной. Валидные параметры.")
    @Description("Вход по кнопке «Войти в аккаунт» на главной. Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctRegisterUserUpPersonalAccount() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickLoginAccountDownButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

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


}

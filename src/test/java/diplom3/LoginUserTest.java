package diplom3;

import diplom3.api.User;
import diplom3.api.UserClient;
import diplom3.api.UserCredentials;
import diplom3.api.page.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
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
    @After
    public void tearDown(){
        ValidatableResponse loginResponse = userClient.loginUser(UserCredentials.from(user));
        String accessToken = loginResponse.extract().jsonPath().get("accessToken").toString().replace("Bearer ","");
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной. Валидные параметры.")
    @Description("Вход по кнопке «Войти в аккаунт» на главной. Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctLoginHomeFormAccountDownButton() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickLoginAccountDownButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPager = page(ProfileAccountPage.class);
        profileAccountPager.checkTextPageFormProfile();

        assertTrue("Переход на страницу Профиля акаунта, не произошел, пользователь не залогинился", profileAccountPager.isWindowOrderIsProcessedDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет». Валидные параметры.")
    @Description("Вход через кнопку «Личный кабинет». Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctLoginUserPersonalAccountFormEnterButton() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickPersonalAccountUpButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPager = page(ProfileAccountPage.class);
        profileAccountPager.checkTextPageFormProfile();

        assertTrue("Переход на страницу Профиля акаунта, не произошел, пользователь не залогинился", profileAccountPager.isWindowOrderIsProcessedDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации. Валидные параметры.")
    @Description("Вход через кнопку в форме регистрации. Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctLoginUserRegisterFormEnterButton() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickPersonalAccountUpButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.clickPersonalAccountRegisterButton();

        RegisterPage pageRegister = page(RegisterPage.class);
        pageRegister.checkTextPageFormRegister();
        pageRegister.clickEnterButton();

        pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPager = page(ProfileAccountPage.class);
        profileAccountPager.checkTextPageFormProfile();

        assertTrue("Переход на страницу Профиля акаунта, не произошел, пользователь не залогинился", profileAccountPager.isWindowOrderIsProcessedDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля. Валидные параметры.")
    @Description("Вход через кнопку в форме восстановления пароля. Корректные данные имя, почта и пароль, создаются рандомно. После проверки регистрации, данные о пользователе удаляются через запрос api")
    public void correctLoginUserRestoreFormEnterButton() {

        HomePage pageHeader = open(HomePage.BASE_URL, HomePage.class);
        pageHeader.clickPersonalAccountUpButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.clickPersonalAccountRestorePasswordButton();

        RestorePage pageRestore = page(RestorePage.class);
        pageRestore.checkTextPageFormRestore();
        pageRestore.clickEnterButton();

        pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPager = page(ProfileAccountPage.class);
        profileAccountPager.checkTextPageFormProfile();

        assertTrue("Переход на страницу Профиля акаунта, не произошел, пользователь не залогинился", profileAccountPager.isWindowOrderIsProcessedDisplayed());
    }

}

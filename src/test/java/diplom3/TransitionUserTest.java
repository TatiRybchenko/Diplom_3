package diplom3;

import diplom3.api.User;
import diplom3.api.UserClient;
import diplom3.api.UserCredentials;
import diplom3.api.page.HomeBurgerPage;
import diplom3.api.page.LoginAccountPage;
import diplom3.api.page.ProfileAccountPage;
import diplom3.api.page.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class TransitionUserTest {
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
    @DisplayName("Переход из личного кабинета в конструктор. Переходы к разделам «Конструктор».")
    @Description("Переход из личного кабинета в конструктор. Переходы к разделам «Конструктора»: «Булки», «Соусы», «Начинки». Данные о пользователе создаются и удаляются через запрос api")
    public void transitionConstructorButtonTubBunSauceToppings() {

            HomeBurgerPage pageHeader = open(HomeBurgerPage.BASE_URL, HomeBurgerPage.class);
            pageHeader.clickLoginAccountDownButton();

            LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
            pageLoginPersonalAccount.checkTextPageFormLogin();
            pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
            pageLoginPersonalAccount.clickEnterButton();

            pageHeader.clickPersonalAccountUpButton();

            ProfileAccountPage profileAccountPage = page(ProfileAccountPage.class);
            profileAccountPage.checkTextPageFormProfile();
            profileAccountPage.clickConstructorButton();

            pageHeader.checkTextPageFormBurger();
            pageHeader.clickBunTub();
            pageHeader.clickSauceTub();
            pageHeader.clickToppingsTub();

            assertTrue("Переход в раздел Булки, не произошел,", pageHeader.isTextBunTubDisplayed());
            assertTrue("Переход в раздел Соусы, не произошел,", pageHeader.isTextSauceDisplayed());
            assertTrue("Переход в раздел Начинки, не произошел,", pageHeader.isTextToppingsDisplayed());
        }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор. Переходы к по логотипу «Stellar Burgers».")
    @Description("Переход из личного кабинета в конструктор. Переходы к по логотипу «Stellar Burgers». Данные о пользователе создаются и удаляются через запрос api")
    public void transitionLogoStellarBurgersButton() {

        HomeBurgerPage pageHeader = open(HomeBurgerPage.BASE_URL, HomeBurgerPage.class);
        pageHeader.clickLoginAccountDownButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPage = page(ProfileAccountPage.class);
        profileAccountPage.checkTextPageFormProfile();
        profileAccountPage.clickLogoButtonSBurger();

        pageHeader.checkTextPageFormBurger();
        assertTrue("Переход на страницу Соберите бургер не произошел", pageHeader.isTextPageFormBurgerDisplayed());
    }

    @Test
    @DisplayName("Выход из личного кабинета. Переход на страницу Входа.")
    @Description("Переход из личного кабинета в конструктор. Переход на страницу Входа. Данные о пользователе создаются и удаляются через запрос api")
    public void transitionProfileAccountlogOffButton() {

        HomeBurgerPage pageHeader = open(HomeBurgerPage.BASE_URL, HomeBurgerPage.class);
        pageHeader.clickLoginAccountDownButton();

        LoginAccountPage pageLoginPersonalAccount = page(LoginAccountPage.class);
        pageLoginPersonalAccount.checkTextPageFormLogin();
        pageLoginPersonalAccount.fillFormLoginUser(user.getEmail(), user.getPassword());
        pageLoginPersonalAccount.clickEnterButton();

        pageHeader.clickPersonalAccountUpButton();

        ProfileAccountPage profileAccountPage = page(ProfileAccountPage.class);
        profileAccountPage.checkTextPageFormProfile();
        profileAccountPage.clickReloginButton();

        pageLoginPersonalAccount.checkTextPageFormLogin();
        assertTrue("Переход на страницу Соберите бургер не произошел", pageLoginPersonalAccount.isTextPageFormLoginDisplayed());
    }

}

package diplom3.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static diplom3.api.EndPoints.USER_CREATE;
import static diplom3.api.StellarBurgerRestClient.getBaseSpec;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class UserClient {

    @Step("Выполнение запроса логина пользователя, логин {credentials.email} и пароль {credentials.password}")
    public ValidatableResponse loginUser(UserCredentials credentials){
        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(EndPoints.USER_LOGIN)
                .then()
                .statusCode(SC_OK);
    }

    @Step("Выполнение запроса на удаление пользователя c авторизацией")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .auth().oauth2(accessToken)
                .when()
                .delete(EndPoints.USER)
                .then()
                .statusCode(202);
    }

    @Step("Выполнение запроса на создание пользователя со всеми параметрами: имя, логин, пароль.")
    public ValidatableResponse createUser(User user) {

        Map<String,String> requestBodyUserCreate = new HashMap<>();
        requestBodyUserCreate.put("email", user.getEmail());
        requestBodyUserCreate.put("password", user.getPassword());
        requestBodyUserCreate.put("name", user.getName());

        return given()
                .spec(getBaseSpec())
                .body(requestBodyUserCreate)
                .when()
                .post(USER_CREATE)
                .then()
                .statusCode(SC_OK);
    }
}

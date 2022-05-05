package diplom3.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import static io.restassured.http.ContentType.JSON;
import static diplom3.api.page.HomePage.BASE_URL;

public class StellarBurgerRestClient {
    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

}

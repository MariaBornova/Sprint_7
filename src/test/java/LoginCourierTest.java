import courier.Courier;
import courier.CourierApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

import static constants.Data.*;


public class LoginCourierTest extends BaseTest {

    @Test
    @DisplayName("Корректная авторизация курьера")
    public void courierLogin()  {
        Courier courier = new Courier(LOGIN, PASSWORD);
        CourierApiMethods.createCourier(courier);
        Response response = CourierApiMethods.loginCourier(courier);
        courierId = CourierApiMethods.loginCourier(courier).then().extract().path("id");
        response.then().assertThat().statusCode(200)
                .and().
                body("id", notNullValue());
    }
    @Test
    @DisplayName("Авторизация курьера без логина")
    public void courierLoginWithoutLogin() {
        Courier courier = new Courier(EMPTY_LOGIN, PASSWORD);
        Response response = CourierApiMethods.loginCourier(courier);
        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo(ERROR_FOR_LOGIN_COURIER));
    }
    @Test
    @DisplayName("Авторизация курьера без пароля")
    public void courierLoginWithoutPassword() {
        Courier courier = new Courier(LOGIN, EMPTY_LOGIN);
        Response response = CourierApiMethods.loginCourier(courier);
        response.then().assertThat().statusCode(400)
                .and()
                .assertThat().body("message", equalTo(ERROR_FOR_LOGIN_COURIER));
    }
    @Test
    @DisplayName("Авторизация с неверным логином/Несуществующий курьер")
    public void loginCourierWithNonExistLogin() {
        Courier courier = new Courier(NONEXIST_LOGIN, PASSWORD);
        Response response = CourierApiMethods.loginCourier(courier);
        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo(ERROR_FOR_INCORRECT_LOGIN_COURIER));
    }

    @Test
    @DisplayName("Авторизация с несуществующим  паролем")
    public void loginCourierWithNonExistPassword() {
        Courier courier = new Courier(LOGIN, NONEXIST_PASSWORD);
        Response response = CourierApiMethods.loginCourier(courier);
        response.then().assertThat().statusCode(404)
                .and()
                .assertThat().body("message", equalTo(ERROR_FOR_INCORRECT_LOGIN_COURIER));
    }

}


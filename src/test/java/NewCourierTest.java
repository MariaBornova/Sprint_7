import courier.Courier;
import courier.CourierApiMethods;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import static constants.Data.*;


public class NewCourierTest extends BaseTest {

    @Test
    @DisplayName("Создания курьера со всеми обязательными полями")
    public void createCourier() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        Response response = CourierApiMethods.createCourier(courier);
        courierId = CourierApiMethods.loginCourier(courier).then().extract().path("id");;
        response.then().assertThat().statusCode(201).and().body("ok", equalTo(true));
    }
    @Test
    @DisplayName("Создание двух одинаковых курьеров")
    public void createDuplicateCourier() {
        Courier courier = new Courier(LOGIN, PASSWORD, FIRST_NAME);
        CourierApiMethods.createCourier(courier);
        Response responseDuplicate = CourierApiMethods.createCourier(courier);
        courierId = CourierApiMethods.loginCourier(courier).then().extract().path("id");
        responseDuplicate.then().assertThat().body("message", equalTo(ERROR_FOR_INCORRECT_CREATE_COURIER)).statusCode(409);
    }
    @Test
    @DisplayName("Создание курьера с пустым логином")
    public void createCourierWithoutLogin() {
        Courier courierWithoutLogin = new Courier(EMPTY_LOGIN, PASSWORD, FIRST_NAME);
        Response response = CourierApiMethods.createCourier(courierWithoutLogin);
        response.then().assertThat().body("message", equalTo(ERROR_FOR_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с пустым паролем")
    public void createCourierWithoutPassword() {
        Courier courierWithoutPassword = new Courier(LOGIN, EMPTY_PASSWORD, FIRST_NAME);
        Response response = CourierApiMethods.createCourier(courierWithoutPassword);
        response.then().assertThat().body("message", equalTo(ERROR_FOR_CREATE_COURIER)).statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера с пустым именем")
    public void createCourierWithoutName() {
        Courier courierWithoutName = new Courier(LOGIN, PASSWORD, EMPTY_FIRST_NAME);
        Response response = CourierApiMethods.createCourier(courierWithoutName);
        courierId = CourierApiMethods.loginCourier(courierWithoutName).then().extract().path("id");
        response.then().assertThat().body("ok", equalTo(true)).and().statusCode(201);
    }
    @Test
    @DisplayName("Создание курьера с существующим логином")
    public void createCourierWithDoubleLogin() {
        Courier courierWithDoubleLogin = new Courier(LOGIN, SECOND_PASSWORD, FIRST_NAME_2);
        CourierApiMethods.createCourier(courierWithDoubleLogin);
        Response responseDuplicate = CourierApiMethods.createCourier(courierWithDoubleLogin);
        courierId = CourierApiMethods.loginCourier(courierWithDoubleLogin).then().extract().path("id");
        responseDuplicate.then().assertThat().body("message", equalTo(ERROR_FOR_INCORRECT_CREATE_COURIER)).statusCode(409);
    }

}


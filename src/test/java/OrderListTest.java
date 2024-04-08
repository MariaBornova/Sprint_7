import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import order.OrderApiMethods;
import org.junit.Test;
import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest extends BaseTest {
    @Test
    @DisplayName("Получение списка заказов")
    public void orderList() {
        Response response = OrderApiMethods.getOrderList();
        response.then().assertThat().statusCode(200).and().body("orders", notNullValue());
    }
}

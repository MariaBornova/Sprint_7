import courier.CourierApiMethods;
import io.restassured.RestAssured;
import order.OrderApiMethods;
import org.junit.After;
import org.junit.Before;

import static constants.Data.*;


public class BaseTest {
    protected Integer courierId;
    protected Integer track;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void clearData() {
        if (courierId != null) {
            CourierApiMethods.deleteCourier(courierId);
        }
        if (track != null) {
            OrderApiMethods.cancelOrder(track);
        }
    }
}

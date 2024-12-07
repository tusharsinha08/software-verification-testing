import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void testPlaceOrder() {

        ShippingService shippingServiceMock = mock(ShippingService.class);


        when(shippingServiceMock.ship("item1", 5)).thenReturn(true);
        when(shippingServiceMock.ship("item2", -1)).thenReturn(false);
        when(shippingServiceMock.ship("item3", 0)).thenReturn(false);

        OrderService orderService = new OrderService(shippingServiceMock);

        assertTrue(orderService.placeOrder("item1", 5));
        verify(shippingServiceMock).ship("item1", 5);
        assertFalse(orderService.placeOrder("item3", 0));
        verify(shippingServiceMock, never()).ship("item3", 0);

        assertFalse(orderService.placeOrder("item2", -1));
        verify(shippingServiceMock, never()).ship("item2", -1);
    }
}

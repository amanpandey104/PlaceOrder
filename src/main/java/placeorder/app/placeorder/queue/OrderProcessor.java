package placeorder.app.placeorder.queue;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import placeorder.app.placeorder.service.IOrderService;

@Component
@RequiredArgsConstructor
public class OrderProcessor {

    private final IOrderService orderService;

    public void processOrder(Long orderId) {
        try {
            Thread.sleep(2000); // simulate processing
            orderService.updateOrderStatus(orderId, "PROCESSED");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

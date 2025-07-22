package placeorder.app.placeorder.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderQueue {

    private final OrderProcessor orderProcessor;
    private final BlockingQueue<Long> queue = new LinkedBlockingQueue<>();

    public void enqueue(Long orderId) {
        queue.offer(orderId);
    }

    public Long dequeue() throws InterruptedException {
        return queue.take();
    }

    @PostConstruct
    public void startConsumer() {
        new Thread(() -> {
            while (true) {
                try {
                    Long orderId = dequeue();
                    orderProcessor.processOrder(orderId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

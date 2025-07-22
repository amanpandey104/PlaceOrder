package placeorder.app.placeorder.service;

import org.springframework.data.domain.Page;
import placeorder.app.placeorder.dto.OrderDTO;
import placeorder.app.placeorder.entity.OrderEntity;

public interface IOrderService {
    OrderDTO saveNewOrder(OrderEntity entity);
    Page<OrderDTO> fetchAllOrders(int page, int size);
    String fetchOrderStatus(Long id);
    void updateOrderStatus(Long id, String status);
}

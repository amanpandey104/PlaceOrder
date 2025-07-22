package placeorder.app.placeorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import placeorder.app.placeorder.dto.OrderDTO;
import placeorder.app.placeorder.service.IPlaceOrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IPlaceOrderService placeOrderService;

    @PostMapping("/place")
    public OrderDTO placeOrder(@Valid @RequestBody OrderDTO dto) {
        return placeOrderService.placeOrder(dto);
    }

    @GetMapping("/fetch")
    public Page<OrderDTO> getAllOrders(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size ) {
        return placeOrderService.getAllOrders(page, size);
    }

    @GetMapping("/{id}/status")
    public String getOrderStatus(@PathVariable Long id) {
        return placeOrderService.getOrderStatus(id);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        placeOrderService.updateOrderStatus(id, status);
    }

}

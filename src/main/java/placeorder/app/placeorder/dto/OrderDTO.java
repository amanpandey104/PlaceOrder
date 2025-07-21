package placeorder.app.placeorder.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import placeorder.app.placeorder.entity.OrderEntity;

@Getter
@Setter
public class OrderDTO {
    @NotBlank
    private String customerName;

    @NotBlank
    private String items;

    @Positive
    private Double totalAmount;

    @NotNull
    private LocalDateTime orderTime;

    // Convert DTO to Entity
    public static OrderEntity createEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setCustomerName(dto.getCustomerName());
        entity.setItems(dto.getItems());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setOrderTime(dto.getOrderTime());
        return entity;
    }

    // Convert Entity to DTO
    public static OrderDTO valueOf(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName(entity.getCustomerName());
        dto.setItems(entity.getItems());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setOrderTime(entity.getOrderTime());
        return dto;
    }
}

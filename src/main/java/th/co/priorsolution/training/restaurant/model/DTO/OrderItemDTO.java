package th.co.priorsolution.training.restaurant.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    private String menuName;
    private double price;
    private int quantity;
    private String status;
    private double subtotal;
}

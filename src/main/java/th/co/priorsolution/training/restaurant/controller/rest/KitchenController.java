package th.co.priorsolution.training.restaurant.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.priorsolution.training.restaurant.entity.OrderItemEntity;
import th.co.priorsolution.training.restaurant.model.DTO.OrderItemResponseDTO;
import th.co.priorsolution.training.restaurant.model.DTO.OrderItemStatusUpdateResponseDTO;
import th.co.priorsolution.training.restaurant.model.DTO.UpdateOrderStatusRequest;
import th.co.priorsolution.training.restaurant.repository.OrderItemRepository;
import th.co.priorsolution.training.restaurant.repository.OrderRepository;
import th.co.priorsolution.training.restaurant.service.KitchenService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/kitchen")
@CrossOrigin(origins = "*")
public class KitchenController {

    private final KitchenService kitchenService;

    public KitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/orders")
    public List<OrderItemResponseDTO> getOrdersByStation(@RequestParam String station) {
        return kitchenService.getOrdersByStation(station);
    }


    @PutMapping("/orders/{id}/status")
    public OrderItemStatusUpdateResponseDTO updateOrderItemStatus(@PathVariable Integer id,
                                                                  @RequestBody UpdateOrderStatusRequest body) {
        return kitchenService.updateOrderItemStatus(id, body.getStatus());
    }

}

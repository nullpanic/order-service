package com.OrderService.Controller;


import com.OrderService.DTO.OrderDTO;
import com.OrderService.Service.OrderService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class MessageController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDTO> getOrder (@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders () {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping(value = "/orders", consumes = {"application/json"})
    public ResponseEntity<Long> createOrder (@RequestBody OrderDTO orderDTO) {

        Long id = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/orders/{id}", consumes = {"application/json"})
    public ResponseEntity<OrderDTO> updateOrder (@RequestBody OrderDTO orderDTO,
                                                 @PathVariable Long id) {

        OrderDTO orderDTOupdate = orderService.updateOrder(id,orderDTO);
        return ResponseEntity.ok(orderDTOupdate);
    }

    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<String>  deleteOrder ( @PathVariable Long id) {

        orderService.deleteOrder(id);
       return ResponseEntity.ok("Order with id: " + id + " is deleted");
    }
}

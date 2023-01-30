package com.OrderService.DTO;


import com.OrderService.Entity.Order;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO implements Serializable {


    private Set<OrderedCarDTO> cars = new HashSet<>();

    private Long userId;

    public OrderDTO(Order order) {
        order.getOrderedCars().stream().forEach(car -> this.cars.add(new OrderedCarDTO(car)));

    }
}

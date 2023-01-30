package com.OrderService.DTO;

import com.OrderService.Entity.OrderedCar;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderedCarDTO implements Serializable {

    private int amount;

    private int quantity;

    private Long idOfCar;


    public OrderedCarDTO(OrderedCar orderedCar) {
        this.amount   = orderedCar.getAmount();
        this.quantity = orderedCar.getQuantity();
        this.idOfCar  = orderedCar.getIdOfCar();
    }
}

package com.OrderService.Entity;


import com.OrderService.DTO.OrderedCarDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ordered_cars")
public class OrderedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    @Column
    private int amount;

    @Column
    private Long idOfCar;

    @ManyToOne
    private Order order;

    private String model;

    public OrderedCar(OrderedCarDTO orderedCarDTO, Order order){
        this.amount   = orderedCarDTO.getAmount();
        this.order    = order;
        this.quantity = orderedCarDTO.getQuantity();
        this.idOfCar  = orderedCarDTO.getIdOfCar();
    }


//    public void updateOrderedCar(OrderedCarDTO orderedCarDTO, Order order) {
//        this.amount = orderedCarDTO.getAmount();
//        this.quantity = orderedCarDTO.getQuantity();
//        this.order   = order
//    }

}

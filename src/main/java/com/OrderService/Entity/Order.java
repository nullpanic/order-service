package com.OrderService.Entity;

import com.OrderService.DTO.OrderDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany (fetch = FetchType.LAZY, targetEntity = OrderedCar.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Set<OrderedCar> orderedCars = new HashSet<>();

    @Column
    private int amount;


    @Column
    private Long userId;

    public Order(OrderDTO orderDTO) {
        this.userId = orderDTO.getUserId();
        this.orderedCars= orderDTO
                .getCars()
                .stream()
                .map(orderedCarDTO -> new OrderedCar(orderedCarDTO, this))
                .peek(orderedCar -> this.amount += orderedCar.getAmount())
                .collect(Collectors.toSet());

    }

    public Order updateOrder(OrderDTO orderDTO) {
        this.userId = orderDTO.getUserId();

        this.orderedCars.clear();
        this.orderedCars = orderDTO
                .getCars()
                .stream()
                .map(orderedCarDTO -> new OrderedCar(orderedCarDTO, this))
                .peek(orderedCar -> this.amount += orderedCar.getAmount())
                .collect(Collectors.toSet());

        return this;
    }

}

package com.OrderService.Repository;

import com.OrderService.Entity.OrderedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedCarRepository extends JpaRepository<OrderedCar, Long> {
}

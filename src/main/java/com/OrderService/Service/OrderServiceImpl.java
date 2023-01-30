package com.OrderService.Service;

import com.OrderService.DTO.OrderDTO;
import com.OrderService.Entity.Order;
import com.OrderService.Exceptions.OrderNotFoundException;
import com.OrderService.Exceptions.OrdersNotFoundException;
import com.OrderService.Repository.OrderRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {

        try {
            return orderRepository
                    .findAll()
                    .stream()
                    .map(order -> new OrderDTO(order))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new OrdersNotFoundException();
        } catch (Exception e) {
            throw e;
        }


    }

    @Override
    public OrderDTO getOrder(Long id) {
        // need exception
        try {
            Order order = orderRepository.findById(id).get();
            return new OrderDTO(order);
        } catch (NoSuchElementException e){
            throw new OrderNotFoundException("Order not found by id:" + id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override

    public Long createOrder(OrderDTO orderDTO) {

        System.out.println(orderRepository);

        Order order = new Order(orderDTO);
        return orderRepository
                .save(order)
                .getId();

    }

    @Override
    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);

    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {

        try {
            orderRepository.save(orderRepository.findById(id).get().updateOrder(orderDTO));
            return orderDTO;
        } catch (NoSuchElementException e){
            throw new OrderNotFoundException("Order not found by id:" + id);
        }

    }
}

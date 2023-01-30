package com.OrderService.Service;

import com.OrderService.DTO.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO getOrder(Long id);

    Long createOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);

     OrderDTO updateOrder(Long id, OrderDTO orderDTO);
}

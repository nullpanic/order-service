package com.OrderService.Exceptions;

public class OrdersNotFoundException extends RuntimeException{

    public OrdersNotFoundException() {
        super("Orders not found");
    }

}


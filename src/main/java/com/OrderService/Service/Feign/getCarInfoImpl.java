package com.OrderService.Service.Feign;

import com.OrderService.DTO.CarInfoDTO;
import org.springframework.http.ResponseEntity;

public class getCarInfoImpl implements getCarInfo{
    @Override
    public ResponseEntity<CarInfoDTO> getCarInfo() {
        return null;
    }
}

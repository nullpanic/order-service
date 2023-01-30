package com.OrderService.Service.Feign;

import com.OrderService.DTO.CarInfoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8085/api/getCarInfo/",
        name = "getCarInfo")
public interface getCarInfo {

    @GetMapping("/{id}")
    ResponseEntity<CarInfoDTO> getCarInfo();
}

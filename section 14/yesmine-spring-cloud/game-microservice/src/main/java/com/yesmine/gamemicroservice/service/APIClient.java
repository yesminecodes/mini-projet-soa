package com.yesmine.gamemicroservice.service;

import com.yesmine.gamemicroservice.dto.TypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "TYPE")
//@FeignClient(name = "TYPE",fallback = DeptFallBack.class)
@FeignClient(name = "TYPE")
public interface APIClient {
    @GetMapping("api/types/{type-code}")
    TypeDto getTypeByCode(@PathVariable("type-code") String departmentCode
    );
}

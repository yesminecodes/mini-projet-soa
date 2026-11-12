package com.yesmine.gamemicroservice.service;

import com.yesmine.gamemicroservice.dto.TypeDto;
import org.springframework.stereotype.Component;

@Component
public class DeptFallBack implements APIClient {
    @Override
    public TypeDto getTypeByCode(String typeCode) {
        return null;
    }
}


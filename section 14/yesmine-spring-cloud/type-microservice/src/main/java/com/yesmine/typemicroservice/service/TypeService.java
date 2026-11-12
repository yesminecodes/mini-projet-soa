package com.yesmine.typemicroservice.service;

import com.yesmine.typemicroservice.dto.TypeDto;

public interface TypeService {
    TypeDto getTypeByName(String name);
    TypeDto getTypeByCode(String code);
}

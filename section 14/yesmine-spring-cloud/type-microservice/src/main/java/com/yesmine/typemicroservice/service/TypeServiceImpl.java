package com.yesmine.typemicroservice.service;

import com.yesmine.typemicroservice.dto.TypeDto;
import com.yesmine.typemicroservice.entities.Type;
import com.yesmine.typemicroservice.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public TypeDto getTypeByName(String name) {
        Type type = typeRepository.findByTypeName(name);
        if (type == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Type name " + name + " not found");
        }
        return toDto(type);
    }

    @Override
    public TypeDto getTypeByCode(String code) {
        Type type = typeRepository.findByTypeCode(code);
        if (type == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Type code " + code + " not found");
        }
        return toDto(type);
    }

    private TypeDto toDto(Type type) {
        return new TypeDto(type.getId(), type.getTypeName(), type.getTypeCode());
    }
}
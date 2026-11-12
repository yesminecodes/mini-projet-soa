package com.yesmine.typemicroservice.repos;

import com.yesmine.typemicroservice.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByTypeCode(String code);
    Type findByTypeName(String name);
}

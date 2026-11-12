package com.yesmine.typemicroservice.restContollers;

import com.yesmine.typemicroservice.config.AuthorConfig;
import com.yesmine.typemicroservice.dto.TypeDto;
import com.yesmine.typemicroservice.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/types")
@RequiredArgsConstructor
@RefreshScope
public class TypeController {

    private final TypeService typeService;
    private final AuthorConfig authorConfig;

//    @Value("${build.version:unknown}")
//    private String buildVersion;

//    @GetMapping("/version")
//    public ResponseEntity<String> version() {
//        return ResponseEntity.ok(buildVersion);
//    }
//
//    @GetMapping("/author")
//    public ResponseEntity<String> author() {
//        return ResponseEntity.ok(authorConfig.getName() + " " + authorConfig.getEmail());
//    }

    @GetMapping("/{code}")
    public ResponseEntity<TypeDto> getTypeByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(typeService.getTypeByCode(code), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TypeDto> getTypeByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(typeService.getTypeByName(name), HttpStatus.OK);
    }
}
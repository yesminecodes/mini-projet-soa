package com.yesmine.gamemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private Long id;
    private String TypeName;
    private String TypeCode;
}
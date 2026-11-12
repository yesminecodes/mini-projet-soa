package com.yesmine.gamemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    private Long id;
    private String Name;
    private String typeCode;
    private String TypeName;
    private String email;
    private String mobileNumber;


    public GameDto(Long id, String name, String typeCode,String email, String mobileNumber) {
        this.id = id;
        this.Name = name;
        this.typeCode = typeCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }
}
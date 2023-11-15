package com.example.kun_uz.dto;

import com.example.kun_uz.enums.ProfileRole;
import com.example.kun_uz.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private String email;
    private ProfileRole role;
    private ProfileStatus profileStatus;
    private LocalDateTime cretedDate;
}

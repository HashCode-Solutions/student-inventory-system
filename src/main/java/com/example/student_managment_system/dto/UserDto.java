package com.example.student_managment_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
public class UserDto implements Serializable {

    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private RolesDto rolesDto;

}

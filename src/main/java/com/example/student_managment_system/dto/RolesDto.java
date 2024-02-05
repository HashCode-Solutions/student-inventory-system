package com.example.student_managment_system.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolesDto implements Serializable {

    private int id;
    private String roleName;
    private int roleValue;

}

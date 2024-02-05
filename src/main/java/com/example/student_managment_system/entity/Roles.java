package com.example.student_managment_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roleName;
    private int roleValue;
    private Date createdTime;
    private Date lastUpdateTime;
    @OneToOne(mappedBy = "role")
    private Users users;

    public Roles(int id, String roleName, int roleValue) {
        this.id = id;
        this.roleName = roleName;
        this.roleValue = roleValue;
    }
}

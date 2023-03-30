package com.wissen.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "app_user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Email
    private String email;
    private String password;
    private String name;
    private Long phone;


    @Enumerated(EnumType.STRING)
    private AppUserRole ROLE;

    public User(String email, String password, String name, Long phone, AppUserRole appUserRole) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.ROLE = appUserRole;
        this.phone = phone;
    }

}



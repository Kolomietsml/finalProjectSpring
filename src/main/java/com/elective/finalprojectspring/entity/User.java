package com.elective.finalprojectspring.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    @Length(min = 2, message = "*Your user name must have more 2 characters")
    @NotEmpty(message = "*Enter a user name")
    private String name;

    @Length(min = 2, message = "*Your user surname must have more 3 characters")
    @Column(name = "surname")
    @NotEmpty(message = "*Enter a surname")
    private String surname;

    @Email(message = "*Enter a valid email")
    @Column(name = "email")
    @NotEmpty(message = "*Enter email")
    private String email;

    @Column(name = "password")
    @Length(min = 4, message = "*Your password must have more than 4 characters")
    @NotEmpty(message = "*Enter password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleUser")
    private RoleUser roleUser;
}


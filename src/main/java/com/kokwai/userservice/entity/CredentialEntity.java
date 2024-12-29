package com.kokwai.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "credentials" )
public class CredentialEntity {

    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    private String email;
    private String password;

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "credential")
    private UserEntity userEntity;

}

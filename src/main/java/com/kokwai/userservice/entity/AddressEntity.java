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
@Table( name = "addresses" )
public class AddressEntity {

    @Id
    @GeneratedValue( strategy = IDENTITY)
    private Long id;
    private String buildingName;
    private String blkNumber;
    private String level;
    private String unit;
    private String street;
    private Integer zipCode;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            insertable = false,
            updatable = false
    )
    private UserEntity user;

}

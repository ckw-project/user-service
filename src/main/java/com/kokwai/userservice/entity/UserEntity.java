package com.kokwai.userservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "users" )
public class UserEntity {

    @Id
    @GeneratedValue( strategy = IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private LocalDate birthday;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(
            name = "credential_id",
            referencedColumnName = "id"
    )
    private CredentialEntity credential;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    @MapKeyColumn(name = "address_type")
    private Map<String, AddressEntity> addressEntities = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "user_groups", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "group_id")
    private Set<Long> groupIds = new HashSet<>();

}

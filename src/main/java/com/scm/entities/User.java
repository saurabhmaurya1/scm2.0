package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    @Id
    private String userId;

    @Column(name = "user_name",nullable = false)
    private String name;
    
    @Column(unique = true,nullable = false)
    private String email;

    private String password;

    @Column(length = 1000)
    private String about;

    @Column(length = 1000)
    private String profilePic;

    private String phoneNumber;

    // other information

    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerifid= false;


    
    //self , linkedin, fithub, google , facebook
    @Enumerated(value=EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String providerUserId;


    //mapping
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();


}

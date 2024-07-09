package com.scm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;

    private boolean favorite=false;
    private String websiteLink;
    private String linkedInLink;

    private String cloudinaryImagePublicId;

    @ManyToOne
    @JsonIgnore      //we used this because when we return contact as entity so is going in loop ,and after using this we dont get user but if we want user also then we have to use dto
    private User user;


    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL ,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();

    

}

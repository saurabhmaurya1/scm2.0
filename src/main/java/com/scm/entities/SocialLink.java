package com.scm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialLink {
    @Id
    private  Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}

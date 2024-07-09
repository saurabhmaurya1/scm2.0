package com.scm.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scm.entities.Contact;
import com.scm.entities.User;


@Repository
public interface ContactRepo extends JpaRepository<Contact,String> {

    //find Contact by user 

    //Custom finder method
    Page<Contact> findByUser(User user,Pageable pageable);

    //coustom query method
    @Query("SELECT c FROM Contact c WHERE c.user.id = :userId")
    List<Contact> findByUserId(String userId);

    Page<Contact> findByNameContainingAndUser(String nameKeyword,Pageable pageable,User user);

    Page<Contact> findByEmailContainingAndUser(String emailKeyword,Pageable pageable,User user);

    Page<Contact> findByPhoneNumberContainingAndUser(String phoneKeyword,Pageable pageable,User user);

}

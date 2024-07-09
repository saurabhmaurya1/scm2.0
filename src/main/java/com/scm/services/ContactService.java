package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.scm.entities.Contact;
import com.scm.entities.User;


public interface ContactService {

    /**
     * 
     * @param contact
     * @return
     */
    //save Contact
    Contact save(Contact contact);

    // Update Contact
    Contact update(Contact contact);

    //get contact
    List<Contact> getAll();

    //get contact by id

    Contact getById(String id);

    // delete contact by id 

    void delete(String id);

    //Search contact
    List<Contact> search(String name , String email, String phoneNumber);
    Page<Contact> searchByName(String nameKeyword ,int size, int page,String sortBy,String order,User user);
    Page<Contact> searchByEmail(String emailKeyword,int size, int page,String sortBy,String order,User user);
    Page<Contact> searchByPhoneNumber(String phoneNumberKeyWord,int size, int page,String sortBy,String order,User user);


    //get contact by userid
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user,int page,int size,String sortField, String sortDirection);






}

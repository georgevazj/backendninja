package com.udemy.repository;

import com.udemy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Jorge on 3/1/17.
 */

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{
}

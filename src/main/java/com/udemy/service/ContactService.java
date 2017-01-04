package com.udemy.service;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

/**
 * Created by Jorge on 4/1/17.
 */

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);

}

package com.udemy.service;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

import java.util.List;

/**
 * Created by Jorge on 4/1/17.
 */

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAllContacts();

    public abstract Contact findContactById(int id);

    public abstract ContactModel findContactByIdModel(int id);

    public abstract void removeContact(int id);

}

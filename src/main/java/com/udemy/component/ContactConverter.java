package com.udemy.component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

/**
 * Created by Jorge on 4/1/17.
 */

@Component("contactConverter")
public class ContactConverter {

    public Contact model2entity(ContactModel contactModel){
        Contact contact = new Contact();

        contact.setId(contactModel.getId());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setCity(contactModel.getCity());
        contact.setTelephone(contactModel.getTelephone());

        return contact;
    }

    public ContactModel entity2model(Contact contact){
        ContactModel contactModel = new ContactModel();

        contactModel.setId(contact.getId());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());

        return contactModel;
    }

}

package com.udemy.controller;

import com.querydsl.core.annotations.QueryInit;
import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jorge on 3/1/17.
 */

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel(){
        return ViewConstant.CONTACTS;
    }

    @GetMapping("/contactform")
    public String redirectContactForm(Model model){
        LOG.info("METHOD: redirectContactForm() -- " + ViewConstant.CONTACT_FORM);
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model){
        LOG.info("Call: addContact() -- PARAMS: " + contactModel.toString());

        if(contactService.addContact(contactModel) != null){
            model.addAttribute("result", 1);
        }
        else{
            model.addAttribute("result", 0);
        }
        return ViewConstant.CONTACTS;
    }

}

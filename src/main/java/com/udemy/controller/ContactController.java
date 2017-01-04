package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jorge on 3/1/17.
 */

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/contactform")
    private String redirectContactForm(){
        LOG.info("METHOD: redirectContactForm() -- " + ViewConstant.CONTACT_FORM);
        return ViewConstant.CONTACT_FORM;
    }

}

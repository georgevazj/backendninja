package com.udemy.controller;

import com.udemy.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jorge on 9/01/17.
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest(){
        ContactModel contactModel = new ContactModel(6, "Siso", "Rocha", "666666", "Madrid");
        return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
    }
}

package com.udemy.controller;

import com.udemy.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

/**
 * Created by Jorge on 2/1/17.
 */

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

    private static final String FORM_VIEW="form";
    private static final String RESULT_VIEW="result";

    //Primera forma de redireccion
    /*@GetMapping("/")
    public String redirect(){
        return "redirect:/example3/showForm";
    }*/

    //Segunda forma de redireccion
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showForm");
    }

    @GetMapping("/showform")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(FORM_VIEW);
        }else{
            mav.setViewName(RESULT_VIEW);
            mav.addObject("person", person);
        }
        return mav;
    }
}

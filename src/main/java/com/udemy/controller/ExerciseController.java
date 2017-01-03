package com.udemy.controller;

import com.udemy.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Jorge on 2/1/17.
 */

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    @Qualifier("exerciseService")
    private ExerciseService exerciseService;

    private static final Log LOG = LogFactory.getLog(ExerciseController.class);

    private String TEMPLATE="exercise";

    @GetMapping("/")
    public RedirectView toShow(){
        return new RedirectView("/exercise/show");
    }

    @GetMapping("/route")
    public RedirectView redirect(){
        return new RedirectView("/exercise/show");
    }

    @GetMapping("/show")
    public ModelAndView showMessage(){
        ModelAndView mav = new ModelAndView(TEMPLATE);
        String mensaje = exerciseService.getMessage();
        mav.addObject("mensaje", mensaje);
        return mav;
    }

}

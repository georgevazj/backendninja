package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 2/1/17.
 */

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW="example";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    //Primera forma: Se suele usar para redirecciones
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        exampleComponent.sayHello();
        model.addAttribute("people", exampleService.getListPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda forma: Util para insertar datos en las plantillas
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people", exampleService.getListPeople());
        return mav;
    }

}

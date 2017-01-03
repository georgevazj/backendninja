package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jorge on 2/1/17.
 */

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    private static final String EXAMPLE2_VIEW = "example2";

    //localhost:8080/example2/request1?nm=John
    //localhost:8080/example2/request1?nm=Michael
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm", defaultValue = "NULL") String name){
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;

    }

    //localhost:8080/example2/request2/John
    //localhost:8080/example2/request2/Michael
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm") String name){
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }


}

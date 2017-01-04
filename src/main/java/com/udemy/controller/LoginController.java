package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jorge on 3/1/17.
 */

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin(){
        LOG.info("METHOD: redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error",required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout){
        LOG.info("METHOD: showLoginForm() -- PARAMS: error = " + error + ", logout=" + logout);
        model.addAttribute("userCredentials", new UserCredential());
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        LOG.info("Heading to login view...");
        return ViewConstant.LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials")UserCredential userCredential){
        LOG.info("METHOD: loginCheck() -- PARAMS: userCredential = " + userCredential.toString());
        if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
            LOG.info("Login succeeded! Heading to contacts view...");
            return "redirect:/contacts/showcontacts";
        }
        LOG.info("Redierct to login?error");
        return "redirect:/login?error";
    }

}

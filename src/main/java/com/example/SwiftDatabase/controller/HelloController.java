package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Login;
import com.example.SwiftDatabase.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class HelloController {

    @Autowired
    LoginRepo lr;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/Home")
    public ModelAndView home(@RequestParam("username") String username, @RequestParam("password") String password) {
        ArrayList<Login> all = new ArrayList<>(lr.findAll());
        boolean pass = false;

        for(int i = 0; i<all.size(); i++){
            if(all.get(i).getUsername().equals(username) && all.get(i).getPassword().equals(password)){
                pass = true;
            }
        }

        ModelAndView mav = null;
        if(pass){
            mav = new ModelAndView("home");
        } else {
            mav = new ModelAndView("login");
        }
        return mav;
    }


}
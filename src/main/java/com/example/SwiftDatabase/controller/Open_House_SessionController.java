package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Open_House_Session;
import com.example.SwiftDatabase.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class Open_House_SessionController {
    
    @Autowired
    Open_House_SessionRepo ohsr;
    @Autowired
    PropertyRepo pr;

    @RequestMapping("/Open_House_SessionData")
    public ModelAndView open_house_sessionPage(){
        ArrayList<Open_House_Session> all = new ArrayList<>();
        ohsr.findAll().forEach(all::add);
        ArrayList<Open_House_Session> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Open_House_Session> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("open_house_session");
        mav.addObject("propertyRepo", pr);
        mav.addObject("open_house_sessionList", pass);
        return mav;
    }

    @RequestMapping("/Open_House_SessionEdit/{id}")
    public ModelAndView open_house_sessionEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("open_house_sessionedit");
        mav.addObject("propertyRepo", pr);
        mav.addObject("Open_House_SessionRepo", ohsr);
        mav.addObject("Open_House_ID", id);
        return mav;
    }

    @RequestMapping("/Open_House_SessionEdited")
    public String open_house_sessionEdited(@RequestParam("id") String id, @RequestParam("ohdate") String ohdate, @RequestParam("street") String street){
        Open_House_Session ohse = ohsr.findById(id).get();
        ohse.setDate_Of_Open_House(ohdate);
        ohse.setProperty_ID(street);
        ohsr.save(ohse);

        return "redirect:/Open_House_SessionData";
    }

    @RequestMapping("/Open_House_SessionDelete/{id}")
    public String open_house_sessionDelete(@PathVariable("id") String id){
        Open_House_Session ohse = ohsr.findById(id).get();
        ohse.setIsdelete(true);
        ohsr.save(ohse);

        return "redirect:/Open_House_SessionData";
    }

    @RequestMapping("/Open_House_SessionRedirect")
    public ModelAndView open_house_sessionRedirect(){
        ModelAndView mav = new ModelAndView("open_house_sessionnew");
        mav.addObject("propertyRepo", pr);
        return mav;
    }

    @RequestMapping("/Open_House_SessionNew")
    public String open_house_sessionNew(@RequestParam("ohdate") String ohdate, @RequestParam("street") String street){
        Open_House_Session ohse = new Open_House_Session();
        UUID uuid = UUID.randomUUID();
        ohse.setOpen_House_ID(String.valueOf(uuid));
        ohse.setDate_Of_Open_House(ohdate);
        ohse.setProperty_ID(street);
        ohse.setIsdelete(false);
        ohsr.save(ohse);

        return "redirect:/Open_House_SessionData";
    }

    @RequestMapping("/Open_House_SessionFilter")
    public ModelAndView open_house_sessionPageFilter(@RequestParam("ohdate") String ohdate, @RequestParam("street") String street){
        ArrayList<Open_House_Session> all = new ArrayList<>();
        ohsr.findAll().forEach(all::add);
        ArrayList<Open_House_Session> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!ohdate.equals("")) {
            ArrayList<Open_House_Session> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDate_Of_Open_House().equals(ohdate)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!street.equals("")) {
            ArrayList<Open_House_Session> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getProperty_ID().equals(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        Iterator<Open_House_Session> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("open_house_session");
        mav.addObject("propertyRepo", pr);
        mav.addObject("open_house_sessionList", pass);
        return mav;
    }



}

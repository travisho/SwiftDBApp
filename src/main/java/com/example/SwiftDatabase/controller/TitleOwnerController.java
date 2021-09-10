package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.*;
import com.example.SwiftDatabase.repository.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
@Controller
public class TitleOwnerController {
    @Autowired
    PropertyRepo pr;
    @Autowired
    Title_OwnerRepo tor;

    @RequestMapping("/Title_OwnerData")
    public ModelAndView titleownerPage() {
        ArrayList<Title_Owner> all = new ArrayList<>();
        tor.findAll().forEach(all::add);
        ArrayList<Title_Owner> fill = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        Iterator<Title_Owner> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("title_owner");

        mav.addObject("propertyRepo", pr);
        mav.addObject("titleownerList", pass);
        return mav;
    }
    @RequestMapping("/TitleOwnerEdit/{id}")
    public ModelAndView titleownerEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("title_owneredit");
        mav.addObject("propertyRepo", pr);
        mav.addObject("Title_OwnerRepo", tor);
        mav.addObject("Title_OwnerID", id);
        return mav;
    }
    @RequestMapping("/TitleOwnerEdited")
    public String titleownerEdited(@RequestParam("id") String id, @RequestParam("title_owner") String title){
        Title_Owner t =tor.findById(id).get();
        t.setTitle_Owner(title);
        tor.save(t);

        return "redirect:/Title_OwnerData";
    }
    @RequestMapping("/TitleOwnerDelete/{id}")
    public String titleownerDelete(@PathVariable("id") String id){
        Title_Owner t = tor.findById(id).get();
        t.setIsdelete(true);
        tor.save(t);

        return "redirect:/Title_OwnerData";
    }
    @RequestMapping("/TitleOwnerRedirect")
    public ModelAndView titleownerRedirect(){
        ModelAndView mav = new ModelAndView("title_ownernew");
        mav.addObject("propertyRepo", pr);
        return mav;
    }

    @RequestMapping("/TitleOwnerNew")
    public String titleownerNew( @RequestParam("street") String street, @RequestParam("title_owner") String title ){
        Title_Owner t = new Title_Owner();
        UUID uuid = UUID.randomUUID();
        t.setTitle_Owner_ID(String.valueOf(uuid));
        t.setProperty_ID(street);
        t.setTitle_Owner(title);
        t.setIsdelete(false);
        tor.save(t);

        return "redirect:/Title_OwnerData";
    }
    @RequestMapping("/TitleOwnerFilter")
    public ModelAndView topfeatureFilter(@RequestParam("title_owner") String title){
        ArrayList<Title_Owner> all = new ArrayList<>();
        tor.findAll().forEach(all::add);
        ArrayList<Title_Owner> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!title.equals("")) {
            ArrayList<Title_Owner> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getTitle_Owner().contains(title)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Title_Owner> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("title_owner");
        mav.addObject("propertyRepo", pr);
        mav.addObject("titleownerList", pass);
        return mav;
    }
}

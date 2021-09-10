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
import java.util.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class PropertyRemodelController {

    @Autowired
    Property_RemodelRepo ubr;
    @Autowired
    PropertyRepo pfr;


    @RequestMapping("/Property_RemodelData")
    public ModelAndView PropertyRemodelPage(){
        ArrayList<Property_Remodel> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Property_Remodel> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Property_Remodel> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("PropertyRemodel");
        mav.addObject("PropertyRepo", pfr);
        mav.addObject("PropertyRemodelList", pass);
        return mav;
    }

    @RequestMapping("/PropertyRemodelEdit/{id}")
    public ModelAndView PropertyRemodelEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("PropertyRemodelEdit");
        mav.addObject("PropertyRepo", pfr);
        mav.addObject("PropertyRemodelRepo", ubr);
        mav.addObject("PropertyRemodelList", ubr);
        mav.addObject("PropertyRemodelID", id);
        return mav;
    }

    @RequestMapping("/PropertyRemodelEdited")
    public String PropertyRemodelEdited(@RequestParam("id") String id, @RequestParam("Date_of_Remodel") String Date_of_Remodel){
        Property_Remodel ae = ubr.findById(id).get();
        ae.setDate_of_Remodel(Date_of_Remodel);
        ubr.save(ae);

        return "redirect:/Property_RemodelData";
    }

    @RequestMapping("/PropertyRemodelDelete/{id}")
    public String PropertyRemodelDelete(@PathVariable("id") String id){
        Property_Remodel ae = ubr.findById(id).get();
        ae.setIsdelete(true);
        ubr.save(ae);

        return "redirect:/Property_RemodelData";
    }

    @RequestMapping("/PropertyRemodelRedirect")
    public ModelAndView PropertyRemodelRedirect(){
        ModelAndView mav = new ModelAndView("PropertyRemodelNew");
        mav.addObject("PropertyRepo", pfr);
        mav.addObject("PropertyRemodelRepo", ubr);
        return mav;
    }

    @RequestMapping("/PropertyRemodelNew")
    public String PropertyRemodelNew(@RequestParam("Date_Of_Remodel") String Date_Of_Remodel, @RequestParam("Property") String Property){
        Property_Remodel ae = new Property_Remodel();
        UUID uuid = UUID.randomUUID();
        ae.setRemodel_ID(String.valueOf(uuid));
        ae.setProperty_ID(Property);

        String month = null;
        String day = null;
        if(!String.valueOf(Date_Of_Remodel.charAt(5)).equals("0")) {
            month = String.valueOf(Date_Of_Remodel.charAt(5)) + String.valueOf(Date_Of_Remodel.charAt(6));
        } else {
            month = String.valueOf(Date_Of_Remodel.charAt(6));
        }
        if(!String.valueOf(Date_Of_Remodel.charAt(8)).equals("0")) {
            day = String.valueOf(Date_Of_Remodel.charAt(8))+ String.valueOf(Date_Of_Remodel.charAt(9));
        } else {
            day = String.valueOf(Date_Of_Remodel.charAt(9));
        }
        String year = String.valueOf(Date_Of_Remodel.charAt(0)) +String.valueOf(Date_Of_Remodel.charAt(1)) +String.valueOf(Date_Of_Remodel.charAt(2)) +String.valueOf(Date_Of_Remodel.charAt(3));
        String date = month + "/" + day + "/" + year;

        ae.setDate_of_Remodel(date);
        ae.setIsdelete(false);
        ubr.save(ae);

        return "redirect:/Property_RemodelData";
    }

    @RequestMapping("/PropertyRemodelFilter")
    public ModelAndView PropertyRemodelFilter(@RequestParam("Date of Remodel") String date_of_remodel){
        ArrayList<Property_Remodel> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Property_Remodel> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!((date_of_remodel).equals(""))){
            ArrayList<Property_Remodel> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDate_of_Remodel().contains(date_of_remodel)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }



        Iterator<Property_Remodel> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("PropertyRemodel");
        mav.addObject("PropertyRepo", pfr);
        mav.addObject("PropertyRemodelList", pass);
        return mav;
    }



}


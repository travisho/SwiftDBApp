package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.*;
import com.example.SwiftDatabase.repository.*;
import org.apache.jasper.tagplugins.jstl.core.Out;
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
public class OutdoorController {

    @Autowired
    OutdoorRepo ubr;
    @Autowired
    Floor_PlanRepo pfr;
    @Autowired
    PropertyRepo pr;


    @RequestMapping("/OutdoorData")
    public ModelAndView OutdoorPage(){
        ArrayList<Outdoor> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Outdoor> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Outdoor> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Outdoor");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("OutdoorList", pass);
        return mav;
    }

    @RequestMapping("/OutdoorEdit/{id}")
    public ModelAndView OutdoorEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("OutdoorEdit");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("OutdoorRepo", ubr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("OutdoorList", ubr);
        mav.addObject("OutdoorID", id);
        return mav;
    }

    @RequestMapping("/OutdoorEdited")
    public String OutdoorEdited(@RequestParam("id") String id, @RequestParam("Patio Size Area") int patio_size_area, @RequestParam("Sprinkler System") String sprinkler_system){
        Outdoor ae = ubr.findById(id).get();
        ae.setPatio_Size_Area(patio_size_area);
        ae.setSprinkler_System(sprinkler_system);
        ubr.save(ae);

        return "redirect:/OutdoorData";
    }

    @RequestMapping("/OutdoorDelete/{id}")
    public String OutdoorDelete(@PathVariable("id") String id){
        Outdoor ae = ubr.findById(id).get();
        ae.setIsdelete(true);
        ubr.save(ae);

        return "redirect:/OutdoorData";
    }

    @RequestMapping("/OutdoorRedirect")
    public ModelAndView OutdoorRedirect(){
        ModelAndView mav = new ModelAndView("OutdoorNew");
        mav.addObject("OutdoorRepo", ubr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", pfr);
        return mav;
    }

    @RequestMapping("/OutdoorNew")
    public String OutdoorNew(@RequestParam("Patio_Size_Area") int Patio_Size_Area, @RequestParam("Sprinkler_System") String Sprinkler_System,@RequestParam("Property") String Property){
        Outdoor ae = new Outdoor();
        UUID uuid = UUID.randomUUID();
        ae.setOutdoor_ID(String.valueOf(uuid));
        ae.setFloor_Plan_ID(Property);
        ae.setPatio_Size_Area(Patio_Size_Area);
        ae.setSprinkler_System(Sprinkler_System);
        ae.setIsdelete(false);
        ubr.save(ae);

        return "redirect:/OutdoorData";
    }

    @RequestMapping("/OutdoorFilter")
    public ModelAndView OutdoorPageFilter(@RequestParam("Patio Size Area") int patio_size_area, @RequestParam("Sprinkler System") String sprinkler_system){
        ArrayList<Outdoor> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Outdoor> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!(String.valueOf(patio_size_area).equals(""))) {
            ArrayList<Outdoor> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getPatio_Size_Area() == (patio_size_area)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!(String.valueOf(sprinkler_system).equals(""))) {
            ArrayList<Outdoor> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(!(String.valueOf(sprinkler_system).equals(""))){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }



        Iterator<Outdoor> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("Outdoor");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("OutdoorList", pass);
        return mav;
    }



}


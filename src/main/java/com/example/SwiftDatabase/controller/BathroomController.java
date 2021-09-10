package com.example.SwiftDatabase.controller;
//first add the package to con

import com.example.SwiftDatabase.model.Air_Conditioning_Unit;
import com.example.SwiftDatabase.model.Bathroom;
import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Bathroom;
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
public class BathroomController {

    @Autowired
    BathroomRepo br;
    @Autowired
    Floor_PlanRepo fpr;
    @Autowired
    PropertyRepo pr;


    @RequestMapping("/BathroomData")
    public ModelAndView BathroomPage(){
        ArrayList<Bathroom> all = new ArrayList<>();
        br.findAll().forEach(all::add);
        ArrayList<Bathroom> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Bathroom> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Bathroom");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("BathroomRepo", br);
        mav.addObject("BathroomList", pass);
        return mav;
    }

    @RequestMapping("/BathroomEdit/{id}")
    public ModelAndView BathroomEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Bathroomedit");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("BathroomList", br.findAll());
        mav.addObject("Bathroom_ID", id);
        return mav;
    }

    @RequestMapping("/BathroomEdited")
    public String BathroomEdited(@RequestParam("id") String id,@RequestParam("floorplan") String floorplan, @RequestParam("Bathtub_Width") Integer Bathtub_Width, @RequestParam("Bathtub_Length") Integer Bathtub_Length, @RequestParam("Bathroom_Width") Integer Bathroom_Width, @RequestParam("Bathroom_Length") Integer Bathroom_Length){
        Bathroom be = br.findById(id).get();
        be.setFloor_Plan_ID(floorplan);
        be.setBathtub_Width(Bathtub_Width);
        be.setBathtub_Length(Bathtub_Length);
        be.setBathroom_Width(Bathroom_Width);
        be.setBathroom_Length(Bathroom_Length);
        br.save(be);

        return "redirect:/BathroomData";
    }

    @RequestMapping("/BathroomDelete/{id}")
    public String BathroomDelete(@PathVariable("id") String id){
        Bathroom be = br.findById(id).get();
        be.setIsdelete(true);
        br.save(be);

        return "redirect:/BathroomData";
    }

    @RequestMapping("/BathroomRedirect")
    public ModelAndView BathroomRedirect(){
        ModelAndView mav = new ModelAndView("BathroomNew");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("BathroomRepo", br);
        return mav;
    }

    @RequestMapping("/BathroomNew")
    public String BathroomNew(@RequestParam("floorplan") String floorplan,@RequestParam("Bathtub_Width") Integer Bathtub_Width, @RequestParam("Bathtub_Length") Integer Bathtub_Length, @RequestParam("Bathroom_Width") Integer Bathroom_Width, @RequestParam("Bathroom_Length") Integer Bathroom_Length){
        Bathroom be = new Bathroom();
        UUID uuid = UUID.randomUUID();
        be.setBathroom_ID(String.valueOf(uuid));
        be.setFloor_Plan_ID(floorplan);
        be.setBathtub_Width(Bathtub_Width);
        be.setBathtub_Length(Bathtub_Length);
        be.setBathroom_Width(Bathroom_Width);
        be.setBathroom_Length(Bathroom_Length);
        be.setIsdelete(false);
        br.save(be);

        return "redirect:/BathroomData";
    }

    @RequestMapping("/BathroomFilter")
    public ModelAndView BathroomPageFilter(@RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("Bathtub_Width") String Bathtub_Width, @RequestParam("Bathtub_Length") String Bathtub_Length, @RequestParam("Bathroom_Width") String Bathroom_Width, @RequestParam("Bathroom_Length") String Bathroom_Length){
        ArrayList<Bathroom> all = new ArrayList<>();
        br.findAll().forEach(all::add);
        ArrayList<Bathroom> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }


        if(!Bathtub_Width.equals("")) {
            ArrayList<Bathroom> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getBathtub_Width() ==Double.parseDouble(Bathtub_Width)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Bathtub_Length.equals("")){
            ArrayList<Bathroom> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getBathtub_Length() ==Double.parseDouble(Bathtub_Length)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Bathroom_Width.equals("")) {
            ArrayList<Bathroom> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getBathroom_Width() ==Double.parseDouble(Bathroom_Width)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Bathroom_Length.equals("")) {
            ArrayList<Bathroom> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getBathroom_Length() ==Double.parseDouble(Bathroom_Length)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Floor_Plan.equals("")) {
            ArrayList<Bathroom> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String FloorPlan = "Floor "+fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getFloor_Number()+" at "+pr.findById(fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getProperty_ID()).get().getStreet_Address();
                if(FloorPlan.contains(Floor_Plan)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Bathroom> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("Bathroom");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("BathroomList", pass);
        return mav;
    }



}


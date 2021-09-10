package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Air_Conditioning_Unit;
import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Heating_Unit;
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
public class Heating_UnitController {

    @Autowired
    Heating_UnitRepo hur;
    @Autowired
    Floor_PlanRepo fpr;
    @Autowired
    PropertyRepo pr;

    @RequestMapping("/Heating_UnitData")
    public ModelAndView Heating_UnitPage() {
        ArrayList<Heating_Unit> all = new ArrayList<>();
        hur.findAll().forEach(all::add);
        ArrayList<Heating_Unit> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        Iterator<Heating_Unit> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Heating_Unit");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("Heating_UnitRepo", hur);
        mav.addObject("Heating_UnitList", pass);
        return mav;
    }

    @RequestMapping("/Heating_UnitEdit/{id}")
    public ModelAndView Heating_UnitEdit(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("Heating_UnitEdit");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Heating_UnitList", hur.findAll());
        mav.addObject("Heating_Unit_ID", id);
        return mav;
    }

    @RequestMapping("/Heating_UnitEdited")
    public String Heating_UnitEdited(@RequestParam("id") String id, @RequestParam("floorplan") String floorplan,@RequestParam("Heating_Unit_Type") String Heating_Unit_Type, @RequestParam("Heating_Unit_Age_Years") String Heating_Unit_Age_Years) {
        Heating_Unit hue = hur.findById(id).get();
        hue.setFloor_Plan_ID(floorplan);
        hue.setHeating_Unit_Type(Heating_Unit_Type);
        hue.setHeating_Unit_Age_Years(Integer.parseInt(Heating_Unit_Age_Years));
        hur.save(hue);
        return "redirect:/Heating_UnitData";
    }

    @RequestMapping("/Heating_UnitDelete/{id}")
    public String Heating_UnitDelete(@PathVariable("id") String id) {
        Heating_Unit hue = hur.findById(id).get();
        hue.setIsdelete(true);
        hur.save(hue);

        return "redirect:/Heating_UnitData";
    }

    @RequestMapping("/Heating_UnitRedirect")
    public ModelAndView Heating_UnitRedirect() {
        ModelAndView mav = new ModelAndView("Heating_UnitNew");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("Heating_UnitRepo", hur);
        mav.addObject("PropertyRepo", pr);
        return mav;
    }

    @RequestMapping("/Heating_UnitNew")
    public String Heating_UnitNew(@RequestParam("floorplan") String floorplan, @RequestParam("Heating_Unit_Type") String Heating_Unit_Type, @RequestParam("Heating_Unit_Age_Years") String Heating_Unit_Age_Years) {
        Heating_Unit hue = new Heating_Unit();
        UUID uuid = UUID.randomUUID();
        hue.setHeating_Unit_ID(String.valueOf(uuid));
        hue.setFloor_Plan_ID(floorplan);
        hue.setHeating_Unit_Type(Heating_Unit_Type);
        hue.setHeating_Unit_Age_Years(Integer.parseInt(Heating_Unit_Age_Years));
        hue.setIsdelete(false);
        hur.save(hue);
        return "redirect:/Heating_UnitData";
    }

    @RequestMapping("/Heating_UnitFilter")
    public ModelAndView Heating_UnitPageFilter(@RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("Heating_Unit_Type") String Heating_Unit_Type, @RequestParam("Heating_Unit_Age_Years") String Heating_Unit_Age_Year) {
        ArrayList<Heating_Unit> all = new ArrayList<>();
        hur.findAll().forEach(all::add);
        ArrayList<Heating_Unit> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }

        if(!Floor_Plan.equals("")) {
            ArrayList<Heating_Unit> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String FloorPlan = "Floor "+fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getFloor_Number()+" at "+pr.findById(fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getProperty_ID()).get().getStreet_Address();
                if(FloorPlan.contains(Floor_Plan)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        if (!Heating_Unit_Type.equals("")) {
            ArrayList<Heating_Unit> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getHeating_Unit_Type().equals(Heating_Unit_Type)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if (!Heating_Unit_Age_Year.equals("")) {
            ArrayList<Heating_Unit> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getHeating_Unit_Age_Years() == Integer.parseInt(Heating_Unit_Age_Year)) {
                    temp.add(fill.get(i));
                }
            }

            fill = temp;
        }

        Iterator<Heating_Unit> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("Heating_Unit");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("Heating_UnitList", pass);
        return mav;
    }
}

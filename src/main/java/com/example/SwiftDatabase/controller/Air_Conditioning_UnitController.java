package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Air_Conditioning_Unit;
import com.example.SwiftDatabase.repository.Air_Conditioning_UnitRepo;
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
public class Air_Conditioning_UnitController {

    @Autowired
    Air_Conditioning_UnitRepo acur;
    @Autowired
    Floor_PlanRepo fpr;
    @Autowired
    PropertyRepo pr;



    @RequestMapping("/AC_UnitData")
    public ModelAndView Air_Conditioning_UnitPage(){
        ArrayList<Air_Conditioning_Unit> all = new ArrayList<>();
        acur.findAll().forEach(all::add);
        ArrayList<Air_Conditioning_Unit> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Air_Conditioning_Unit> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Air_Conditioning_Unit");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("Air_Conditioning_UnitRepo", acur);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Air_Conditioning_UnitList", pass);
        return mav;
    }

    @RequestMapping("/Air_Conditioning_UnitEdit/{id}")
    public ModelAndView Air_Conditioning_UnitEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Air_Conditioning_UnitEdit");
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Air_Conditioning_UnitList", acur.findAll());
        mav.addObject("ACU_ID", id);
        return mav;
    }

    @RequestMapping("/Air_Conditioning_UnitEdited")
    public String Air_Conditioning_UnitEdited(@RequestParam("id") String id, @RequestParam("floorplan") String floorplan, @RequestParam("ACU_Type") String ACU_Type,@RequestParam("ACU_Age_Years") String ACU_Age_Years) {
        Air_Conditioning_Unit ace = acur.findById(id).get();
        ace.setFloor_Plan_ID(floorplan);
        ace.setACU_Age_Years(Double.parseDouble(ACU_Age_Years));
        ace.setACU_Type(ACU_Type);
        acur.save(ace);

        return "redirect:/AC_UnitData";
    }

    @RequestMapping("/Air_Conditioning_UnitDelete/{id}")
    public String Air_Conditioning_UnitDelete(@PathVariable("id") String id){
        Air_Conditioning_Unit ace = acur.findById(id).get();
        ace.setIsdelete(true);
        acur.save(ace);

        return "redirect:/AC_UnitData";
    }

    @RequestMapping("/Air_Conditioning_UnitRedirect")
    public ModelAndView Air_Conditioning_UnitRedirect(){
        ModelAndView mav = new ModelAndView("Air_Conditioning_UnitNew");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        return mav;
    }

    @RequestMapping("/Air_Conditioning_UnitNew")
    public String Air_Conditioning_UnitNew(@RequestParam("floorplan") String floorplan, @RequestParam("ACU_Age_Years") String ACU_Age_Years, @RequestParam("ACU_Type") String ACU_Type){
        Air_Conditioning_Unit ace = new Air_Conditioning_Unit();
        UUID uuid = UUID.randomUUID();
        ace.setACU_ID(String.valueOf(uuid));
        ace.setFloor_Plan_ID(floorplan);
        ace.setACU_Age_Years(Double.parseDouble(ACU_Age_Years));
        ace.setACU_Type(ACU_Type);
        ace.setIsdelete(false);
        acur.save(ace);

        return "redirect:/AC_UnitData";
    }

    @RequestMapping("/Air_Conditioning_UnitFilter")
    public ModelAndView Air_Conditioning_UnitPageFilter(@RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("ACU_Age_Years") String ACU_Age_Years, @RequestParam("ACU_Type") String ACU_Type){
        ArrayList<Air_Conditioning_Unit> all = new ArrayList<>();
        acur.findAll().forEach(all::add);
        ArrayList<Air_Conditioning_Unit> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }


        if(!ACU_Age_Years.equals("")) {
            ArrayList<Air_Conditioning_Unit> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getACU_Age_Years()==Double.parseDouble(ACU_Age_Years)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!ACU_Type.equals("")) {
            ArrayList<Air_Conditioning_Unit> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getACU_Type().equals(ACU_Type)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Floor_Plan.equals("")) {
            ArrayList<Air_Conditioning_Unit> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String FloorPlan = "Floor "+fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getFloor_Number()+" at "+pr.findById(fpr.findById(fill.get(i).getFloor_Plan_ID()).get().getProperty_ID()).get().getStreet_Address();
                if(FloorPlan.contains(Floor_Plan)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Air_Conditioning_Unit> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("Air_Conditioning_Unit");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Floor_PlanRepo", fpr);
        mav.addObject("Air_Conditioning_UnitList", pass);
        return mav;
    }





}

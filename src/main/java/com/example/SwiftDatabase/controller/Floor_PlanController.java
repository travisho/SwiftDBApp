package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Floor_Plan;
import com.example.SwiftDatabase.model.Utility_Bill;
import com.example.SwiftDatabase.repository.Floor_PlanRepo;
import com.example.SwiftDatabase.repository.PropertyRepo;
import com.example.SwiftDatabase.repository.Property_FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class Floor_PlanController {
    @Autowired
    Floor_PlanRepo ar;
    @Autowired
    PropertyRepo pr;



    @RequestMapping("/Floor_PlanData")
    public ModelAndView Floor_PlanPage(){
        ArrayList<Floor_Plan> all = new ArrayList<>();
        ar.findAll().forEach(all::add);
        ArrayList<Floor_Plan> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Floor_Plan> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Floor_Plan");
        mav.addObject("PropertyRepo",pr);

        mav.addObject("Floor_PlanList", pass);
        return mav;
    }

    @RequestMapping("/Floor_PlanEdit/{id}")
    public ModelAndView Floor_PlanEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Floor_Planedit");
        mav.addObject("Floor_PlanRepo",ar);
        mav.addObject("PropertyRepo",pr);
        mav.addObject("Floor_PlanList",ar);

        mav.addObject("Floor_Plan_ID", id);
        return mav;
    }

    @RequestMapping("/Floor_PlanEdited")
    public String Floor_PlanEdited(@RequestParam("id") String id, @RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("Floor_Number") int Floor_Number,@RequestParam("Property") String Property){
        Floor_Plan ae = ar.findById(id).get();
        ae.setFloor_Plan(Floor_Plan);
        ae.setProperty_ID(Property);
        ae.setFloor_Number(Floor_Number);
        ar.save(ae);

        return "redirect:/Floor_PlanData";
    }

    @RequestMapping("/Floor_PlanDelete/{id}")
    public String Floor_PlanDelete(@PathVariable("id") String id){
        Floor_Plan ae = ar.findById(id).get();
        ae.setIsdelete(true);
        ar.save(ae);

        return "redirect:/Floor_PlanData";
    }

    @RequestMapping("/Floor_PlanRedirect")
    public ModelAndView Floor_PlanRedirect(){
        ModelAndView mav = new ModelAndView("Floor_Plannew");

        mav.addObject("PropertyRepo",pr);
        return mav;
    }

    @RequestMapping("/Floor_PlanNew")
    public String Floor_PlanNew(@RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("Floor_Number") int Floor_Number,@RequestParam("Property") String Property){
        Floor_Plan ae = new Floor_Plan();
        UUID uuid = UUID.randomUUID();
        ae.setFloor_Plan_ID(String.valueOf(uuid));
        ae.setProperty_ID(Property);
        ae.setFloor_Plan(Floor_Plan);
        ae.setFloor_Number(Floor_Number);
        ae.setIsdelete(false);
        ar.save(ae);

        return "redirect:/Floor_PlanData";
    }

    @RequestMapping("/Floor_PlanFilter")
    public ModelAndView Floor_PlanPageFilter(@RequestParam("Floor_Plan") String Floor_Plan, @RequestParam("Floor_Number") String Floor_Number,@RequestParam("street") String street){
        ArrayList<Floor_Plan> all = new ArrayList<>();
        ar.findAll().forEach(all::add);
        ArrayList<Floor_Plan> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!Floor_Plan.equals("")) {
            ArrayList<Floor_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getFloor_Plan().contains(Floor_Plan)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!(String.valueOf(Floor_Number).equals(""))){
            ArrayList<Floor_Plan> temp = new ArrayList<>();
            for(int i = 0; i < fill.size(); i++) {
                if(fill.get(i).getFloor_Number()==Integer.parseInt(Floor_Number)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!(street).equals("")) {
            ArrayList<Floor_Plan> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(pr.findById(fill.get(i).getProperty_ID()).get().getStreet_Address().equals(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }



        Iterator<Floor_Plan> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Floor_Plan");
        mav.addObject("PropertyRepo",pr);

        mav.addObject("Floor_PlanList", pass);
        return mav;
    }
}



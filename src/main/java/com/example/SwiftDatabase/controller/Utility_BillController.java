package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Agent;
import com.example.SwiftDatabase.model.Property;
import com.example.SwiftDatabase.model.Room;
import com.example.SwiftDatabase.model.Utility_Bill;
import com.example.SwiftDatabase.repository.AgentRepo;
import com.example.SwiftDatabase.repository.PropertyRepo;
import com.example.SwiftDatabase.repository.Property_FinanceRepo;
import com.example.SwiftDatabase.repository.Utility_BillRepo;
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

public class Utility_BillController {
    @Autowired
    Utility_BillRepo ubr;
    @Autowired
    PropertyRepo pr;
    @Autowired
    Property_FinanceRepo pfr;

    @RequestMapping("/Utility_BillData")
    public ModelAndView Utility_BillPage(){
        ArrayList<Utility_Bill> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Utility_Bill> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Utility_Bill> pass = fill
                .listIterator();

        ModelAndView mav = new ModelAndView("Utility_Bill");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Property_FinanceRepo", pfr);
        mav.addObject("Utility_BillList", pass);
        return mav;
    }

    @RequestMapping("/Utility_BillEdit/{id}")
    public ModelAndView Utility_BillEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Utility_Billedit");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Property_FinanceRepo", pfr);
        mav.addObject("Utility_BillRepo",ubr);
        mav.addObject("UtilityList", ubr);
        mav.addObject("Utility_Bill_ID", id);
        return mav;
    }

    @RequestMapping("/Utility_BillEdited")
    public String Utility_BillEdited(@RequestParam("id") String id, @RequestParam("Utility") String Utility, @RequestParam("Cost_Of_Utility") String Cost_Of_Utility,@RequestParam("Property") String Property){
        Utility_Bill ae = ubr.findById(id).get();
        ae.setProperty_Finance_ID(Property);
        ae.setUtility(Utility);
        ae.setCost_Of_Utility(Cost_Of_Utility);
        ubr.save(ae);

        return "redirect:/Utility_BillData";
    }

    @RequestMapping("/Utility_BillDelete/{id}")
    public String Utility_BillDelete(@PathVariable("id") String id){
        Utility_Bill ae = ubr.findById(id).get();
        ae.setIsdelete(true);
        ubr.save(ae);

        return "redirect:/Utility_BillData";
    }

    @RequestMapping("/Utility_BillRedirect")
    public ModelAndView Utility_BillRedirect(){
        ModelAndView mav = new ModelAndView("Utility_Billnew");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Property_FinanceRepo", pfr);
        mav.addObject("Utility_BillRepo",ubr);
        return mav;

    }

    @RequestMapping("/Utility_BillNew")
    public String Utility_BillNew(@RequestParam("Utility") String Utility, @RequestParam("Cost_Of_Utility") String Cost_Of_Utility, @RequestParam("Property") String Property){
        Utility_Bill ae = new Utility_Bill();
        UUID uuid = UUID.randomUUID();
        ae.setUtility_Bill_ID(String.valueOf(uuid));
        ae.setProperty_Finance_ID(Property);
        ae.setUtility(Utility);
        ae.setCost_Of_Utility(Cost_Of_Utility);
        ae.setIsdelete(false);
        ubr.save(ae);

        return "redirect:/Utility_BillData";
    }

    @RequestMapping("/Utility_BillFilter")
    public ModelAndView Utility_BillPageFilter(@RequestParam("Utility") String Utility, @RequestParam("Cost_Of_Utility") String Cost_Of_Utility, @RequestParam("Street") String Street){
        ArrayList<Utility_Bill> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Utility_Bill> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!Utility.equals("")) {
            ArrayList<Utility_Bill> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getUtility().contains(Utility)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Cost_Of_Utility.equals("")) {
            ArrayList<Utility_Bill> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getCost_Of_Utility().equals(Cost_Of_Utility)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!Street.equals("")) {
            ArrayList<Utility_Bill> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(pr.findById(pfr.findById(fill.get(i).getProperty_Finance_ID()).get().getProperty_ID()).get().getStreet_Address().contains(Street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        Iterator<Utility_Bill> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Utility_Bill");
        mav.addObject("PropertyRepo", pr);
        mav.addObject("Property_FinanceRepo", pfr);
        mav.addObject("Utility_BillList", pass);
        return mav;
    }

}

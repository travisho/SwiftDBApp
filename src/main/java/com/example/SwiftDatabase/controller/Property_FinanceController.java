package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Property_Finance;
import com.example.SwiftDatabase.repository.PropertyRepo;
import com.example.SwiftDatabase.repository.Property_FinanceRepo;
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
public class Property_FinanceController {

    @Autowired
    Property_FinanceRepo pfr;
    @Autowired
    PropertyRepo pr;

    @RequestMapping("/Property_FinanceData")
    public ModelAndView propertyPage(){
        ArrayList<Property_Finance> all = new ArrayList<>();
        pfr.findAll().forEach(all::add);
        ArrayList<Property_Finance> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Property_Finance> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("property_finance");
        mav.addObject("propertyRepo", pr);
        mav.addObject("property_financeList", pass);
        return mav;
    }

    @RequestMapping("/Property_FinanceEdit/{id}")
    public ModelAndView property_financeEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("property_financeedit");
        mav.addObject("propertyRepo", pr);
        mav.addObject("property_financeRepo", pfr);
        mav.addObject("Property_Finance_ID", id);
        return mav;
    }

    @RequestMapping("/Property_FinanceEdited")
    public String property_financeEdited(@RequestParam("street") String street, @RequestParam("tax") String tax, @RequestParam("totalpe") String totalpe, @RequestParam("monthlype") String monthlype, @RequestParam("id") String id){
        Property_Finance pfe = pfr.findById(id).get();
        pfe.setProperty_ID(street);
        pfe.setProperty_Tax(Double.parseDouble(tax));
        pfe.setTotal_Price_Estimate(Double.parseDouble(totalpe));
        pfe.setMonthly_Price_Estimate(Double.parseDouble(monthlype));
        pfr.save(pfe);
        return "redirect:/Property_FinanceData";
    }

    @RequestMapping("/Property_FinanceDelete/{id}")
    public String property_financeDelete(@PathVariable("id") String id){
        Property_Finance pfe = pfr.findById(id).get();
        pfe.setIsdelete(true);
        pfr.save(pfe);

        return "redirect:/Property_FinanceData";
    }

    @RequestMapping("/Property_FinanceRedirect")
    public ModelAndView property_financeRedirect(){
        ModelAndView mav = new ModelAndView("property_financenew");
        mav.addObject("propertyRepo", pr);
        return mav;
    }

    @RequestMapping("/Property_FinanceNew")
    public String property_financeNew(@RequestParam("street") String street, @RequestParam("tax") String tax, @RequestParam("totalpe") String totalpe, @RequestParam("monthlype") String monthlype){
        Property_Finance pfe = new Property_Finance();
        UUID uuid = UUID.randomUUID();
        pfe.setProperty_Finance_ID(String.valueOf(uuid));
        pfe.setProperty_ID(street);
        pfe.setProperty_Tax(Double.parseDouble(tax));
        pfe.setTotal_Price_Estimate(Double.parseDouble(totalpe));
        pfe.setMonthly_Price_Estimate(Double.parseDouble(monthlype));
        pfe.setIsdelete(false);
        pfr.save(pfe);

        return "redirect:/Property_FinanceData";
    }

    @RequestMapping("Property_FinanceFilter")
    public ModelAndView property_financeFilter(@RequestParam("street") String street, @RequestParam("tax") String tax, @RequestParam("totalpe") String totalpe, @RequestParam("monthlype") String monthlype) {
        ArrayList<Property_Finance> all = new ArrayList<>();
        pfr.findAll().forEach(all::add);
        ArrayList<Property_Finance> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }

        if(!street.equals("")){
            ArrayList<Property_Finance> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(pr.findById(fill.get(i).getProperty_ID()).get().getStreet_Address().contains(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!tax.equals("")){
            ArrayList<Property_Finance> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getProperty_Tax() == Double.parseDouble(tax)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!totalpe.equals("")){
            ArrayList<Property_Finance> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getTotal_Price_Estimate() == Double.parseDouble(totalpe)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!monthlype.equals("")){
            ArrayList<Property_Finance> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getMonthly_Price_Estimate() == Double.parseDouble(monthlype)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Property_Finance> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("property_finance");
        mav.addObject("propertyRepo", pr);
        mav.addObject("property_financeList", pass);
        return mav;
    }
}

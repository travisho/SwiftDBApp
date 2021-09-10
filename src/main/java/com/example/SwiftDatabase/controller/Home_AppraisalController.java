package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Home_Appraisal;
import com.example.SwiftDatabase.model.Property_Finance;
import com.example.SwiftDatabase.repository.Home_AppraisalRepo;
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
public class Home_AppraisalController {

    @Autowired
    Home_AppraisalRepo har;
    @Autowired
    Property_FinanceRepo hr;
    @Autowired
    PropertyRepo pr;


    @RequestMapping("/Home_AppraisalData")
    public ModelAndView propertyPage(){
        ArrayList<Home_Appraisal> all = new ArrayList<>();
        har.findAll().forEach(all::add);
        ArrayList<Home_Appraisal> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Home_Appraisal> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Home_Appraisal");
        mav.addObject("property_FinanceRepo", hr);
        mav.addObject("propertyRepo", pr);
        mav.addObject("Home_AppraisalRepo", har);
        mav.addObject("Home_AppraisalList", pass);
        return mav;
    }

    @RequestMapping("/Home_AppraisalEdit/{id}")
    public ModelAndView Home_AppraisalEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Home_Appraisaledit");
        mav.addObject("property_FinanceRepo", hr);
        mav.addObject("propertyRepo", pr);

        mav.addObject("Home_AppraisalRepo", har);
        mav.addObject("Home_Appraisal_ID", id);
        return mav;
    }

    @RequestMapping("/Home_AppraisalEdited")
    public String Home_AppraisalEdited( @RequestParam("area") String area, @RequestParam("value") String value, @RequestParam("id") String id){
        Home_Appraisal hae = har.findById(id).get();
        hae.setProperty_Area(area);
        hae.setAppraisal_Value(Double.parseDouble(value));
        har.save(hae);
        return "redirect:/Home_AppraisalData";

    }

    @RequestMapping("/Home_AppraisalDelete/{id}")
    public String Home_AppraisalDelete(@PathVariable("id") String id){
        Home_Appraisal hae = har.findById(id).get();
        hae.setIsdelete(true);
        har.save(hae);

        return "redirect:/Home_AppraisalData";

    }

    @RequestMapping("/Home_AppraisalRedirect")
    public ModelAndView Home_AppraisalRedirect(){
        ModelAndView mav = new ModelAndView("Home_Appraisalnew");
       mav.addObject("propertyRepo", pr);
        mav.addObject("Home_AppraisalRepo", har);
        mav.addObject("property_FinanceRepo", hr);
       return mav;

    }

    @RequestMapping("/Home_AppraisalNew")
    public String Home_AppraisalNew(@RequestParam("street") String street, @RequestParam("area") String area, @RequestParam("value") String value){
        Home_Appraisal hae = new Home_Appraisal();
        UUID uuid = UUID.randomUUID();
        hae.setHome_Appraisal_ID(String.valueOf(uuid));
        hae.setProperty_Finance_ID(street);
        hae.setProperty_Area(area);
        hae.setAppraisal_Value(Double.parseDouble(value));
        hae.setIsdelete(false);
        har.save(hae);

        return "redirect:/Home_AppraisalData";
    }

    @RequestMapping("Home_AppraisalFilter")
    public ModelAndView Home_AppraisalFilter(@RequestParam("street") String street, @RequestParam("area") String area, @RequestParam("value") String value){
        ArrayList<Home_Appraisal> all = new ArrayList<>();
        har.findAll().forEach(all::add);
        ArrayList<Home_Appraisal> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }


        if(!value.equals("")){
            ArrayList<Home_Appraisal> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getAppraisal_Value() == Double.parseDouble(value)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!street.equals("")){
            ArrayList<Home_Appraisal> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(pr.findById(hr.findById(fill.get(i).getProperty_Finance_ID()).get().getProperty_ID()).get().getStreet_Address().contains(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!area.equals("")){
            ArrayList<Home_Appraisal> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getProperty_Area().equals(area)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        Iterator<Home_Appraisal> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Home_Appraisal");
        mav.addObject("property_FinanceRepo", hr);
        mav.addObject("propertyRepo", pr);
        mav.addObject("Home_AppraisalRepo", har);

        mav.addObject("Home_AppraisalList", pass);
        return mav;
    }
}

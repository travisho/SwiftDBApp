package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Property;
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
public class PropertyController {

    @Autowired
    PropertyRepo pr;
    @Autowired
    Home_BuilderRepo hbr;
    @Autowired
    Property_StyleRepo psr;
    @Autowired
    StateRepo sr;
    @Autowired
    CountryRepo cr;

    @RequestMapping("/PropertyData")
    public ModelAndView propertyPage(){
        ArrayList<Property> all = new ArrayList<>();
        pr.findAll().forEach(all::add);
        ArrayList<Property> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Property> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("property");
        mav.addObject("home_builderRepo", hbr);
        mav.addObject("property_styleRepo", psr);
        mav.addObject("stateRepo", sr);
        mav.addObject("countryRepo", cr);
        mav.addObject("propertyList", pass);
        return mav;
    }

    @RequestMapping("/PropertyEdit/{id}")
    public ModelAndView propertyEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("propertyedit");
        mav.addObject("home_builderRepo", hbr);
        mav.addObject("property_styleRepo", psr);
        mav.addObject("stateRepo", sr);
        mav.addObject("countryRepo", cr);
        mav.addObject("propertyRepo", pr);
        mav.addObject("PropertyID", id);
        return mav;
    }

    @RequestMapping("/PropertyEdited")
    public String propertyEdited(@RequestParam("id") String id, @RequestParam("builder") String builder, @RequestParam("style") String style, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip, @RequestParam("country") String country){
        Property pe = pr.findById(id).get();
        pe.setHome_Builder_ID(builder);
        pe.setProperty_Style_ID(style);
        pe.setStreet_Address(street);
        pe.setCity(city);
        pe.setState_ID(state);
        pe.setZip_Code(zip);
        pe.setCountry_ID(country);
        pr.save(pe);

        return "redirect:/PropertyData";
    }

    @RequestMapping("/PropertyDelete/{id}")
    public String propertyDelete(@PathVariable("id") String id){
        Property pe = pr.findById(id).get();
        pe.setIsdelete(true);
        pr.save(pe);

        return "redirect:/PropertyData";
    }

    @RequestMapping("/PropertyRedirect")
    public ModelAndView propertyRedirect(){
        ModelAndView mav = new ModelAndView("propertynew");
        mav.addObject("home_builderRepo", hbr);
        mav.addObject("property_styleRepo", psr);
        mav.addObject("stateRepo", sr);
        mav.addObject("countryRepo", cr);
        return mav;
    }

    @RequestMapping("/PropertyNew")
    public String agentNew(@RequestParam("builder") String builder, @RequestParam("style") String style, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip, @RequestParam("country") String country){
        Property pe = new Property();
        UUID uuid = UUID.randomUUID();
        pe.setProperty_ID(String.valueOf(uuid));
        pe.setHome_Builder_ID(builder);
        pe.setProperty_Style_ID(style);
        pe.setStreet_Address(street);
        pe.setCity(city);
        pe.setState_ID(state);
        pe.setZip_Code(zip);
        pe.setCountry_ID(country);
        pe.setIsdelete(false);
        pr.save(pe);

        return "redirect:/PropertyData";
    }

    @RequestMapping("/PropertyFilter")
    public ModelAndView propertyPageFilter(@RequestParam("builder") String builder, @RequestParam("style") String style, @RequestParam("street") String street, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zip") String zip, @RequestParam("country") String country){
        ArrayList<Property> all = new ArrayList<>();
        pr.findAll().forEach(all::add);
        ArrayList<Property> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!builder.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getHome_Builder_ID().contains(builder)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!style.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getProperty_Style_ID().contains(style)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!street.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getStreet_Address().contains(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!city.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getCity().contains(city)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!state.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getState_ID().contains(state)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!zip.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getZip_Code().contains(zip)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!country.equals("")) {
            ArrayList<Property> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getCountry_ID().contains(country)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Property> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("property");
        mav.addObject("home_builderRepo", hbr);
        mav.addObject("property_styleRepo", psr);
        mav.addObject("stateRepo", sr);
        mav.addObject("countryRepo", cr);
        mav.addObject("propertyList", pass);
        return mav;
    }



}

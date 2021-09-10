package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Homeowner_Associate;
import com.example.SwiftDatabase.model.Property_Finance;
import com.example.SwiftDatabase.repository.Homeowner_AssociateRepo;
import com.example.SwiftDatabase.repository.PropertyRepo;
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
public class Homeowner_AssociateController {
    @Autowired
    Homeowner_AssociateRepo homeowner_associateRepo;
    @Autowired
    PropertyRepo propertyRepo;

    @RequestMapping("/Homeowner_AssociationData")
    public ModelAndView homeownerPage() {
        ArrayList<Homeowner_Associate> all = new ArrayList<>();
        homeowner_associateRepo.findAll().forEach(all::add);
        ArrayList<Homeowner_Associate> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        Iterator<Homeowner_Associate> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("Homeowner_Associate");
        modelAndView.addObject("homeowner_associateRepo", homeowner_associateRepo);
        modelAndView.addObject("homeowner_associateList", pass);
        return modelAndView;

    }

    @RequestMapping("/Homeowner_AssociateEdit/{id}")
    public ModelAndView homeowner_associateEdit(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("Homeowner_Associateedit");
        modelAndView.addObject("propertyRepo", propertyRepo);
        modelAndView.addObject("homeowner_associateRepo", homeowner_associateRepo);
        modelAndView.addObject("HOA_ID", id);
        return modelAndView;
    }

    @RequestMapping("/Homeowner_AssociateEdited")
    public String homeowner_associateEdited(@RequestParam("hoafname") String HOA_First_Name, @RequestParam("hoalname") String HOA_Last_Name, @RequestParam("hoacomp") String HOA_Company, @RequestParam("id") String id) {
        Homeowner_Associate hoae = homeowner_associateRepo.findById(id).get();
        //hoae.setHOA_ID(street);
        hoae.setHOA_First_Name(HOA_First_Name);
        hoae.setHOA_Last_Name(HOA_Last_Name);
        hoae.setHOA_Company(HOA_Company);
        homeowner_associateRepo.save(hoae);

        return "redirect:/Homeowner_AssociationData";
    }

    @RequestMapping("/Homeowner_AssociateDelete/{id}")
    public String homeowner_associateDelete(@PathVariable("id") String id) {
        Homeowner_Associate hoae = homeowner_associateRepo.findById(id).get();
        hoae.setIsdelete(true);
        homeowner_associateRepo.save(hoae);

        return "redirect:/Homeowner_AssociationData";
    }

    @RequestMapping("/Homeowner_AssociateRedirect")
    public ModelAndView homeowner_associateRedirect() {
        ModelAndView modelAndView = new ModelAndView("Homeowner_Associatenew");
        modelAndView.addObject("propertyRepo", propertyRepo);

        return modelAndView;
    }

    @RequestMapping("/Homeowner_AssociateNew")
    public String homeowner_associateNew(@RequestParam("fname") String HOA_First_Name, @RequestParam("lname") String HOA_Last_Name, @RequestParam("hoacomp") String HOA_Company, @RequestParam("street") String street) {
        Homeowner_Associate hoae = new Homeowner_Associate();
        UUID uuid = UUID.randomUUID();
        hoae.setProperty_ID(String.valueOf(uuid));
        hoae.setHOA_ID(String.valueOf(uuid));
        hoae.setProperty_ID(street);
        hoae.setHOA_First_Name(HOA_First_Name);
        hoae.setHOA_Last_Name(HOA_Last_Name);
        hoae.setHOA_Company(HOA_Company);
        hoae.setIsdelete(false);
        homeowner_associateRepo.save(hoae);
        return "redirect:/Homeowner_AssociationData";
    }

    @RequestMapping("/Homeowner_AssociateFilter")
    public ModelAndView Homeowner_AssociatePageFilter(@RequestParam("fname") String HOA_First_Name, @RequestParam("lname") String HOA_Last_Name, @RequestParam("hoacomp") String HOA_Company) {
        ArrayList<Homeowner_Associate> all = new ArrayList<>();
        homeowner_associateRepo.findAll().forEach(all::add);
        ArrayList<Homeowner_Associate> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        /*
        if (!street.equals("")) {
            ArrayList<Homeowner_Associate> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getProperty_ID().contains(street)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

         */

        if (!HOA_First_Name.equals("")) {
            ArrayList<Homeowner_Associate> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getHOA_First_Name().contains(HOA_First_Name)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        if(!HOA_Last_Name.equals("")){
            ArrayList<Homeowner_Associate> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getHOA_Last_Name().contains(HOA_Last_Name)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!HOA_Company.equals("")){
            ArrayList<Homeowner_Associate> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++){
                if(fill.get(i).getHOA_Company().contains(HOA_Company)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Homeowner_Associate> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("homeowner_associate");
        modelAndView.addObject("propertyRepo", propertyRepo);
        modelAndView.addObject("homeowner_associateList", pass);
        return modelAndView;

    }


}

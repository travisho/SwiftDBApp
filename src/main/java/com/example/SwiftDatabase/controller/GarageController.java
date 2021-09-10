package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Floor_Plan;
import com.example.SwiftDatabase.model.Garage;
import com.example.SwiftDatabase.model.Property_Finance;
import com.example.SwiftDatabase.model.Utility_Bill;
import com.example.SwiftDatabase.repository.Floor_PlanRepo;
import com.example.SwiftDatabase.repository.GarageRepo;
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
public class GarageController {

    @Autowired
    GarageRepo garageRepo;

    @Autowired
    Floor_PlanRepo floor_planRepo;

    @Autowired
    PropertyRepo propertyRepo;

    @RequestMapping("/GarageData")
    public ModelAndView garagePage(){
        ArrayList<Garage> all = new ArrayList<>();
        garageRepo.findAll().forEach(all::add);
        ArrayList<Garage> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Garage> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("garage");
        modelAndView.addObject("propertyRepo", propertyRepo);

        modelAndView.addObject("floor_planRepo", floor_planRepo);
        modelAndView.addObject("garageList", pass);
        return modelAndView;
    }

    @RequestMapping("/GarageEdit/{id}")
    public ModelAndView garageEdit(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("garageedit");
        modelAndView.addObject("floor_planRepo", floor_planRepo);
        modelAndView.addObject("propertyRepo", propertyRepo);

        modelAndView.addObject("garageRepo", garageRepo);
        modelAndView.addObject("Garage_ID", id);
        return modelAndView;
    }

    @RequestMapping("/GarageEdited")
    public String garageEdited(@RequestParam("street") String street, @RequestParam("width") int width, @RequestParam("length") int length, @RequestParam("capacity") int capacity, @RequestParam("id") String id){
        Garage ge = garageRepo.findById(id).get();
        ge.setFloor_Plan_ID(street);
        ge.setGarage_Width_ft(width);
        ge.setGarage_Length_ft(length);
        ge.setGarage_Car_Capacity(capacity);
        garageRepo.save(ge);
        return "redirect:/GarageData";
    }

    @RequestMapping("/GarageDelete/{id}")
    public String GarageDelete(@PathVariable("id") String id){
        Garage ge = garageRepo.findById(id).get();
        ge.setIsdelete(true);
        garageRepo.save(ge);

        return "redirect:/GarageData";
    }

    @RequestMapping("/GarageRedirect")
    public ModelAndView GarageRedirect(){
        ModelAndView modelAndView = new ModelAndView("garagenew");
        modelAndView.addObject("floor_planRepo", floor_planRepo);
        modelAndView.addObject("propertyRepo", propertyRepo);
        return modelAndView;
    }

    @RequestMapping("/GarageNew")
    public String GarageNew(@RequestParam("width") int Garage_Width_ft, @RequestParam("length") int Garage_Length_ft, @RequestParam("capacity") int Garage_Car_Capacity, @RequestParam("street") String street){
        Garage ge = new Garage();
        UUID uuid = UUID.randomUUID();
        ge.setGarage_ID(String.valueOf(uuid));
        ge.setFloor_Plan_ID(String.valueOf(uuid));
        ge.setFloor_Plan_ID(street);
        ge.setGarage_Length_ft(Garage_Length_ft);
        ge.setGarage_Width_ft(Garage_Width_ft);
        ge.setGarage_Car_Capacity(Garage_Car_Capacity);
        ge.setIsdelete(false);
        garageRepo.save(ge);

        return "redirect:/GarageData";
    }


    @RequestMapping("/GarageFilter")
    public ModelAndView GarageFilter(@RequestParam("street") String street, @RequestParam("width") String Garage_Width_ft, @RequestParam("length") String Garage_Length_ft, @RequestParam("capacity") String Garage_Car_Capacity){
        ArrayList<Garage> all = new ArrayList<>();
        garageRepo.findAll().forEach(all::add);
        ArrayList<Garage> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!street.equals("")) {

            ArrayList<Garage> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getFloor_Plan_ID().contains(street)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        if(!(String.valueOf(Garage_Width_ft).equals(""))){
            ArrayList<Garage> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getGarage_Width_ft()==Integer.parseInt(Garage_Width_ft)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!(String.valueOf(Garage_Length_ft).equals(""))){
            ArrayList<Garage> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getGarage_Length_ft()==Integer.parseInt(Garage_Length_ft)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Garage> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("garage");
        modelAndView.addObject("floor_planRepo", floor_planRepo);
        modelAndView.addObject("propertyRepo", propertyRepo);
        modelAndView.addObject("garageList", pass);
        return modelAndView;
    }

}

package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Floor_Plan;
import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Property;
import com.example.SwiftDatabase.model.Room;
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
public class RoomController {

    @Autowired
    RoomRepo ubr;
    @Autowired
    Floor_PlanRepo pfr;
    @Autowired
    PropertyRepo pr;

    @RequestMapping("/RoomData")
    public ModelAndView RoomPage(){
        ArrayList<Room> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Room> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Room> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Room");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("RoomList", pass);
        return mav;
    }

    @RequestMapping("/RoomEdit/{id}")
    public ModelAndView RoomEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("RoomEdit");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("RoomRepo", ubr);
        mav.addObject("RoomList", ubr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("RoomID", id);
        return mav;
    }

    @RequestMapping("/RoomEdited")
    public String RoomEdited(@RequestParam("id") String id, @RequestParam("Room_Type") String Room_Type, @RequestParam("Room_Area_ft") int Room_Area_ft,@RequestParam("floorplan") String floorplan){
        Room ae = ubr.findById(id).get();
        ae.setRoom_Type(Room_Type);
        ae.setFloor_Plan_ID(floorplan);
        ae.setRoom_Area_ft(Room_Area_ft);
        ubr.save(ae);

        return "redirect:/RoomData";
    }

    @RequestMapping("/RoomDelete/{id}")
    public String RoomDelete(@PathVariable("id") String id){
        Room ae = ubr.findById(id).get();
        ae.setIsdelete(true);
        ubr.save(ae);

        return "redirect:/RoomData";
    }

    @RequestMapping("/RoomRedirect")
    public ModelAndView RoomRedirect(){
        ModelAndView mav = new ModelAndView("RoomNew");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("RoomRepo", ubr);
        return mav;
    }

    @RequestMapping("/RoomNew")
    public String RoomNew(@RequestParam("Room_Type") String Room_Type, @RequestParam("Room_Area_ft") int Room_Area_ft, @RequestParam("floorplan") String floorplan ){
        Room ae = new Room();
        UUID uuid = UUID.randomUUID();
        ae.setRoom_ID(String.valueOf(uuid));
        ae.setFloor_Plan_ID(floorplan);
        ae.setRoom_Type(Room_Type);
        ae.setRoom_Area_ft(Room_Area_ft);
        ae.setIsdelete(false);
        ubr.save(ae);

        return "redirect:/RoomData";
    }

    @RequestMapping("/RoomFilter")
    public ModelAndView RoomPageFilter(@RequestParam("Room_Type") String Room_Type, @RequestParam("Room_Area_Ft") String Room_Area_Ft,@RequestParam("street") String street){
        ArrayList<Room> all = new ArrayList<>();
        ubr.findAll().forEach(all::add);
        ArrayList<Room> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!Room_Type.equals("")) {
            ArrayList<Room> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getRoom_Type().equals(Room_Type)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!((Room_Area_Ft).equals(""))) {
            ArrayList<Room> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getRoom_Area_ft()== Integer.parseInt(Room_Area_Ft)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!(street).equals("")) {
            ArrayList<Room> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getFloor_Plan_ID().equals(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }



        Iterator<Room> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("Room");
        mav.addObject("Floor_PlanRepo", pfr);
        mav.addObject("PropertyRepo", pr);
        mav.addObject("RoomList", pass);
        return mav;
    }



}


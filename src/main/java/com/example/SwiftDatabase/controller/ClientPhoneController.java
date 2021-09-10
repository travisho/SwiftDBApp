package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.repository.ClientRepo;
import com.example.SwiftDatabase.model.Client_Phone_Number;
import com.example.SwiftDatabase.repository.Client_Phone_NumberRepo;
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
public class ClientPhoneController {

    @Autowired
    ClientRepo cr;
    @Autowired
    Client_Phone_NumberRepo cpr;

    @RequestMapping("/Client_Phone_NumberData")
    public ModelAndView clientPhonePage(){
        ArrayList<Client_Phone_Number> all = new ArrayList<>();
        cpr.findAll().forEach(all::add);
        ArrayList<Client_Phone_Number> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(!all.get(i).getIsdelete()){
                fill.add(all.get(i));
            }
        }
        Iterator<Client_Phone_Number> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("clientPhone");
        mav.addObject("clientRepo", cr);
        mav.addObject("clientPhoneList", pass);
        return mav;
    }

    @RequestMapping("/ClientPhoneEdit/{id}")
    public ModelAndView clientPhoneEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("clientPhoneedit");
        mav.addObject("clientRepo", cr);
        mav.addObject("client_Phone_NumberRepo", cpr);
        mav.addObject("Client_Phone_Number_ID", id);
        mav.addObject("clientPhoneList", cpr);

        return mav;
    }

    @RequestMapping("/ClientPhoneEdited")
    public String ClientPhoneEdited(@RequestParam("phone") String phone, @RequestParam("type") String type, @RequestParam("id") String id){
        Client_Phone_Number ce = cpr.findById(id).get();
        //ce.setClient_ID(first);
        //ce.setClient_ID(last);
        ce.setClient_Phone_Number(phone);
        ce.setClient_Type(type);
        cpr.save(ce);
        return "redirect:/Client_Phone_NumberData";
    }

    @RequestMapping("/ClientPhoneDelete/{id}")
    public String clientPhoneDelete(@PathVariable("id") String id){
        Client_Phone_Number ce = cpr.findById(id).get();
        ce.setIsdelete(true);
        cpr.save(ce);

        return "redirect:/Client_Phone_NumberData";
    }

    @RequestMapping("/ClientPhoneRedirect")
    public ModelAndView clientPhoneRedirect(){
        ModelAndView mav = new ModelAndView("clientPhonenew");
        mav.addObject("ClientRepo", cr);
        mav.addObject("Client_Phone_NumberRepo", cpr);
        return mav;
    }


    @RequestMapping("/ClientPhoneNew")
    public String clientPhoneNew(@RequestParam("first") String first, @RequestParam("phone") String phone, @RequestParam("type") String type){
        Client_Phone_Number ce = new Client_Phone_Number();
        UUID uuid = UUID.randomUUID();
        ce.setClient_Phone_Number_ID(String.valueOf(uuid));
        ce.setClient_ID(first);
        //ce.setClient_ID(last);
        ce.setClient_Phone_Number(phone);
        ce.setClient_Type(type);
        ce.setIsdelete(false);
        cpr.save(ce);

        return "redirect:/Client_Phone_NumberData";
    }

    @RequestMapping("/ClientPhoneFilter")
    public ModelAndView clientPhoneFilter(@RequestParam("client") String client, @RequestParam("phone") String phone, @RequestParam("type") String type){
        ArrayList<Client_Phone_Number> all = new ArrayList<>();

        cpr.findAll().forEach(all::add);
        ArrayList<Client_Phone_Number> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(!all.get(i).getIsdelete()){
                fill.add(all.get(i));
            }
        }

        if(!phone.equals("")) {
            ArrayList<Client_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getClient_Phone_Number().equals(phone)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!type.equals("")) {
            ArrayList<Client_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getClient_Type().equals(type)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!client.equals("")) {
            ArrayList<Client_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                String ClientName = cr.findById(fill.get(i).getClient_ID()).get().getClient_First_Name()+" "+cr.findById(fill.get(i).getClient_ID()).get().getClient_Last_Name();
                if (ClientName.contains(client)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Client_Phone_Number> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("clientPhone");
        mav.addObject("clientRepo", cr);
        mav.addObject("client_PhoneRepo", cpr);

        mav.addObject("clientPhoneList", pass);
        return mav;
    }

}

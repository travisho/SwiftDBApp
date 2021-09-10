package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Broker;
import com.example.SwiftDatabase.repository.BrokerRepo;
import com.example.SwiftDatabase.model.Broker_Phone_Number;
import com.example.SwiftDatabase.repository.Broker_Phone_NumberRepo;
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
public class BrokerPhoneNumberController {

    @Autowired
    BrokerRepo br;
    @Autowired
    Broker_Phone_NumberRepo bpnr;

    @RequestMapping("/Broker_Phone_NumberData")
    public ModelAndView brokerPhoneNumberPage(){
        ArrayList<Broker_Phone_Number> all = new ArrayList<>();
        bpnr.findAll().forEach(all::add);
        ArrayList<Broker_Phone_Number> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Broker_Phone_Number> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("brokerPhoneNumber");
        mav.addObject("brokerRepo", br);
        mav.addObject("brokerPhoneNumberList", pass);
        return mav;
    }

    @RequestMapping("/BrokerPhoneNumberEdit/{id}")
    public ModelAndView brokerPhoneNumberEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("brokerPhoneNumberedit");
        mav.addObject("brokerRepo", br);
        mav.addObject("broker_Phone_NumberRepo", bpnr);
        mav.addObject("Broker_Phone_Number_ID", id);
        return mav;
    }

    @RequestMapping("/BrokerPhoneNumberEdited")
    public String brokerPhoneNumberEdited(@RequestParam("id") String id, @RequestParam("number") String number, @RequestParam("type") String type){
        Broker_Phone_Number bn = bpnr.findById(id).get();
        bn.setBroker_Phone_Number(number);
        bn.setBroker_Phone_Type(type);
        bpnr.save(bn);

        return "redirect:/Broker_Phone_NumberData";
    }

    @RequestMapping("/BrokerPhoneNumberDelete/{id}")
    public String brokerPhoneNumberDelete(@PathVariable("id") String id){
        Broker_Phone_Number bn = bpnr.findById(id).get();
        bn.setIsdelete(true);
        bpnr.save(bn);

        return "redirect:/Broker_Phone_NumberData";
    }

    @RequestMapping("/BrokerPhoneNumberRedirect")
    public ModelAndView brokerPhoneNumberRedirect(){
        ModelAndView mav = new ModelAndView("brokerPhoneNumbernew");
        mav.addObject("brokerRepo", br);
        mav.addObject("broker_Phone_NumberRepo", bpnr);
        return mav;
    }

    @RequestMapping("/BrokerPhoneNumberNew")
    public String brokerPhoneNumberNew(@RequestParam("name") String name,@RequestParam("number") String number, @RequestParam("type") String type){
        Broker_Phone_Number bn = new Broker_Phone_Number();
        UUID uuid = UUID.randomUUID();
        bn.setBroker_Phone_Number_ID(String.valueOf(uuid));
        bn.setBroker_ID(name);
        bn.setBroker_Phone_Number(number);
        bn.setBroker_Phone_Type(type);
        bn.setIsdelete(false);
        bpnr.save(bn);

        return "redirect:/Broker_Phone_NumberData";
    }

    @RequestMapping("/BrokerPhoneNumberFilter")
    public ModelAndView brokerPhoneNumberPageFilter(@RequestParam("broker") String broker, @RequestParam("number") String number, @RequestParam("type") String type){
        ArrayList<Broker_Phone_Number> all = new ArrayList<>();
        bpnr.findAll().forEach(all::add);
        ArrayList<Broker_Phone_Number> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!broker.equals("")){
            ArrayList<Broker_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (br.findById(fill.get(i).getBroker_ID()).get().getBroker_Name().contains(broker)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!type.equals("")) {
            ArrayList<Broker_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getBroker_Phone_Number().contains(number)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!type.equals("")) {
            ArrayList<Broker_Phone_Number> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getBroker_Phone_Number().contains(type)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Broker_Phone_Number> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("brokerPhoneNumber");
        mav.addObject("brokerRepo", br);
        mav.addObject("brokerPhoneNumberList", pass);
        return mav;
    }

}

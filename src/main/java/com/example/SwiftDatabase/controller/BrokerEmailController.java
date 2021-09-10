package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Broker;
import com.example.SwiftDatabase.repository.BrokerRepo;
import com.example.SwiftDatabase.model.Broker_Email;
import com.example.SwiftDatabase.repository.Broker_EmailRepo;
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
public class BrokerEmailController {

    @Autowired
    BrokerRepo br;
    @Autowired
    Broker_EmailRepo ber;

    @RequestMapping("/Broker_EmailData")
    public ModelAndView brokerEmailPage(){
        ArrayList<Broker_Email> all = new ArrayList<>();
        ber.findAll().forEach(all::add);
        ArrayList<Broker_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Broker_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("brokerEmail");
        mav.addObject("brokerRepo", br);
        mav.addObject("brokerEmailList", pass);
        return mav;
    }

    @RequestMapping("/BrokerEmailEdit/{id}")
    public ModelAndView brokerEmailEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("brokerEmailedit");
        mav.addObject("brokerRepo", br);
        mav.addObject("broker_EmailRepo", ber);
        mav.addObject("Broker_Email_ID", id);
        return mav;
    }

    @RequestMapping("/BrokerEmailEdited")
    public String brokerEmailEdited(@RequestParam("broker") String broker, @RequestParam("id") String id, @RequestParam("email") String email){
        Broker_Email be = ber.findById(id).get();
        be.setBroker_ID(broker);
        be.setBroker_Email(email);
        ber.save(be);

        return "redirect:/Broker_EmailData";
    }

    @RequestMapping("/BrokerEmailDelete/{id}")
    public String brokerEmailDelete(@PathVariable("id") String id){
        Broker_Email be = ber.findById(id).get();
        be.setIsdelete(true);
        ber.save(be);

        return "redirect:/Broker_EmailData";
    }

    @RequestMapping("/BrokerEmailRedirect")
    public ModelAndView brokerEmailRedirect(){
        ModelAndView mav = new ModelAndView("brokerEmailnew");
        mav.addObject("brokerRepo", br);
        mav.addObject("broker_EmailRepo", ber);
        return mav;
    }

    @RequestMapping("/BrokerEmailNew")
    public String brokerEmailNew(@RequestParam("name") String name, @RequestParam("email") String email){
        Broker_Email be = new Broker_Email();
        UUID uuid = UUID.randomUUID();
        be.setBroker_Email_ID(String.valueOf(uuid));
        be.setBroker_ID(name);
        be.setBroker_Email(email);
        be.setIsdelete(false);
        ber.save(be);

        return "redirect:/Broker_EmailData";
    }

    @RequestMapping("/BrokerEmailFilter")
    public ModelAndView brokerEmailPageFilter(@RequestParam("broker") String broker, @RequestParam("email") String email){
        ArrayList<Broker_Email> all = new ArrayList<>();
        ber.findAll().forEach(all::add);
        ArrayList<Broker_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!broker.equals("")) {
            ArrayList<Broker_Email> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (br.findById(fill.get(i).getBroker_ID()).get().getBroker_Name().contains(broker)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!email.equals("")) {
            ArrayList<Broker_Email> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getBroker_Email().equals(email)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Broker_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("brokerEmail");
        mav.addObject("brokerRepo", br);
        mav.addObject("brokerEmailList", pass);
        return mav;
    }
    
}

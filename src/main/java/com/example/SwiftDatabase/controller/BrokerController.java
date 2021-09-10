package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Broker;
import com.example.SwiftDatabase.repository.BrokerRepo;
import com.example.SwiftDatabase.model.Broker_Company;
import com.example.SwiftDatabase.repository.Broker_CompanyRepo;
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
public class BrokerController {

        @Autowired
        BrokerRepo br;
        @Autowired
        Broker_CompanyRepo bcr;

        @RequestMapping("/BrokerData")
        public ModelAndView brokerPage(){
            ArrayList<Broker> all = new ArrayList<>();
            br.findAll().forEach(all::add);
            ArrayList<Broker> fill = new ArrayList<>();

            for(int i = 0; i < all.size(); i++){
                if(all.get(i).getIsdelete().equals(false)){
                    fill.add(all.get(i));
                }
            }
            Iterator<Broker> pass = fill.listIterator();

            ModelAndView mav = new ModelAndView("broker");
            mav.addObject("Broker_CompanyRepo", bcr);
            mav.addObject("brokerList", pass);
            return mav;
        }

        @RequestMapping("/BrokerEdit/{id}")
        public ModelAndView brokerEdit(@PathVariable("id") String id){
            ModelAndView mav = new ModelAndView("brokeredit");
            mav.addObject("BrokerRepo", br);
            mav.addObject("Broker_CompanyRepo", bcr);
            mav.addObject("Broker_ID", id);
            return mav;
        }

        @RequestMapping("/BrokerEdited")
        public String brokerEdited(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("company") String company){
            Broker be = br.findById(id).get();
            be.setBroker_Name(name);
            be.setBroker_Company_ID(company);
            br.save(be);

            return "redirect:/BrokerData";
        }

        @RequestMapping("/BrokerDelete/{id}")
        public String brokerDelete(@PathVariable("id") String id){
            Broker be = br.findById(id).get();
            be.setIsdelete(true);
            br.save(be);

            return "redirect:/BrokerData";
        }

        @RequestMapping("/BrokerRedirect")
        public ModelAndView brokerRedirect(){
            ModelAndView mav = new ModelAndView("brokernew");
            mav.addObject("BrokerRepo", br);
            mav.addObject("Broker_CompanyRepo", bcr);
            return mav;
        }

        @RequestMapping("/BrokerNew")
        public String brokerNew(@RequestParam("name") String name, @RequestParam("company") String company){
            Broker be = new Broker();
            UUID uuid = UUID.randomUUID();
            be.setBroker_ID(String.valueOf(uuid));
            be.setBroker_Name(name);
            be.setBroker_Company_ID(company);
            be.setIsdelete(false);
            br.save(be);

            return "redirect:/BrokerData";
        }

        @RequestMapping("/BrokerFilter")
        public ModelAndView brokerPageFilter(@RequestParam("name") String name, @RequestParam("company") String company){
            ArrayList<Broker> all = new ArrayList<>();
            br.findAll().forEach(all::add);
            ArrayList<Broker> fill = new ArrayList<>();

            for(int i = 0; i < all.size(); i++){
                if(all.get(i).getIsdelete().equals(false)){
                    fill.add(all.get(i));
                }
            }

            if(!name.equals("")) {
                ArrayList<Broker> temp = new ArrayList<>();
                for (int i = 0; i < fill.size(); i++) {
                    if (fill.get(i).getBroker_Name().equals(name)) {
                        temp.add(fill.get(i));
                    }
                }
                fill = temp;
            }
            if(!company.equals("")) {
                ArrayList<Broker> temp = new ArrayList<>();
                for (int i = 0; i < fill.size(); i++) {
                    if (fill.get(i).getBroker_Company_ID().equals(company)) {
                        temp.add(fill.get(i));
                    }
                }
                fill = temp;
            }

            Iterator<Broker> pass = fill.listIterator();

            ModelAndView mav = new ModelAndView("broker");
            mav.addObject("Broker_CompanyRepo", bcr);
            mav.addObject("brokerList", pass);
            return mav;
        }

}

package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Contract;
import com.example.SwiftDatabase.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class ContractController {

    @Autowired
    ContractRepo conr;
    @Autowired
    ClientRepo clir;
    @Autowired
    AgentRepo ager;
    @Autowired
    PropertyRepo pror;
    @Autowired
    Contract_StatusRepo consr;
    @Autowired
    Contract_TypeRepo contr;

    @RequestMapping("/ContractData")
    public ModelAndView contractPage(){
        ArrayList<Contract> all = new ArrayList<>();
        conr.findAll().forEach(all::add);
        ArrayList<Contract> fill = new ArrayList<>();

        for(int i = 0; i< all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Contract> pass = fill.listIterator();


        ModelAndView mav = new ModelAndView("contract");
        mav.addObject("clientRepo", clir);
        mav.addObject("agentRepo", ager);
        mav.addObject("propertyRepo", pror);
        mav.addObject("contract_statusRepo", consr);
        mav.addObject("contract_typeRepo", contr);
        mav.addObject("contractList", pass);
        return mav;
    }

    @RequestMapping("/ContractEdit/{id}")
    public ModelAndView contractEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("contractedit");
        mav.addObject("clientRepo", clir);
        mav.addObject("agentRepo", ager);
        mav.addObject("propertyRepo", pror);
        mav.addObject("contract_statusRepo", consr);
        mav.addObject("contract_typeRepo", contr);
        mav.addObject("contractRepo", conr);
        mav.addObject("ContractID", id);
        return mav;
    }

    @RequestMapping("/ContractEdited")
    public String contractEdited(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("street") String street, @RequestParam("status") String status, @RequestParam("type") String type, @RequestParam("movein") String movein, @RequestParam("city") String city, @RequestParam("id") String id){
        Contract ce = conr.findById(id).get();
        ce.setClient_ID(client);
        ce.setAgent_ID(agent);
        ce.setProperty_ID(street);
        ce.setContract_Status_ID(status);
        ce.setContract_Type_ID(type);
        String month = null;
        String day = null;
        if(!String.valueOf(movein.charAt(5)).equals("0")) {
            month = String.valueOf(movein.charAt(5)) + String.valueOf(movein.charAt(6));
        } else {
            month = String.valueOf(movein.charAt(6));
        }
        if(!String.valueOf(movein.charAt(8)).equals("0")) {
            day = String.valueOf(movein.charAt(8))+ String.valueOf(movein.charAt(9));
        } else {
            day = String.valueOf(movein.charAt(9));
        }
        String year = String.valueOf(movein.charAt(0)) +String.valueOf(movein.charAt(1)) +String.valueOf(movein.charAt(2)) +String.valueOf(movein.charAt(3));
        String date = month + "/" + day + "/" + year;
        ce.setMove_In_Date(date);
        ce.setDesired_City(city);
        conr.save(ce);

        return "redirect:/ContractData";
    }

    @RequestMapping("/ContractDelete/{id}")
    public String contractDelete(@PathVariable("id") String id){
        Contract ce = conr.findById(id).get();
        ce.setIsdelete(true);
        conr.save(ce);

        return "redirect:/ContractData";
    }

    @RequestMapping("/ContractRedirect")
    public ModelAndView contractRedirect(){
        ModelAndView mav = new ModelAndView("contractnew");
        mav.addObject("clientRepo", clir);
        mav.addObject("agentRepo", ager);
        mav.addObject("propertyRepo", pror);
        mav.addObject("contract_statusRepo", consr);
        mav.addObject("contract_typeRepo", contr);
        return mav;
    }

    @RequestMapping("/ContractNew")
    public String contractNew(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("street") String street, @RequestParam("status") String status, @RequestParam("type") String type, @RequestParam("movein") String movein, @RequestParam("city") String city){
        Contract ce = new Contract();
        UUID id = UUID.randomUUID();
        ce.setContract_ID(String.valueOf(id));
        ce.setClient_ID(client);
        ce.setAgent_ID(agent);
        ce.setProperty_ID(street);
        ce.setContract_Status_ID(status);
        ce.setContract_Type_ID(type);
        String month = null;
        String day = null;
        if(!String.valueOf(movein.charAt(5)).equals("0")) {
            month = String.valueOf(movein.charAt(5)) + String.valueOf(movein.charAt(6));
        } else {
            month = String.valueOf(movein.charAt(6));
        }
        if(!String.valueOf(movein.charAt(8)).equals("0")) {
            day = String.valueOf(movein.charAt(8))+ String.valueOf(movein.charAt(9));
        } else {
            day = String.valueOf(movein.charAt(9));
        }
        String year = String.valueOf(movein.charAt(0)) +String.valueOf(movein.charAt(1)) +String.valueOf(movein.charAt(2)) +String.valueOf(movein.charAt(3));
        String date = month + "/" + day + "/" + year;
        ce.setMove_In_Date(date);
        ce.setDesired_City(city);
        ce.setIsdelete(false);
        conr.save(ce);

        return "redirect:/ContractData";
    }

    @RequestMapping("/ContractFilter")
    public ModelAndView contractFilter(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("street") String street, @RequestParam("status") String status, @RequestParam("type") String type, @RequestParam("movein") String movein, @RequestParam("city") String city){
        ArrayList<Contract> all = new ArrayList<>();
        conr.findAll().forEach(all::add);
        ArrayList<Contract> fill = new ArrayList<>();

        for(int i = 0; i< all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!client.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                String clientname = clir.findById(fill.get(i).getClient_ID()).get().getClient_First_Name()+" "+clir.findById(fill.get(i).getClient_ID()).get().getClient_Last_Name();
                if(clientname.contains(client)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!agent.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getAgent_ID().contains(agent)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!street.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getProperty_ID().contains(street)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!type.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getContract_Type_ID().contains(type)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!status.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getContract_Status_ID().contains(status)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!movein.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            String month = null;
            String day = null;
            if(!String.valueOf(movein.charAt(5)).equals("0")) {
                month = String.valueOf(movein.charAt(5)) + String.valueOf(movein.charAt(6));
            } else {
                month = String.valueOf(movein.charAt(6));
            }
            if(!String.valueOf(movein.charAt(8)).equals("0")) {
                day = String.valueOf(movein.charAt(8))+ String.valueOf(movein.charAt(9));
            } else {
                day = String.valueOf(movein.charAt(9));
            }
            String year = String.valueOf(movein.charAt(0)) +String.valueOf(movein.charAt(1)) +String.valueOf(movein.charAt(2)) +String.valueOf(movein.charAt(3));
            String date = month + "/" + day + "/" + year;
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getMove_In_Date().equals(date)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!city.equals("")){
            ArrayList<Contract> temp = new ArrayList<>();
            for(int i=0;i<fill.size();i++){
                if(fill.get(i).getDesired_City().contains(city)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Contract> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("contract");
        mav.addObject("clientRepo", clir);
        mav.addObject("agentRepo", ager);
        mav.addObject("propertyRepo", pror);
        mav.addObject("contract_statusRepo", consr);
        mav.addObject("contract_typeRepo", contr);
        mav.addObject("contractList", pass);
        return mav;
    }

}

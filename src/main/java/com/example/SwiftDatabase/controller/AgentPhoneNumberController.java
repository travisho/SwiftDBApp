package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Agent;
import com.example.SwiftDatabase.model.Agent_Phone_Number;
import com.example.SwiftDatabase.model.Client;
import com.example.SwiftDatabase.model.Title_Owner;
import com.example.SwiftDatabase.repository.AgentRepo;
import com.example.SwiftDatabase.repository.Agent_Phone_NumberRepo;
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
public class AgentPhoneNumberController {
    @Autowired
    AgentRepo ar;
    @Autowired
    Agent_Phone_NumberRepo apr;
    @RequestMapping("/Agent_Phone_NumberData")
    public ModelAndView agentphonePage(){
        ArrayList<Agent_Phone_Number> all = new ArrayList<>();
        apr.findAll().forEach(all::add);
        ArrayList<Agent_Phone_Number> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Agent_Phone_Number> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("agentphone");
        mav.addObject("agentRepo", ar);
        mav.addObject("agentphoneList", pass);
        return mav;
    }
    @RequestMapping("/AgentPhoneEdit/{id}")
    public ModelAndView agentphoneEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("agentphoneedit");
        mav.addObject("AgentRepo", ar);
        mav.addObject("Agent_PhoneRepo", apr);
        mav.addObject("Agent_PhoneID", id);
        return mav;
    }
    @RequestMapping("/AgentPhoneEdited")
    public String agentphoneEdited(@RequestParam("agent") String agent, @RequestParam("id") String id,  @RequestParam("phone") String phone,@RequestParam("type") String type){
        Agent_Phone_Number ae = apr.findById(id).get();
        ae.setAgent_ID(agent);
        ae.setAgent_Phone_Number(phone);
        ae.setAgent_Phone_Type(type);
        apr.save(ae);

        return "redirect:/Agent_Phone_NumberData";
    }
    @RequestMapping("/AgentPhoneDelete/{id}")
    public String agentphoneDelete(@PathVariable("id") String id){
        Agent_Phone_Number ae = apr.findById(id).get();
        ae.setIsdelete(true);
        apr.save(ae);

        return "redirect:/Agent_Phone_NumberData";
    }
    @RequestMapping("/AgentPhoneRedirect")
    public ModelAndView agentphoneRedirect(){
        ModelAndView mav = new ModelAndView("agentphonenew");
        mav.addObject("AgentRepo", ar);
        return mav;
    }
    @RequestMapping("/AgentPhoneNew")
    public String agentphoneNew(@RequestParam("agent") String agent, @RequestParam("phone") String phone, @RequestParam("type") String type){
        Agent_Phone_Number cle = new Agent_Phone_Number();
        UUID uuid = UUID.randomUUID();
        cle.setAgent_Phone_Number_ID(String.valueOf(uuid));
        cle.setAgent_ID(agent);
        cle.setAgent_Phone_Number(phone);
        cle.setAgent_Phone_Type(type);
        cle.setIsdelete(false);
        apr.save(cle);

        return "redirect:/Agent_Phone_NumberData";
    }
    @RequestMapping("/AgentPhoneFilter")
    public ModelAndView agentphoneFilter(@RequestParam("agent") String agent,@RequestParam("phone") String phone,@RequestParam("type") String type){
        ArrayList<Agent_Phone_Number> all = new ArrayList<>();
        apr.findAll().forEach(all::add);
        ArrayList<Agent_Phone_Number> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!phone.equals("")) {
            ArrayList<Agent_Phone_Number> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAgent_Phone_Number().contains(phone)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!type.equals("")) {
            ArrayList<Agent_Phone_Number> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAgent_Phone_Type().contains(type)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!agent.equals("")) {
            ArrayList<Agent_Phone_Number> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String AgentName = ar.findById(fill.get(i).getAgent_ID()).get().getAgent_First_Name()+" "+ar.findById(fill.get(i).getAgent_ID()).get().getAgent_Last_Name();
                if(AgentName.contains(agent)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Agent_Phone_Number> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("agentphone");
        mav.addObject("agentRepo", ar);
        mav.addObject("agentphoneList", pass);
        return mav;
    }
}

package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Agent;
import com.example.SwiftDatabase.model.Agent_Email;
import com.example.SwiftDatabase.model.Floor_Plan;
import com.example.SwiftDatabase.repository.Agent_EmailRepo;
import com.example.SwiftDatabase.repository.AgentRepo;
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
public class Agent_EmailController {

    @Autowired
    Agent_EmailRepo aer;
    @Autowired
    AgentRepo ar;

    @RequestMapping("/Agent_EmailData")
    public ModelAndView Agent_EmailPage(){
        ArrayList<Agent_Email> all = new ArrayList<>();
        aer.findAll().forEach(all::add);
        ArrayList<Agent_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Agent_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Agent_Email");
        mav.addObject("AgentRepo",ar);
        mav.addObject("Agent_EmailList", pass);
        return mav;
    }

    @RequestMapping("/Agent_EmailEdit/{id}")
    public ModelAndView Agent_EmailEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("Agent_Emailedit");
        mav.addObject("Agent_EmailRepo", aer);
        mav.addObject("AgentRepo", ar);
        mav.addObject("Agent_EmailList", aer);
        mav.addObject("Agent_Email_ID", id);
        return mav;
    }

    @RequestMapping("/Agent_EmailEdited")
    public String Agent_EmailEdited(@RequestParam("id") String id, @RequestParam("Agent_Email") String Agent_Email,@RequestParam("agent") String agent){
        Agent_Email ae = aer.findById(id).get();
        ae.setAgent_ID(agent);
        ae.setAgent_Email(Agent_Email);
        aer.save(ae);

        return "redirect:/Agent_EmailData";
    }

    @RequestMapping("/Agent_EmailDelete/{id}")
    public String agentDelete(@PathVariable("id") String id){
        Agent_Email ae = aer.findById(id).get();
        ae.setIsdelete(true);
        aer.save(ae);

        return "redirect:/Agent_EmailData";
    }

    @RequestMapping("/Agent_EmailRedirect")
    public ModelAndView Agent_EmailRedirect(){
        ModelAndView mav = new ModelAndView("Agent_Emailnew");
        mav.addObject("AgentRepo", ar);
        mav.addObject("Agent_EmailRepo",aer);
        return mav;
    }

    @RequestMapping("/Agent_EmailNew")
    public String Agent_EmailNew(@RequestParam("Agent_Email") String Agent_Email,@RequestParam("agent") String agent){
        Agent_Email ae = new Agent_Email();
        UUID uuid = UUID.randomUUID();
        ae.setAgent_ID(agent);
        ae.setAgent_Email_ID(String.valueOf(uuid));
        ae.setAgent_Email(Agent_Email);
        ae.setIsdelete(false);
        aer.save(ae);
//        ,@RequestParam("First") String First,@RequestParam("Last") String Last

        return "redirect:/Agent_EmailData";
    }

    @RequestMapping("/Agent_EmailFilter")
    public ModelAndView Agent_EmailPageFilter(@RequestParam("Agent_Email") String Agent_Email,@RequestParam("agent") String agent){
        ArrayList<Agent_Email> all = new ArrayList<>();
        aer.findAll().forEach(all::add);
        ArrayList<Agent_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!Agent_Email.equals("")) {
            ArrayList<Agent_Email> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getAgent_Email().contains(Agent_Email)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!(agent).equals("")) {
            ArrayList<Agent_Email> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAgent_ID().equals(agent)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }




        Iterator<Agent_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("Agent_Email");
        mav.addObject("AgentRepo", ar);
        mav.addObject("Agent_EmailList", pass);
        return mav;
    }

}

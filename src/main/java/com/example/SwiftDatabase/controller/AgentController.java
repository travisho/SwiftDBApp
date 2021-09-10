package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Agent;
import com.example.SwiftDatabase.repository.AgentRepo;
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
public class AgentController {

    @Autowired
    AgentRepo ar;

    @RequestMapping("/AgentData")
    public ModelAndView agentPage(){
        ArrayList<Agent> all = new ArrayList<>();
        ar.findAll().forEach(all::add);
        ArrayList<Agent> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Agent> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("agent");
        mav.addObject("agentList", pass);
        return mav;
    }

    @RequestMapping("/AgentEdit/{id}")
    public ModelAndView agentEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("agentedit");
        mav.addObject("agentList", ar.findAll());
        mav.addObject("AgentID", id);
        return mav;
    }

    @RequestMapping("/AgentEdited")
    public String agentEdited(@RequestParam("id") String id, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("title") String title){
        Agent ae = ar.findById(id).get();
        ae.setAgent_First_Name(first);
        ae.setAgent_Last_Name(last);
        ae.setTitle(title);
        ar.save(ae);

        return "redirect:/AgentData";
    }

    @RequestMapping("/AgentDelete/{id}")
    public String agentDelete(@PathVariable("id") String id){
        Agent ae = ar.findById(id).get();
        ae.setIsdelete(true);
        ar.save(ae);

        return "redirect:/AgentData";
    }

    @RequestMapping("/AgentRedirect")
    public ModelAndView agentRedirect(){
        return new ModelAndView("agentnew");
    }

    @RequestMapping("/AgentNew")
    public String agentNew(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("title") String title){
        Agent ae = new Agent();
        UUID uuid = UUID.randomUUID();
        ae.setAgent_ID(String.valueOf(uuid));
        ae.setAgent_First_Name(first);
        ae.setAgent_Last_Name(last);
        ae.setTitle(title);
        ae.setIsdelete(false);
        ar.save(ae);

        return "redirect:/AgentData";
    }

    @RequestMapping("/AgentFilter")
    public ModelAndView agentPageFilter(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("title") String title){
        ArrayList<Agent> all = new ArrayList<>();
        ar.findAll().forEach(all::add);
        ArrayList<Agent> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!first.equals("")) {
            ArrayList<Agent> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getAgent_First_Name().contains(first)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!last.equals("")) {
            ArrayList<Agent> temp = new ArrayList<>();
            for(int i = 0; i < fill.size(); i++) {
                if(fill.get(i).getAgent_Last_Name().contains(last)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!title.equals("")) {
            ArrayList<Agent> temp = new ArrayList<>();
            for(int i = 0; i < fill.size(); i++) {
                if(fill.get(i).getTitle().contains(title)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Agent> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("agent");
        mav.addObject("agentList", pass);
        return mav;
    }

}

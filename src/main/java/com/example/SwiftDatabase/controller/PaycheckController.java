package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Agent;
import com.example.SwiftDatabase.model.Paycheck;
import com.example.SwiftDatabase.repository.AgentRepo;
import com.example.SwiftDatabase.repository.PaycheckRepo;
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
public class PaycheckController {
    @Autowired
    PaycheckRepo paycheckRepo;
    @Autowired
    AgentRepo agentRepo;

    @RequestMapping("/PaycheckData")
    public ModelAndView PaycheckPage(){
        ArrayList<Paycheck> all = new ArrayList<>();
        paycheckRepo.findAll().forEach(all::add);
        ArrayList<Paycheck> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Paycheck> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("paycheck");
        modelAndView.addObject("agentRepo",agentRepo);
        modelAndView.addObject("PaycheckList", pass);
        return modelAndView;
    }

    @RequestMapping("/PaycheckEdit/{id}")
    public ModelAndView PaycheckEdit(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("paycheckedit");
        modelAndView.addObject("agentRepo", agentRepo);
        modelAndView.addObject("paycheckRepo", paycheckRepo);
        modelAndView.addObject("Paycheck_ID", id);
        return modelAndView;
    }

   @RequestMapping("/PaycheckEdited")
    public String PaycheckEdited(@RequestParam("id") String id, @RequestParam("Agent_ID") String Agent_ID, @RequestParam("Paycheck_Amount") String Paycheck_Amount, @RequestParam("Date_Of_Payment") String Date_Of_Payment, @RequestParam("Month_Of_Services") String Month_Of_Services){
        Paycheck pe = paycheckRepo.findById(id).get();
        pe.setAgent_ID(Agent_ID);
        pe.setPaycheck_Amount(Paycheck_Amount);
        pe.setDate_Of_Payment(Date_Of_Payment);
        pe.setMonth_Of_Services(Month_Of_Services);
        paycheckRepo.save(pe);

        return "redirect:/PaycheckData";
    }


    @RequestMapping("/PaycheckDelete/{id}")
    public String PaycheckDelete(@PathVariable("id") String id){
        Paycheck pe = paycheckRepo.findById(id).get();
        pe.setIsdelete(true);
        paycheckRepo.save(pe);

        return "redirect:/PaycheckData";
    }


    @RequestMapping("/PaycheckRedirect")
    public ModelAndView PaycheckRedirect(){
        ModelAndView modelAndView = new ModelAndView("paychecknew");
        modelAndView.addObject("PaycheckRepo", paycheckRepo);
        modelAndView.addObject("agentRepo", agentRepo);
        return modelAndView;

    }


    @RequestMapping("/PaycheckNew")
    public String PaycheckNew(@RequestParam("Paycheck_Amount") String Paycheck_Amount, @RequestParam("Date_Of_Payment") String Date_Of_Payment, @RequestParam("Month_Of_Services") String Month_Of_Services, @RequestParam("Agent_ID") String Agent_ID){
        Paycheck ae = new Paycheck();
        UUID uuid = UUID.randomUUID();
        ae.setPaycheck_ID(String.valueOf(uuid));
        ae.setAgent_ID(Agent_ID);

        String month = null;
        String day = null;
        if(!String.valueOf(Date_Of_Payment.charAt(5)).equals("0")) {
            month = String.valueOf(Date_Of_Payment.charAt(5)) + String.valueOf(Date_Of_Payment.charAt(6));
        } else {
            month = String.valueOf(Date_Of_Payment.charAt(6));
        }
        if(!String.valueOf(Date_Of_Payment.charAt(8)).equals("0")) {
            day = String.valueOf(Date_Of_Payment.charAt(8))+ String.valueOf(Date_Of_Payment.charAt(9));
        } else {
            day = String.valueOf(Date_Of_Payment.charAt(9));
        }
        String year = String.valueOf(Date_Of_Payment.charAt(0)) +String.valueOf(Date_Of_Payment.charAt(1)) +String.valueOf(Date_Of_Payment.charAt(2)) +String.valueOf(Date_Of_Payment.charAt(3));
        String date = month + "/" + day + "/" + year;



        ae.setDate_Of_Payment(date);
        ae.setMonth_Of_Services(Month_Of_Services);
        ae.setPaycheck_Amount(Paycheck_Amount);

        ae.setIsdelete(false);
        paycheckRepo.save(ae);

        return "redirect:/PaycheckData";
    }

    @RequestMapping("/PaycheckFilter")
    public ModelAndView PaycheckPageFilter(@RequestParam("agent") String agent, @RequestParam("Paycheck_Amount") String Paycheck_Amount, @RequestParam("Date_Of_Payment") String Date_Of_Payment, @RequestParam("Month_Of_Services") String Month_Of_Services){
        ArrayList<Paycheck> all = new ArrayList<>();
        paycheckRepo.findAll().forEach(all::add);
        ArrayList<Paycheck> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!Paycheck_Amount.equals("")){
            ArrayList<Paycheck> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getPaycheck_Amount().contains(Paycheck_Amount)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Date_Of_Payment.equals("")){
            ArrayList<Paycheck> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getDate_Of_Payment().contains(Date_Of_Payment)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!Month_Of_Services.equals("")){
            ArrayList<Paycheck> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getMonth_Of_Services().contains(Month_Of_Services)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!agent.equals("")){
            ArrayList<Paycheck> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                String AgentName = agentRepo.findById(fill.get(i).getAgent_ID()).get().getAgent_First_Name()+" "+agentRepo.findById(fill.get(i).getAgent_ID()).get().getAgent_Last_Name();
                if (AgentName.contains(agent)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }


        Iterator<Paycheck> pass = fill.listIterator();

        ModelAndView modelAndView = new ModelAndView("paycheck");
        modelAndView.addObject("paycheckRepo", paycheckRepo);
        modelAndView.addObject("agentRepo", agentRepo);
        modelAndView.addObject("PaycheckList", pass);
        return modelAndView;
    }


}

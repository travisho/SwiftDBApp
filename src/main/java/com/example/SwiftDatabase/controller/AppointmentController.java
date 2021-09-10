package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Appointment;
import com.example.SwiftDatabase.repository.*;
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
public class AppointmentController {

    @Autowired
    AppointmentRepo appr;
    @Autowired
    AgentRepo ar;
    @Autowired
    ClientRepo cr;

    @RequestMapping("/AppointmentData")
    public ModelAndView appointmentPage(){
        ArrayList<Appointment> all = new ArrayList<>();
        appr.findAll().forEach(all::add);
        ArrayList<Appointment> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Appointment> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("appointment");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        mav.addObject("appointmentList", pass);
        return mav;
    }

    @RequestMapping("/AppointmentEdit/{id}")
    public ModelAndView appointmentEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("appointmentedit");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        mav.addObject("AppointmentRepo", appr);
        mav.addObject("Appointment_ID", id);
        return mav;
    }

    @RequestMapping("/AppointmentEdited")
    public String appointmentEdited(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("id") String id, @RequestParam("appdate") String appdate, @RequestParam("apptime") String apptime, @RequestParam("apptopic") String apptopic, @RequestParam("appsummary") String appsummary){
        Appointment appe = appr.findById(id).get();
        appe.setAgent_ID(agent);
        appe.setClient_ID(client);
        appe.setAppointment_Date(appdate);
        appe.setAppointment_Time(apptime);
        appe.setAppointment_Topic(apptopic);
        appe.setAppointment_Summary(appsummary);
        appr.save(appe);

        return "redirect:/AppointmentData";
    }

    @RequestMapping("/AppointmentDelete/{id}")
    public String appointmentDelete(@PathVariable("id") String id){
        Appointment appe = appr.findById(id).get();
        appe.setIsdelete(true);
        appr.save(appe);

        return "redirect:/AppointmentData";
    }

    @RequestMapping("/AppointmentRedirect")
    public ModelAndView appointmentRedirect(){
        ModelAndView mav = new ModelAndView("appointmentnew");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        return mav;
    }

    @RequestMapping("/AppointmentNew")
    public String agentNew(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("appdate") String appdate, @RequestParam("apptime") String apptime, @RequestParam("apptopic") String apptopic, @RequestParam("appsummary") String appsummary){
        Appointment appe = new Appointment();
        UUID uuid = UUID.randomUUID();
        appe.setAppointment_ID(String.valueOf(uuid));
        appe.setAgent_ID(agent);
        appe.setClient_ID(client);
        appe.setAppointment_Date(appdate);
        appe.setAppointment_Time(apptime);
        appe.setAppointment_Topic(apptopic);
        appe.setAppointment_Summary(appsummary);
        appe.setIsdelete(false);
        appr.save(appe);

        return "redirect:/AppointmentData";
    }

    @RequestMapping("/AppointmentFilter")
    public ModelAndView appointmentPageFilter(@RequestParam("client") String client, @RequestParam("agent") String agent, @RequestParam("appdate") String appdate, @RequestParam("apptime") String apptime, @RequestParam("apptopic") String apptopic, @RequestParam("appsummary") String appsummary){
        ArrayList<Appointment> all = new ArrayList<>();
        appr.findAll().forEach(all::add);
        ArrayList<Appointment> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!agent.equals("")) {
            ArrayList<Appointment> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String AgentName = ar.findById(fill.get(i).getAgent_ID()).get().getAgent_First_Name()+" "+ar.findById(fill.get(i).getAgent_ID()).get().getAgent_Last_Name();
                if(AgentName.contains(agent)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!client.equals("")) {
            ArrayList<Appointment> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                String ClientName = cr.findById(fill.get(i).getClient_ID()).get().getClient_First_Name()+" "+cr.findById(fill.get(i).getClient_ID()).get().getClient_Last_Name();
                if(ClientName.contains(client)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!apptime.equals("")) {
            ArrayList<Appointment> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAppointment_Time().equals(apptime)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!apptopic.equals("")) {
            ArrayList<Appointment> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAppointment_Topic().equals(apptopic)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!appsummary.equals("")) {
            ArrayList<Appointment> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAppointment_Summary().equals(appsummary)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Appointment> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("appointment");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        mav.addObject("appointmentList", pass);
        return mav;
    }



}

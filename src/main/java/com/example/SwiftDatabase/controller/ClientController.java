package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Client_Status;
import com.example.SwiftDatabase.model.Client;
import com.example.SwiftDatabase.model.Property;
import com.example.SwiftDatabase.repository.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
@Controller
public class ClientController {
    @Autowired
    ClientRepo clr;
    @Autowired
    Client_StatusRepo csr;

    @RequestMapping("/ClientData")
    public ModelAndView propertyPage() {
        ArrayList<Client> all = new ArrayList<>();
        clr.findAll().forEach(all::add);
        ArrayList<Client> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        Iterator<Client> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("client");

        mav.addObject("Client_StatusRepo", csr);
        mav.addObject("clientList", pass);
        return mav;
    }
    @RequestMapping("/ClientEdit/{id}")
    public ModelAndView propertyEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("clientedit");
        mav.addObject("Client_StatusRepo", csr);
        mav.addObject("ClientRepo", clr);
        mav.addObject("ClientID", id);
        return mav;
    }
    @RequestMapping("/ClientEdited")
    public String clientEdited(@RequestParam("id") String id, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("status") String status, @RequestParam("type") String type){
        Client cle = clr.findById(id).get();
        cle.setClient_First_Name(first);
        cle.setClient_Last_Name(last);
        cle.setClient_Status_ID(status);
        cle.setClient_Type(type);
        clr.save(cle);

        return "redirect:/ClientData";
    }
    @RequestMapping("/ClientDelete/{id}")
    public String clientDelete(@PathVariable("id") String id){
        Client cle = clr.findById(id).get();
        cle.setIsdelete(true);
        clr.save(cle);

        return "redirect:/ClientData";
    }
    @RequestMapping("/ClientRedirect")
    public ModelAndView clienttRedirect(){
        ModelAndView mav = new ModelAndView("clientnew");
        mav.addObject("Client_StatusRepo", csr);
        return mav;
    }
    @RequestMapping("/ClientNew")
    public String agentNew(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("status") String status, @RequestParam("type") String type){
        Client cle = new Client();
        UUID uuid = UUID.randomUUID();
        cle.setClient_ID(String.valueOf(uuid));
        cle.setClient_First_Name(first);
        cle.setClient_Last_Name(last);
        cle.setClient_Status_ID(status);
        cle.setClient_Type(type);
        cle.setIsdelete(false);
        clr.save(cle);

        return "redirect:/ClientData";
    }
    @RequestMapping("/ClientFilter")
    public ModelAndView clientPageFilter(@RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("status") String status, @RequestParam("type") String type) {
        ArrayList<Client> all = new ArrayList<>();
        clr.findAll().forEach(all::add);
        ArrayList<Client> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        if(!first.equals("")) {
            ArrayList<Client> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getClient_First_Name().contains(first)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!last.equals("")) {
            ArrayList<Client> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getClient_Last_Name().contains(last)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!status.equals("")) {
            ArrayList<Client> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getClient_Status_ID().contains(status)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        if(!type.equals("")) {
            ArrayList<Client> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getClient_Type().contains(type)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Client> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("client");
        mav.addObject("Client_StatusRepo", csr);
        mav.addObject("clientList", pass);
        return mav;
    }
}
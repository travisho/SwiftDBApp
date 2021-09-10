package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.repository.ClientRepo;
import com.example.SwiftDatabase.model.Client_Email;
import com.example.SwiftDatabase.repository.Client_EmailRepo;
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
public class ClientEmailController {

    @Autowired
    ClientRepo cr;
    @Autowired
    Client_EmailRepo cer;

    @RequestMapping("/Client_EmailData")
    public ModelAndView clientEmailPage(){
        ArrayList<Client_Email> all = new ArrayList<>();
        cer.findAll().forEach(all::add);
        ArrayList<Client_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(!all.get(i).getIsdelete()){
                fill.add(all.get(i));
            }
        }
        Iterator<Client_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("clientEmail");
        mav.addObject("clientRepo", cr);
        mav.addObject("clientEmailList", pass);
        return mav;
    }

    @RequestMapping("/ClientEmailEdit/{id}")
    public ModelAndView clientEmailEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("clientEmailedit");
        mav.addObject("clientRepo", cr);
        mav.addObject("client_EmailRepo", cer);
        mav.addObject("Client_Email_ID", id);
      mav.addObject("clientEmailList", cer);

        return mav;
    }

    @RequestMapping("/ClientEmailEdited")
    public String ClientEmailEdited(@RequestParam("client") String client, @RequestParam("email") String email, @RequestParam("id") String id){
        Client_Email ce = cer.findById(id).get();
        ce.setClient_ID(client);
        ce.setClient_Email(email);
        cer.save(ce);

        return "redirect:/Client_EmailData";
    }

    @RequestMapping("/ClientEmailDelete/{id}")
    public String clientEmailDelete(@PathVariable("id") String id){
        Client_Email ce = cer.findById(id).get();
        ce.setIsdelete(true);
        cer.save(ce);

        return "redirect:/Client_EmailData";
    }

    @RequestMapping("/ClientEmailRedirect")
    public ModelAndView clientEmailRedirect(){
        ModelAndView mav = new ModelAndView("clientEmailnew");
        mav.addObject("clientRepo", cr);
        mav.addObject("Client_EmailRepo", cer);
        return mav;
    }



    @RequestMapping("/ClientEmailNew")
    public String clientEmailNew(@RequestParam("client") String client, @RequestParam("email") String email){
        Client_Email ce = new Client_Email();
        UUID uuid = UUID.randomUUID();
        ce.setClient_Email_ID(String.valueOf(uuid));
        ce.setClient_ID(client);
        ce.setClient_Email(email);
        ce.setIsdelete(false);
        cer.save(ce);

        return "redirect:/Client_EmailData";
    }

    @RequestMapping("/ClientEmailFilter")
    public ModelAndView clientEmailFilter(@RequestParam("client") String client, @RequestParam("email") String email){
        ArrayList<Client_Email> all = new ArrayList<>();

        cer.findAll().forEach(all::add);
        ArrayList<Client_Email> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(!all.get(i).getIsdelete()){
                fill.add(all.get(i));
            }
        }

        if(!email.equals("")) {
            ArrayList<Client_Email> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getClient_Email().equals(email)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!client.equals("")) {
            ArrayList<Client_Email> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                String ClientName = cr.findById(fill.get(i).getClient_ID()).get().getClient_First_Name()+" "+cr.findById(fill.get(i).getClient_ID()).get().getClient_Last_Name();
                if (ClientName.contains(client)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Client_Email> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("clientEmail");
        mav.addObject("clientRepo", cr);
        mav.addObject("client_EmailRepo", cer);

        mav.addObject("clientEmailList", pass);
        return mav;
    }

}

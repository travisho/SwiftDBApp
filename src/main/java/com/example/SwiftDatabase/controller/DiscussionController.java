package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Discussion;
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
public class DiscussionController {

    @Autowired
    DiscussionRepo dr;
    @Autowired
    ClientRepo cr;
    @Autowired
    AgentRepo ar;
    @Autowired
    Discussion_MediumRepo dmr;


    @RequestMapping("/DiscussionData")
    public ModelAndView propertyPage(){
        ArrayList<Discussion> all = new ArrayList<>();
        dr.findAll().forEach(all::add);
        ArrayList<Discussion> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Discussion> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("discussion");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        mav.addObject("discussion_mediumRepo", dmr);
        mav.addObject("discussionList", pass);
        return mav;
    }

    @RequestMapping("/DiscussionEdit/{id}")
    public ModelAndView discussionEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("discussionEdit");
        mav.addObject("agentRepo", ar);
        mav.addObject("clientRepo", cr);
        mav.addObject("discussion_mediumRepo", dmr);
        mav.addObject("discussionRepo", dr);
        mav.addObject("DiscussionID", id);
        return mav;
    }

    @RequestMapping("/DiscussionEdited")
    public String discussionEdited(@RequestParam("id") String id, @RequestParam("agent") String agent, @RequestParam("client") String client, @RequestParam("medium") String medium, @RequestParam("time") String time, @RequestParam("topic") String topic, @RequestParam("summary") String summary) {
        Discussion de = dr.findById(id).get();
        de.setAgent_ID(agent);
        de.setClient_ID(client);
        de.setDiscussion_Medium_ID(medium);
        de.setDiscussion_Time(Integer.parseInt(time));
        de.setDiscussion_Topic(topic);
        de.setDiscussion_Summary(summary);
        dr.save(de);

        return "redirect:/DiscussionData";
    }

    @RequestMapping("/DiscussionDelete/{id}")
    public String discussionDelete(@PathVariable("id") String id){
        Discussion de = dr.findById(id).get();
        de.setIsdelete(true);
        dr.save(de);

        return "redirect:/DiscussionData";
    }

    @RequestMapping("/DiscussionRedirect")
    public ModelAndView discussionRedirect(){
        ModelAndView mav = new ModelAndView("discussionnew");
        mav.addObject("clientRepo", cr);
        mav.addObject("agentRepo", ar);
        mav.addObject("discussion_mediumRepo", dmr);
        //mav.addObject("discussionRepo", dr);
        return mav;
    }

    @RequestMapping("/DiscussionNew")
    public String discussionNew(@RequestParam("agent") String agent, @RequestParam("client") String client, @RequestParam("medium") String medium, @RequestParam("time") String time, @RequestParam("topic") String topic, @RequestParam("summary") String summary){
        Discussion de = new Discussion();
        UUID uuid = UUID.randomUUID();
        de.setDiscussion_ID(String.valueOf(uuid));
        de.setAgent_ID(agent);
        de.setClient_ID(client);
        de.setDiscussion_Medium_ID(medium);
        de.setDiscussion_Time(Integer.parseInt(time));
        de.setDiscussion_Topic(topic);
        de.setDiscussion_Summary(summary);
        de.setIsdelete(false);
        dr.save(de);

        return "redirect:/DiscussionData";
    }

    @RequestMapping("/DiscussionFilter")
    public ModelAndView discussionPageFilter(@RequestParam("agent") String agent, @RequestParam("client") String client, @RequestParam("medium") String medium, @RequestParam("time") String time, @RequestParam("topic") String topic, @RequestParam("summary") String summary){
        ArrayList<Discussion> all = new ArrayList<>();
        dr.findAll().forEach(all::add);
        ArrayList<Discussion> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!agent.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getAgent_ID().contains(agent)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!client.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getClient_ID().contains(client)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!medium.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDiscussion_Medium_ID().contains(medium)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!time.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDiscussion_Time()==Integer.parseInt(time)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!topic.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDiscussion_Topic().contains(topic)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if(!summary.equals("")) {
            ArrayList<Discussion> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getDiscussion_Summary().contains(summary)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        Iterator<Discussion> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("discussion");
        mav.addObject("clientRepo", cr);
        mav.addObject("agentRepo", ar);
        mav.addObject("discussion_mediumRepo", dmr);
        mav.addObject("discussionList", pass);
        return mav;
    }



}

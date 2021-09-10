package com.example.SwiftDatabase.controller;
import com.example.SwiftDatabase.model.Client;
import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Property;
import com.example.SwiftDatabase.model.Top_Feature;
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
public class TopFeatureController {
    @Autowired
    PropertyRepo pr;
    @Autowired
    Top_FeatureRepo tfr;

    @RequestMapping("/Top_FeatureData")
    public ModelAndView topfeaturePage() {
        ArrayList<Top_Feature> all = new ArrayList<>();
        tfr.findAll().forEach(all::add);
        ArrayList<Top_Feature> fill = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }
        Iterator<Top_Feature> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("top_feature");

        mav.addObject("propertyRepo", pr);
        mav.addObject("topfeatureList", pass);
        return mav;
    }
    @RequestMapping("/TopFeatureEdit/{id}")
    public ModelAndView topfeatureEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("top_featureedit");
        mav.addObject("propertyRepo", pr);
        mav.addObject("Top_FeatureRepo", tfr);
        mav.addObject("Top_FeatureID", id);
        return mav;
    }
    @RequestMapping("/TopFeatureEdited")
    public String topfeatureEdited(@RequestParam("id") String id, @RequestParam("top_feature") String top){
        Top_Feature t =tfr.findById(id).get();
        t.setTop_Feature(top);
        tfr.save(t);

        return "redirect:/Top_FeatureData";
    }
    @RequestMapping("/TopFeatureDelete/{id}")
    public String topfeatureDelete(@PathVariable("id") String id){
        Top_Feature t = tfr.findById(id).get();
        t.setIsdelete(true);
        tfr.save(t);

        return "redirect:/Top_FeatureData";
    }
    @RequestMapping("/TopFeatureRedirect")
    public ModelAndView topfeatureRedirect(){
        ModelAndView mav = new ModelAndView("top_featurenew");
        mav.addObject("propertyRepo", pr);
        return mav;
    }

    @RequestMapping("/TopFeatureNew")
    public String topfeatureNew( @RequestParam("street") String street, @RequestParam("top_feature") String top ){
        Top_Feature t = new Top_Feature();
        UUID uuid = UUID.randomUUID();
        t.setTop_Feature_ID(String.valueOf(uuid));
        t.setProperty_ID(street);
        t.setTop_Feature(top);
        t.setIsdelete(false);
        tfr.save(t);

        return "redirect:/Top_FeatureData";
    }
    @RequestMapping("/TopFeatureFilter")
    public ModelAndView topfeatureFilter(@RequestParam("top_feature") String top){
        ArrayList<Top_Feature> all = new ArrayList<>();
        tfr.findAll().forEach(all::add);
        ArrayList<Top_Feature> fill = new ArrayList<>();

        for(int i=0; i<all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }

        if(!top.equals("")) {
            ArrayList<Top_Feature> temp = new ArrayList<>();
            for(int i=0; i<fill.size(); i++) {
                if(fill.get(i).getTop_Feature().contains(top)){
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }
        Iterator<Top_Feature> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("top_feature");
        mav.addObject("propertyRepo", pr);
        mav.addObject("topfeatureList", pass);
        return mav;
    }
}
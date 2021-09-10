package com.example.SwiftDatabase.controller;

import com.example.SwiftDatabase.model.Home_Builder;
import com.example.SwiftDatabase.model.Commission_Plan;
import com.example.SwiftDatabase.repository.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class Commission_PlanController {

    @Autowired
    Commission_PlanRepo cpr;
    @Autowired
    BrokerRepo br;
    @Autowired
    PropertyRepo pr;
    @Autowired
    ClientRepo cr;
    @Autowired
    ContractRepo ctr;



    @RequestMapping("/Commission_PlanData")
    public ModelAndView propertyPage(){
        ArrayList<Commission_Plan> all = new ArrayList<>();
        cpr.findAll().forEach(all::add);
        ArrayList<Commission_Plan> fill = new ArrayList<>();

        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getIsdelete().equals(false)){
                fill.add(all.get(i));
            }
        }
        Iterator<Commission_Plan> pass = fill.listIterator();

        ModelAndView mav = new ModelAndView("commission_plan");
        mav.addObject("brokerRepo", br);
        mav.addObject("propertyRepo", pr);
        mav.addObject("clientRepo", cr);
        mav.addObject("contractRepo", ctr);
        mav.addObject("commission_planList", pass);
        return mav;
    }

    @RequestMapping("/Commission_PlanEdit/{id}")
    public ModelAndView commission_planEdit(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("commission_planEdit");
        mav.addObject("brokerRepo", br);
        mav.addObject("propertyRepo", pr);
        mav.addObject("clientRepo", cr);
        mav.addObject("contractRepo", ctr);
        mav.addObject("commission_planRepo", cpr);
        mav.addObject("CommissionPlanID", id);
        return mav;
    }

    @RequestMapping("/Commission_PlanEdited")
    public String commission_planEdited(@RequestParam("contract") String contract, @RequestParam("id") String id, @RequestParam("totalCom") String totalCom, @RequestParam("YunCom") String YunCom, @RequestParam("broker") String broker, @RequestParam("brokerCom") String brokerCom){
        Commission_Plan cpe = cpr.findById(id).get();
        cpe.setTotal_Commission(Double.parseDouble(totalCom));
        cpe.setYun_Global_Commission_Percent(Double.parseDouble(YunCom));
        cpe.setBroker_ID(broker);
        cpe.setBroker_Commission_Percent(Double.parseDouble(brokerCom));
        cpe.setContract_ID(contract);
        cpr.save(cpe);

        return "redirect:/Commission_PlanData";
    }

    @RequestMapping("/Commission_PlanDelete/{id}")
    public String commission_planDelete(@PathVariable("id") String id){
        Commission_Plan cpe = cpr.findById(id).get();
        cpe.setIsdelete(true);
        cpr.save(cpe);

        return "redirect:/Commission_PlanData";
    }

    @RequestMapping("/Commission_PlanRedirect")
    public ModelAndView commission_planRedirect(){
        ModelAndView mav = new ModelAndView("commission_plannew");
        mav.addObject("brokerRepo", br);
        mav.addObject("propertyRepo", pr);
        mav.addObject("clientRepo", cr);
        mav.addObject("contractRepo", ctr);
        return mav;
    }

    @RequestMapping("/Commission_PlanNew")
    public String commission_planNew(@RequestParam("contract") String contract, @RequestParam("totalCom") String totalCom, @RequestParam("YunCom") String YunCom, @RequestParam("broker") String broker, @RequestParam("brokerCom") String brokerCom){
        Commission_Plan cpe = new Commission_Plan();
        UUID uuid = UUID.randomUUID();
        cpe.setCommission_Plan_ID(String.valueOf(uuid));
        cpe.setTotal_Commission(Double.parseDouble(totalCom));
        cpe.setYun_Global_Commission_Percent(Double.parseDouble(YunCom));
        cpe.setBroker_ID(broker);
        cpe.setBroker_Commission_Percent(Double.parseDouble(brokerCom));
        cpe.setContract_ID(contract);
        cpe.setIsdelete(false);
        cpr.save(cpe);

        return "redirect:/Commission_PlanData";
    }

    @RequestMapping("/Commission_PlanFilter")
    public ModelAndView commission_planPageFilter(@RequestParam("contract") String contract,  @RequestParam("totalCom") String totalCom, @RequestParam("YunCom") String YunCom, @RequestParam("broker") String broker, @RequestParam("brokerCom") String brokerCom) {
        ArrayList<Commission_Plan> all = new ArrayList<>();
        cpr.findAll().forEach(all::add);
        ArrayList<Commission_Plan> fill = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsdelete().equals(false)) {
                fill.add(all.get(i));
            }
        }

        if (!totalCom.equals("")) {
            ArrayList<Commission_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getTotal_Commission() == Double.parseDouble(totalCom)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if (!YunCom.equals("")) {
            ArrayList<Commission_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getYun_Global_Commission_Percent() == Double.parseDouble(YunCom)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if (!broker.equals("")) {
            ArrayList<Commission_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getBroker_ID().contains(broker)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if (!brokerCom.equals("")) {
            ArrayList<Commission_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getBroker_Commission_Percent() == Double.parseDouble(brokerCom)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }

        if (!contract.equals("")) {
            ArrayList<Commission_Plan> temp = new ArrayList<>();
            for (int i = 0; i < fill.size(); i++) {
                if (fill.get(i).getContract_ID().contains(contract)) {
                    temp.add(fill.get(i));
                }
            }
            fill = temp;
        }




        Iterator<Commission_Plan> pass = fill.listIterator();
        ModelAndView mav = new ModelAndView("commission_plan");
        mav.addObject("brokerRepo", br);
        mav.addObject("propertyRepo", pr);
        mav.addObject("clientRepo", cr);
        mav.addObject("contractRepo", ctr);
        mav.addObject("commission_planList", pass);
        return mav;
    }
}

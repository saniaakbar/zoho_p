package com.zohocrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
//import com.zohocrm.entities.Lead;
//import com.zohocrm.entities.Contact;
import com.zohocrm.services.BillingService;

@Controller
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	@RequestMapping("/generate")
    public String generateBill(@ModelAttribute("bill") Billing bill) {
    	billingService.generateOneBill(bill);
		return "billing_result";
    }
	
	 @RequestMapping("/generateBillById")
	    public String getContactById(@RequestParam("id") long id,ModelMap model) {
	    	Billing bill = billingService.getBill(id);
	    	model.addAttribute("bill", bill);
	        return "billing_result";
	    }
	 @RequestMapping("/billing")
     public String listAllBills(ModelMap model) {
    	 List<Billing> bills = billingService.findAllBills();
    	 model.addAttribute("bills", bills);
    	 return "all_bills";
     }
}

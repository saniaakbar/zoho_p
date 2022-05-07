package com.zohocrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;

@Controller
public class LeadControllers {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/view")
     public String viewCreatLeadPage() {
		return "create_lead";
     }
	
     @RequestMapping("/saveLead")
     public String saveOneLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
    	 leadService.saveLead(lead);
    	 model.addAttribute("lead",lead);
    	 return "lead_info";
     }
     
     @RequestMapping("/listall")
     public String listAllLeads(ModelMap model) {
    	 List<Lead> leads = leadService.findAllLeads();
    	 model.addAttribute("leads", leads);
    	 return "lead_result";
     }
    @RequestMapping("/getLeadById") 
    public String getLeadById(@RequestParam("id") long id,ModelMap model) { 
    	Lead lead=leadService.getLead(id);
    	 model.addAttribute("lead",lead);
    	return "lead_info";
    }
    @RequestMapping("/convert")
    public String convert(@RequestParam("id") long id,ModelMap model) {
    	Lead lead=leadService.getLead(id);
    	Contact contact = new Contact();
    	contact.setFirstName(lead.getFirstName());
    	contact.setLastName(lead.getLastName());
    	contact.setEmail(lead.getEmail());
    	contact.setLeadSource(lead.getLeadSource());
    	contact.setMobile(lead.getMobile());
    	contactService.saveContact(contact);
    	List<Contact> contacts = contactService.findAllContacts();
    	model.addAttribute("contacts",contacts);
    	leadService.deleteLead(id);
    	return "contact_result";
    }
}

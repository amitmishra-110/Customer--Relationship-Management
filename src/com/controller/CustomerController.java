package com.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	
	//Injecting DAO in controller
	@Autowired
	private CustomerDAO customerDAO; //Spring will scan for component that implements CustomerDao  interface

	@Autowired
	private CustomerService customerService;
	
	/*
	 * @RequestMapping("/") String firstRequest() { return "welcome"; }
	 * 
	 * INSTEAD USE OF WELCOME-FILE-LIST TAG FOR LANDNING PAGE
	 */
	
	/* @RequestMapping("/list") */
	
	@GetMapping("/list")
	public String  showCustomerList(Model theModel)
	{		
		System.out.println("Hello within showCustomerList");
		//get Customer using service from DAO
		List<Customer> theCustomers=customerService.getCustomers();
		System.out.println("The Object value is " + theCustomers);
		//add customer from spring mvc model
		theModel.addAttribute("Customers",theCustomers); 
		return "list-customers";
	}
	
	//Displaying Add customer page and initialising all the spring forms variable to null
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	
	//saving the customer by fetching the data enter in forms using @ModelAttribute 
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer)
	{
		
		//saving the customer using the service
		customerService.saveCustomer(theCustomer);
		//return "list-customers"; good for viewing page 
		return "redirect:/customer/list"; // good for redirecting after operation
	}
}

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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForUpdate")
	public String showFormFormUpdate(@RequestParam("customerId") int id, Model theModel)
	{
		//get customer from service
		Customer theCustomer=customerService.getCustomer(id);
		
		//set the customer to the model attribute for prepoulating the form
		theModel.addAttribute("customer",theCustomer);
		
		//sending to the form
		return "customer-form";
	}
	
	@GetMapping("/Delete")
	public String deleteCustomer(@RequestParam("customerId")int id)
	{
		
		//delete the customer from service
		customerService.deleteCustomer(id);
		
		//after deleting disply the customer list page
		return "redirect:/customer/list";
	
	}
	
	
}

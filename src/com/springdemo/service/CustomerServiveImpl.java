package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiveImpl  implements CustomerService
{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional // using this no need to explicity begin & commit Tx using Session object
	public List<Customer> getCustomers()
	{
		
	    return  customerDAO.getCustomers();	
	}
	
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) 
	{
		
		customerDAO.saveCustomer(theCustomer);
	
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int id)
	{
		
		return customerDAO.getCustomer(id);
	}
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	
	}
	
	
}

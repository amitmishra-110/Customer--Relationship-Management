package com.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImp  implements  CustomerDAO
{
	//injecting dependency of session factory within current class ,as @Repository will create 
	//bean id & autowired will work like inject literal injection
	@Autowired
	private SessionFactory sessionFactory;
	

    @Override
	
   	public List<Customer> getCustomers() 
   {
    	
    	//get Current Hiberante session
    	
    	Session session=sessionFactory.getCurrentSession();
    	
    	//creating a query ,HQL
    	
    	Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
    	
    	//get list of customer from query
    	List<Customer> displayCustomer=query.getResultList();
    	
    	//returning the list
	   return displayCustomer;
   		
   	}	
    @Override
    public void saveCustomer(Customer theCustomer) 
    {
    
    	
    	
    	//get current hibernate session
    	Session session=sessionFactory.getCurrentSession();
    	
    	//save/updating  customer to database
    	session.saveOrUpdate(theCustomer);
    	
    	System.out.println("Customer saved in Database");
 	
    }
    
    @Override
    public Customer getCustomer(int id) 
    {
    	
    	//get current hibernate session
    	Session session=sessionFactory.getCurrentSession();
    	
    	// retreiving customer from database based on primary key id
    	Customer customer=session.get(Customer.class,id);
    	
    
    	return customer;
    }
    
    @Override
    public void deleteCustomer(int id) {
  
    	Session session=sessionFactory.getCurrentSession();
    	
    	//Use of HQL for deleting the customer by ID
    	Query query=session.createQuery("Delete from Customer where id=:theCustomerId");
    	query.setParameter("theCustomerId",id);
    	//works for updates and delete
    	query.executeUpdate();
    }

}

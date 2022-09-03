package com.company.demo;

import java.util.List;

public interface CustomersService {
	
	
	
	
	 public Customers saveCustomers(Customers inv);
	   public Customers updateCustomers(Customers cust, Integer custId);
	    public void deleteCustomers(Integer custId);
	    public Customers getOneCustomers(Integer custId);
	    public List<Customers> getAllCustomers();

}

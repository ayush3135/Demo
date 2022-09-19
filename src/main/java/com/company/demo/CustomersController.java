package com.company.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

@RestController
@Transactional
public class CustomersController {

	
@Autowired
//CustomersService customersService;
CustomersRepo customersRepo;
@RequestMapping("/")
public ModelAndView home() {
	ModelAndView mv = new ModelAndView("home.jsp");
	return mv;
}
	

@RequestMapping("/Customers")
@Cacheable(value="Customers")//working fine
  public List<Customers> allCustomers() {
	//return customersService.getAllCustomers();
	return customersRepo.findAll();
}

@RequestMapping("/addCustomers")
@CachePut(value="Customers", key="#customers.ID")
public Customers addCustomers(Customers customers) {
	//customersService.saveCustomers(customers);
	customersRepo.save(customers);
	return customers;
}


@RequestMapping("/getCustomers")
@Cacheable(value="Customers", key="#ID")
public Customers getCustomers(@RequestParam ("ID") int ID) {	
	 //return customersService.getOneCustomers(ID);
	Customers customers = customersRepo.findById(ID)
	         .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
	return customers;
}	


@RequestMapping("/deleteCustomers")
@CacheEvict(value="Customers", key="#Id", allEntries=true)
public String deleteCustomers(@RequestParam ("ID") int ID) {
	//customersService.deleteCustomers(ID);
	Customers customers = customersRepo.findById(ID)
	           .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
	       customersRepo.delete(customers);
	return "customer deleted";
}

	

}
	
	


	
	

	


	



















package com.company.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableCaching
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
   public List<Customers> allCustomers() {
	//return customersService.getAllCustomers();
	return customersRepo.findAll();
}

@RequestMapping("/addCustomers")
public Customers addCustomers(Customers customers) {
	//customersService.saveCustomers(customers);
	customersRepo.save(customers);
	return customers;
}


@RequestMapping("/getCustomers")
public Customers getCustomers(@RequestParam ("ID") int ID) {	
	 //return customersService.getOneCustomers(ID);
	Customers customers = customersRepo.findById(ID)
	         .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
	return customers;
}	


@RequestMapping("/deleteCustomers")
public String deleteCustomers(@RequestParam ("ID") int ID) {
	//customersService.deleteCustomers(ID);
	Customers customers = customersRepo.findById(ID)
	           .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
	       customersRepo.delete(customers);
	return "customer deleted";
}

	

}
	
	


	
	

	


	



















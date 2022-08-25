package com.company.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomersController {

	
@Autowired
CustomersRepo repo;

@RequestMapping("/")
public ModelAndView home() {
	ModelAndView mv = new ModelAndView("home.jsp");
	return mv;
}
	


@RequestMapping("/Customers")
public List<Customers> allCustomers() {
	return repo.findAll();
}

@RequestMapping("/addCustomers")
public Customers addCustomers(Customers customers) {
	repo.save(customers);
	return customers;
}

@RequestMapping("/getCustomers")

public Optional<Customers> getCustomers(@RequestParam ("ID") int ID){
	System.out.println("hi");	
	 return repo.findById(ID);
	 
}	


@RequestMapping("/deleteCustomers")
public String deleteCustomers(@RequestParam ("ID") int ID) {
	Customers c = repo.getById(ID);
	repo.delete(c);
	return "customer deleted";
}

	

}
	
	


	
	

	


	



















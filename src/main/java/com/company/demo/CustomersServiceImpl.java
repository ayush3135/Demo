package com.company.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepo CustomersRepo;

    
    public Customers saveCustomers(Customers cust) { //working fine

        return CustomersRepo.save(cust);
    }

    
    @CachePut(value="Customers", key="#custId")
    public Customers updateCustomers(Customers cust, Integer custId) {
       Customers Customers = CustomersRepo.findById(custId)
            .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
       Customers.setID(cust.getID());
       Customers.setNAME(cust.getNAME());
       Customers.setADDRESS(cust.getADDRESS());
       Customers.setPHONE(cust.getPHONE());
       return CustomersRepo.save(Customers);
    }

  
    @CacheEvict(value="Customers", key="#custId")//working fine
    // @CacheEvict(value="Customers", allEntries=true) //in case there are multiple entires to delete
    public void deleteCustomers(Integer custId) {
       Customers Customers = CustomersRepo.findById(custId)
           .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
       CustomersRepo.delete(Customers);
    }

    @Cacheable(value="Customers", key="#custId")//working fine
    public Customers getOneCustomers(Integer custId) {//working fine
       Customers Customers = CustomersRepo.findById(custId)
         .orElseThrow(() -> new CustomersNotFoundException("Customers Not Found"));
       return Customers;
    }


    @Cacheable(value="Customers")
    public List<Customers> getAllCustomers() {
       return CustomersRepo.findAll();
    }
}
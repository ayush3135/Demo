package com.company.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CustomersRepo extends JpaRepository<Customers, Integer> {

}

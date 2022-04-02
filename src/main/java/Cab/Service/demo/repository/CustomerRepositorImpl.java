package Cab.Service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Customer;

@Repository
public interface CustomerRepositorImpl extends JpaRepository<Customer, Integer> {
	
	public abstract Customer findByUserName(String userName);
	

	

}

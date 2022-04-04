package Cab.Service.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Cab.Service.demo.model.Customer;

@Repository
public interface CustomerRepositorImpl extends JpaRepository<Customer, Integer> {

	
	public abstract Customer findByUserName(String userName);
	@Transactional
	@Modifying
	@Query(value="delete from customer c where c.customer_id=:Id", nativeQuery=true)
	void deleteCustomerById(@Param("Id") int Id);
	

	

}

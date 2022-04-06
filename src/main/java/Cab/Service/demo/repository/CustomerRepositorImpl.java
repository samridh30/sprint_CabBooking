package Cab.Service.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Cab.Service.demo.dto.Customerdto;
import Cab.Service.demo.model.Customer;

@Repository
public interface CustomerRepositorImpl extends JpaRepository<Customer, Integer> {
//
//	@Query(value = "select * from customer where email = :email", nativeQuery = true)
//	Optional<Customer> findByEmail(@Param("email") String email);

//	public Customer findByEmail(String email);
	public Optional<Customer> findByEmail(String email);

	@Query(value = "select customer_id, user_name from customer", nativeQuery = true)
	public List<Customerdto> findCustomerdto();

//	List<Customer> findByUserName(String userName);

//	@Query(value = "select email from customer where email=:email", nativeQuery = true)
//	Optional<Customer> findByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "delete from customer c where c.customer_id=:Id", nativeQuery = true)
	void deleteCustomerById(@Param("Id") int Id);
	
	

}

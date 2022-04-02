package Cab.Service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Admin;

@Repository
public interface AdminRepositoryImpl extends JpaRepository<Admin, Integer> {

	public abstract Admin findByUserName(String userName);

}

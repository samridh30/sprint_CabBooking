package Cab.Service.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Cab.Service.demo.model.Driver;

public interface IDriverRepository extends JpaRepository<Driver, Integer> {

}

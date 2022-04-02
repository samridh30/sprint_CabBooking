package Cab.Service.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Cab.Service.demo.model.Cab;


@Repository
public interface ICabRepositoryImpl extends JpaRepository<Cab, Integer> {


}

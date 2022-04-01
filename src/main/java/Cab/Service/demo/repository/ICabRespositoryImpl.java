package Cab.Service.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.feb18.spring.cabservice.model.*;
@Repository
public interface ICabRespositoryImpl extends JpaRepository<Cab, Integer> {


}

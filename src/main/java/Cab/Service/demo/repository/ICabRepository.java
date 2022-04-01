package Cab.Service.demo.repository;
import java.util.List;
import cg.feb18.spring.cabservice.model.Cab;
public interface ICabRepository {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(int cab);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
}

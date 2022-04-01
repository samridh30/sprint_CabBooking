package Cab.Service.demo.Service;
import java.util.List;
import cg.feb18.spring.cabservice.model.Cab;
public class ICabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(int cabId);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
}

package Cab.Service.demo.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cg.feb18.spring.cabservice.model.Cab;
import cg.feb18.spring.cabservice.repository.*;
import java.util.List;



@Service
public class CabServiceImpl implements ICabService {
	
	@Autowired
	private ICabRepositoryImpl csRepo;
	
	
	public Cab insertCab(Cab cab) {
		Optional<Cab> cs = csRepo.findById(cab.getCabId());
		if(cs.isPresent()) {
			return null;
		}
		else {
			csRepo.save(cab);
			return cab;
		}
		
		
		public Cab updateCab(Cab cab) {
			Optional<Cab> cs = csRepo.findById(cab.getCabId());
			if(cs.isPresent()) {
				csRepo.save(cab);
				return cab;
			}
			else {
				return null;
			}
			
		
			public Cab deleteCab(int cabId) {
				Optional<Cab> cs = csRepo.findById(cabId);
				if(cs.isPresent()) {
					csRepo.deleteById(cabId);
					return cs.get();
				}
			
				return null;
			}
			
		
			public List<Cab> viewCabsOfType(String carType) {
				List<Cab> cs= csRepo.findAll();
				if(cs.isEmpty()) {
					return null;
				}else {
					return cs;
				}
			}
			
			
			public int countCabsOfType(String carType) {
				
	
	}
		}
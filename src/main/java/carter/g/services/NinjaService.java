package carter.g.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carter.g.models.Ninja;
import carter.g.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	// Initializing the repository
	
	
	public ArrayList<Ninja> getAll(){
		return (ArrayList<Ninja>) ninjaRepository.findAll();
	}
	// Getting all ninjas and returning them
	
	public Ninja getOneById(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		return ninja.isPresent() ? ninja.get() : null;
	}
	// Getting one ninja
	
	public void createNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	// Creating a ninja
	
	public void updateNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	// Updating a ninja
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	// Deleting a ninja
	
}

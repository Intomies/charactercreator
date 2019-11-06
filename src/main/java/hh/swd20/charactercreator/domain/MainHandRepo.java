package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MainHandRepo extends CrudRepository<MainHand, Long> {
	
	List<MainHand> findByName(String name);
	
	

}

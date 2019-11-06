package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OffHandRepo extends CrudRepository<OffHand, Long> {
	
	List<OffHand> findByName(String name);

}

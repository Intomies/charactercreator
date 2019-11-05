package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RaceRepo extends CrudRepository<Race, Long> {

	List<Race> findByName(String name);
	
}

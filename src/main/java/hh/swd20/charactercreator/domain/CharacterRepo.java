package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CharacterRepo extends CrudRepository<Character, Long> {

	List<Character> findByName(String name);
	
}

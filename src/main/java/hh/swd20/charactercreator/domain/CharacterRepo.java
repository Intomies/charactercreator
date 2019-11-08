package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CharacterRepo extends CrudRepository<Character, Long> {

	List<Character> findByName(@Param("name") String name);
	
}

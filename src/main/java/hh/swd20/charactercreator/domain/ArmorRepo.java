package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArmorRepo extends CrudRepository<Armor, Long>{

	List<Armor> findByName(@Param("name") String name);
	
}

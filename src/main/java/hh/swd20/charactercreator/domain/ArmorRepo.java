package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArmorRepo extends CrudRepository<Armor, Long>{

	List<Armor> findByname(String name);
	
}

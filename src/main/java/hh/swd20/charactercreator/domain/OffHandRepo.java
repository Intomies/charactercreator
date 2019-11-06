package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OffHandRepo extends CrudRepository<Offhand, Long> {
	
	List<Offhand> findByName(String name);

}

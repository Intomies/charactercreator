package hh.swd20.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MainHandRepo extends CrudRepository<Mainhand, Long> {
	
	List<Mainhand> findByName(String name);
	
	

}

package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.Race;
import hh.swd20.charactercreator.domain.RaceRepo;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RaceRepoTests {
	@Autowired
	private RaceRepo repo;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void findRaceByNameShouldReturnRace() {
		List<Race> allItems = (List<Race>) repo.findAll();
		List<Race> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}
	
	@Test
	public void saveRace() {
		Race item = new Race("Test", 0, 0, 0, 0, 0, 0, 0, 0, 0);
		em.persistAndFlush(item);
		assertThat(repo.findById(item.getId())).isNotNull();
	}
	
	@Test
	public void deleteRace() {
		em.persistAndFlush(new Race("Test", 0, 0, 0, 0, 0, 0, 0, 0, 0));
		em.persistAndFlush(new Race("Test2", 0, 0, 0, 0, 0, 0, 0, 0, 0));
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}

}

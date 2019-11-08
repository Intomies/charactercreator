package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.RaceRepo;
import hh.swd20.charactercreator.domain.Race;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RaceRepoTests {
	@Autowired
	private RaceRepo repo;
	
	@Test
	public void findRaceByNameShouldReturnRace() {
		List<Race> allItems = (List<Race>) repo.findAll();
		List<Race> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}

}

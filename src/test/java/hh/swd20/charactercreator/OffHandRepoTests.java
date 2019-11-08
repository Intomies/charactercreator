package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.OffHandRepo;
import hh.swd20.charactercreator.domain.OffHand;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OffHandRepoTests {
	@Autowired
	private OffHandRepo repo;
	
	@Test
	public void findOffHandByNameShouldReturnOffHand() {
		List<OffHand> allItems = (List<OffHand>) repo.findAll();
		List<OffHand> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}

}
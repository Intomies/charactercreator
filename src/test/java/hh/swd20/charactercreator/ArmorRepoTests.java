package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.ArmorRepo;
import hh.swd20.charactercreator.domain.Armor;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ArmorRepoTests {
	@Autowired
	private ArmorRepo repo;
	
	@Test
	public void findArmorByNameShouldReturnArmor() {
		List<Armor> allItems = (List<Armor>) repo.findAll();
		List<Armor> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}

}

package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.OffHandRepo;
import hh.swd20.charactercreator.domain.OffHand;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OffHandRepoTests {
	@Autowired
	private OffHandRepo repo;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void findOffHandByNameShouldReturnOffHand() {
		List<OffHand> allItems = (List<OffHand>) repo.findAll();
		List<OffHand> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}
	
	@Test
	public void saveOffHand() {
		OffHand item = new OffHand("Test", 0, 0, 0);
		em.persistAndFlush(item);
		assertThat(repo.findById(item.getId())).isNotNull();
	}
	
	@Test
	public void deleteOffHand() {
		em.persistAndFlush(new OffHand("Test", 0, 0, 0));
		em.persistAndFlush(new OffHand("Test1", 0, 0, 0));
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}

}

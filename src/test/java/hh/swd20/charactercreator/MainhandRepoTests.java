package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.MainHandRepo;
import hh.swd20.charactercreator.domain.MainHand;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MainhandRepoTests {
	@Autowired
	private MainHandRepo repo;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void findMainHandByNameShouldReturnMainHand() {
		List<MainHand> allItems = (List<MainHand>) repo.findAll();
		List<MainHand> items = repo.findByName(allItems.get(0).getName());
		assertThat(items).isNotEmpty();
	}
	
	@Test
	public void saveMainHand() {
		MainHand item = new MainHand("Test", 0, 0, 0);
		em.persistAndFlush(item);
		assertThat(repo.findById(item.getId())).isNotNull();
	}
	
	@Test
	public void deleteMainHand() {
		em.persistAndFlush(new MainHand("Test", 0, 0, 0));
		em.persistAndFlush(new MainHand("Test1", 0, 0, 0));
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}

}

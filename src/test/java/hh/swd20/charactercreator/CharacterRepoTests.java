package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.domain.CharacterRepo;
import hh.swd20.charactercreator.domain.Character;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CharacterRepoTests {
	@Autowired
	private CharacterRepo repo;
	
	@Test
	public void findCharacterByNameShouldReturnCharacter() {
		List<Character> allChars = (List<Character>) repo.findAll();
		List<Character> chars = repo.findByName(allChars.get(0).getName());
		assertThat(chars).isNotEmpty();
	}

}

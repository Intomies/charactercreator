package hh.swd20.charactercreator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.charactercreator.web.charCreatorController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharactercreatorApplicationTests {
	
	@Autowired
	private charCreatorController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}

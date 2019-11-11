package hh.swd20.charactercreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.charactercreator.domain.Armor;
import hh.swd20.charactercreator.domain.ArmorRepo;
import hh.swd20.charactercreator.domain.Character;
import hh.swd20.charactercreator.domain.CharacterRepo;
import hh.swd20.charactercreator.domain.MainHand;
import hh.swd20.charactercreator.domain.MainHandRepo;
import hh.swd20.charactercreator.domain.OffHand;
import hh.swd20.charactercreator.domain.OffHandRepo;
import hh.swd20.charactercreator.domain.Race;
import hh.swd20.charactercreator.domain.RaceRepo;
import hh.swd20.charactercreator.domain.User;
import hh.swd20.charactercreator.domain.UserRepository;

@SpringBootApplication
public class CharactercreatorApplication {

	private static final Logger log = LoggerFactory.getLogger(CharactercreatorApplication.class); // uusi
																									// loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(CharactercreatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner charcreatorCLR(ArmorRepo armorRepo, CharacterRepo charRepo, MainHandRepo mhRepo,
			OffHandRepo ohRepo, RaceRepo raceRepo, UserRepository uRepository) {
		return (args) -> {

			log.info("Create some Armors");
			List<Armor> armorList = new ArrayList<Armor>();
			Armor cloth = new Armor("Cloth armor", 1, 5);
			armorRepo.save(cloth);
			Armor leather = new Armor("Leather armor", 2, 5);
			armorRepo.save(leather);
			Armor copper = new Armor("Copper armor", 3, 4);
			armorRepo.save(copper);

			armorList.add(cloth);
			armorList.add(leather);
			armorList.add(copper);

			log.info("Create some Main-hands");
			List<MainHand> mhList = new ArrayList<MainHand>();
			MainHand mhFist = new MainHand("Fist", 1, 1, 5);
			mhRepo.save(mhFist);
			MainHand mhWoodenStick = new MainHand("Wooden Stick", 2, 2, 4);
			mhRepo.save(mhWoodenStick);
			MainHand copperKnife = new MainHand("Copper Knife", 2, 2, 4);
			mhRepo.save(copperKnife);

			mhList.add(mhFist);
			mhList.add(mhWoodenStick);
			mhList.add(copperKnife);

			log.info("Create some Off-hands");
			List<OffHand> ohList = new ArrayList<OffHand>();
			OffHand ohFist = new OffHand("Fist", 1, 1, 5);
			ohRepo.save(ohFist);
			OffHand woodenBuckler = new OffHand("Wooden Buckler", 2, 5, 2);
			ohRepo.save(woodenBuckler);

			ohList.add(ohFist);
			ohList.add(woodenBuckler);

			log.info("Create Some Races");
			List<Race> raceList = new ArrayList<Race>();
			Race human = new Race("Human", 0, 0, 0, 0, 0, 0, 5, 3, 0);
			raceRepo.save(human);
			Race orc = new Race("Orc", 2, 1, 1, -1, -1, -2, 5, 3, 0);
			raceRepo.save(orc);
			Race dwarf = new Race("Dwarf", 1, -1, 2, 0, 0, 0, 6, 3, 0);
			raceRepo.save(dwarf);

			raceList.add(human);
			raceList.add(orc);
			raceList.add(dwarf);

			log.info("Create some Characters");
			
			for (int i = 0; i <= 3; i++) {
				genRandomChar(charRepo, raceList, armorList, mhList, ohList);
			}

			// Create users: admin/admin user/user
			log.info("create users");
			uRepository.save(new User("user", "user@useremail.com",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			uRepository.save(new User("admin", "admin@bookstore.com",
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));

		};
	}
	
	public void genRandomChar(CharacterRepo charRepo, List<Race> raceList, List<Armor> armorList, List<MainHand> mhList, List<OffHand> ohList) {
		Random ran = new Random();
		
		charRepo.save(new Character(genName() + " " + genName(), ran.nextInt(15) + 3, ran.nextInt(15) + 3,
				ran.nextInt(15) + 3, ran.nextInt(15) + 3, ran.nextInt(15) + 3, ran.nextInt(15) + 3, 0, 0, 0, 0, 0,
				0, 3, raceList.get(ran.nextInt(raceList.size())), armorList.get(ran.nextInt(armorList.size())),
				ohList.get(ran.nextInt(ohList.size())), mhList.get(ran.nextInt(mhList.size()))));
		
	}

	private String genName() {
		log.info("Create name");
		Random ran = new Random();
		String cylls = "ara,gorn,gim,li,grish,nak,boro,mir,fara,lego,las,fro,do,bag,gins"
				+ ",sam,gam,gi,meri,a,doc,ran,di,buk,pe,reg,rin,tuk,gan,dalf,el,rond"
				+ ",dene,thor,eo,wyn,ar,wen,ga,lad,ri,el,gil,gol,lum,tho,rin,bom,ba"
				+ ",dil,tom,lut,hi,en,fi,ki,li,bur,theo,den,bil,bo";
		String[] cyllsList = cylls.split(",");
		String name = cyllsList[ran.nextInt(cyllsList.length)] + cyllsList[ran.nextInt(cyllsList.length)];
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

}

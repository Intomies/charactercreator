package hh.swd20.charactercreator.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller
public class charCreatorController {

	@Autowired
	ArmorRepo armorRepo;

	@Autowired
	CharacterRepo charRepo;

	@Autowired
	MainHandRepo mhRepo;

	@Autowired
	OffHandRepo ohRepo;

	@Autowired
	RaceRepo raceRepo;

	// Login-page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Index-page
	@GetMapping("/")
	public String emptyEndPoint() {
		return "index";
	}

	@GetMapping("/index")
	public String indexPageEndPoint() {
		return "index";
	}

	// List of characters in database
	@GetMapping("/charlist")
	public String getCharacters(Model model) {
		// List<Character> characters = (List<Character>) charRepo.findAll();
		model.addAttribute("characters", charRepo.findAll());
		return "charlist";
	}

	// Empty form for adding a new character
	@GetMapping("/addownchar")
	public String getEmptyCharForm(Model model) {
		model.addAttribute("character", new Character());
		model.addAttribute("races", raceRepo.findAll());
		model.addAttribute("armors", armorRepo.findAll());
		model.addAttribute("mainhands", mhRepo.findAll());
		model.addAttribute("offhands", ohRepo.findAll());
		return "addownchar";
	}

	// Save new character
	@PostMapping("/addownchar")
	public String saveChar(@ModelAttribute Character character) {
		charRepo.save(character);
		return "redirect:/charlist";
	}

	// Edit Character
	@RequestMapping(value = "/editchar/{id}")
	public String editChar(@PathVariable("id") Long charId, Model model) {
		model.addAttribute("character", charRepo.findById(charId));
		model.addAttribute("races", raceRepo.findAll());
		model.addAttribute("armors", armorRepo.findAll());
		model.addAttribute("mainhands", mhRepo.findAll());
		model.addAttribute("offhands", ohRepo.findAll());
		return "editcharform";
	}

	// Delete character from list
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/deletechar/{id}")
	public String deleteChar(@PathVariable("id") Long charId, Model model) {
		charRepo.deleteById(charId);
		return "redirect:../charlist";
	}

	// Restful get all characters
	@GetMapping("/characters")
	public @ResponseBody List<Character> getCharsRest() {
		return (List<Character>) charRepo.findAll();
	}

	// Restful get all races
	@GetMapping("/races")
	public @ResponseBody List<Race> getRacesRest() {
		return (List<Race>) raceRepo.findAll();
	}

	// Restful get all armors
	@GetMapping("/armors")
	public @ResponseBody List<Armor> getArmorsRest() {
		return (List<Armor>) armorRepo.findAll();
	}

	// Restful get all mainhands
	@GetMapping("/mainhands")
	public @ResponseBody List<MainHand> getMainhandsRest() {
		return (List<MainHand>) mhRepo.findAll();
	}

	// Restful get all offhands
	@GetMapping("/offhands")
	public @ResponseBody List<OffHand> getOffhandsRest() {
		return (List<OffHand>) ohRepo.findAll();
	}

	// Restful get character by id
	@GetMapping("/characters/{id}")
	public @ResponseBody Optional<Character> getCharacterRest(@PathVariable("id") Long charId) {
		return charRepo.findById(charId);
	}

	// Restful get race by id
	@GetMapping("/races/{id}")
	public @ResponseBody Optional<Race> getRaceRest(@PathVariable("id") Long raceId) {
		return raceRepo.findById(raceId);
	}

	// Restful get armor by id
	@GetMapping("/armors/{id}")
	public @ResponseBody Optional<Armor> getArmorRest(@PathVariable("id") Long armorId) {
		return armorRepo.findById(armorId);
	}

	// Restful get mainhand by id
	@GetMapping("/mainhands/{id}")
	public @ResponseBody Optional<MainHand> getMainHandRest(@PathVariable("id") Long mhId) {
		return mhRepo.findById(mhId);
	}

	// Restful get offhand by id
	@GetMapping("/offhands/{id}")
	public @ResponseBody Optional<OffHand> getOffHandRest(@PathVariable("id") Long ohId) {
		return ohRepo.findById(ohId);
	}

}

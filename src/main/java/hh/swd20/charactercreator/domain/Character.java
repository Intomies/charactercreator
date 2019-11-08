package hh.swd20.charactercreator.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int str;
	private int dex;
	private int con;
	private int wis;
	private int inte;
	private int cha;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "raceId")
	private Race race;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "armorId")
	private Armor armor;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "offHandId")
	private OffHand offHand;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "mainHandId")
	private MainHand mainHand;

	public Character(Long id, String name, String culture, String gender, int str, int dex, int con, int wis, int inte,
			int cha, Race race, Armor armor, OffHand offHand, MainHand mainHand) {
		super();
		this.id = id;
		this.name = name;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}

	public Character(String name, String culture, String gender, int str, int dex, int con, int wis, int inte,
			int cha, Race race, Armor armor, OffHand offHand, MainHand mainHand) {
		super();
		this.name = name;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}
	
	public Character(String name, int str, int dex, int con, int wis, int inte,
			int cha, int attack, int defence, int armorTotal, int damageTotal, int charHealth, int charSpeed,
			int lowestStatValue, Race race, Armor armor, OffHand offHand, MainHand mainHand) {
		super();
		this.name = name;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}

}

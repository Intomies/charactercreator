package hh.swd20.charactercreator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String culture;
	private String gender;
	private int str;
	private int dex;
	private int con;
	private int wis;
	private int inte;
	private int cha;
	private int attack;
	private int defence;
	private int armorTotal;
	private int damageTotal;
	private int charHealth;
	private int charSpeed;
	private int lowestStatValue;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "raceId")
	private Race race;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "armorId")
	private Armor armor;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "offHandId")
	private Offhand offHand;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "mainHandId")
	private Mainhand mainHand;

	public Character() {
		super();
		this.id = null;
		this.name = null;
		this.culture = null;
		this.gender = null;
		this.str = 0;
		this.dex = 0;
		this.con = 0;
		this.wis = 0;
		this.inte = 0;
		this.cha = 0;
		this.attack = 0;
		this.defence = 0;
		this.armorTotal = 0;
		this.damageTotal = 0;
		this.charHealth = 0;
		this.charSpeed = 0;
		this.lowestStatValue = 0;
		this.race = null;
		this.armor = null;
		this.offHand = null;
		this.mainHand = null;
	}

	public Character(Long id, String name, String culture, String gender, int str, int dex, int con, int wis, int inte,
			int cha, int attack, int defence, int armorTotal, int damageTotal, int charHealth, int charSpeed,
			int lowestStatValue, Race race, Armor armor, Offhand offHand, Mainhand mainHand) {
		super();
		this.id = id;
		this.name = name;
		this.culture = culture;
		this.gender = gender;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.attack = attack;
		this.defence = defence;
		this.armorTotal = armorTotal;
		this.damageTotal = damageTotal;
		this.charHealth = charHealth;
		this.charSpeed = charSpeed;
		this.lowestStatValue = lowestStatValue;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}

	public Character(String name, String culture, String gender, int str, int dex, int con, int wis, int inte,
			int cha, int attack, int defence, int armorTotal, int damageTotal, int charHealth, int charSpeed,
			int lowestStatValue, Race race, Armor armor, Offhand offHand, Mainhand mainHand) {
		super();
		this.name = name;
		this.culture = culture;
		this.gender = gender;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.attack = attack;
		this.defence = defence;
		this.armorTotal = armorTotal;
		this.damageTotal = damageTotal;
		this.charHealth = charHealth;
		this.charSpeed = charSpeed;
		this.lowestStatValue = lowestStatValue;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}
	
	public Character(String name, int str, int dex, int con, int wis, int inte,
			int cha, int attack, int defence, int armorTotal, int damageTotal, int charHealth, int charSpeed,
			int lowestStatValue, Race race, Armor armor, Offhand offHand, Mainhand mainHand) {
		super();
		this.name = name;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.wis = wis;
		this.inte = inte;
		this.cha = cha;
		this.attack = attack;
		this.defence = defence;
		this.armorTotal = armorTotal;
		this.damageTotal = damageTotal;
		this.charHealth = charHealth;
		this.charSpeed = charSpeed;
		this.lowestStatValue = lowestStatValue;
		this.race = race;
		this.armor = armor;
		this.offHand = offHand;
		this.mainHand = mainHand;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public void setArmorTotal(int armorTotal) {
		this.armorTotal = armorTotal;
	}

	public void setDamageTotal(int damageTotal) {
		this.damageTotal = damageTotal;
	}

	public void setCharHealth(int charHealth) {
		this.charHealth = charHealth;
	}

	public void setCharSpeed(int charSpeed) {
		this.charSpeed = charSpeed;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setOffHand(Offhand offHand) {
		this.offHand = offHand;
	}

	public void setMainHand(Mainhand mainHand) {
		this.mainHand = mainHand;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLowestStatValue(int lowestStatValue) {
		this.lowestStatValue = lowestStatValue;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCulture() {
		return culture;
	}

	public int getStr() {
		return str;
	}

	public int getDex() {
		return dex;
	}

	public int getCon() {
		return con;
	}

	public int getWis() {
		return wis;
	}

	public int getInte() {
		return inte;
	}

	public int getCha() {
		return cha;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence + this.mainHand.getDefence() + this.offHand.getDefence();
	}

	public int getArmorTotal() {
		return (armorTotal + getRace().getBasicArmor() + getArmor().getDefenceBuff());
	}

	public int getDamageTotal() {
		return damageTotal + this.mainHand.getDamage() + this.offHand.getDamage();
	}

	public int getCharHealth() {
		return charHealth;
	}

	public int getCharSpeed() {
		return charSpeed;
	}

	public String getGender() {
		return gender;
	}

	public int getLowestStatValue() {
		return lowestStatValue;
	}

	public Race getRace() {
		return race;
	}

	public Armor getArmor() {
		return armor;
	}

	public Offhand getOffHand() {
		return offHand;
	}

	public Mainhand getMainHand() {
		return mainHand;
	}

	@Override
	public String toString() {
		
		if (getCulture() == null && getGender() == null) {
			
			return "Character [id=" + id + ", name=" + name + ", str=" + getStr()
			+ ", dex=" + getDex() + ", con=" + getCon() + ", wis=" + getWis() + ", inte=" + getInte() + ", cha=" + getCha() + ", attack="
			+ getAttack() + ", defence=" + getDefence() + ", armorTotal=" + getArmorTotal() + ", damageTotal=" + getDamageTotal()
			+ ", charHealth=" + getCharHealth() + ", charSpeed=" + getCharSpeed() + ", lowestStatValue=" + lowestStatValue
			+ ", race=" + this.getRace() + ", armor=" + this.getArmor() + ", offHand=" + this.getOffHand() + ", mainHand=" + this.getMainHand() + "]";
			
		} else {
		
		return "Character [id=" + id + ", name=" + name + ", culture=" + culture + ", gender=" + gender + ", str=" + getStr()
				+ ", dex=" + getDex() + ", con=" + getCon() + ", wis=" + getWis() + ", inte=" + getInte() + ", cha=" + getCha() + ", attack="
				+ getAttack() + ", defence=" + getDefence() + ", armorTotal=" + getArmorTotal() + ", damageTotal=" + getDamageTotal()
				+ ", charHealth=" + getCharHealth() + ", charSpeed=" + getCharSpeed() + ", lowestStatValue=" + lowestStatValue
				+ ", race=" + this.getRace() + ", armor=" + this.getArmor() + ", offHand=" + this.getOffHand() + ", mainHand=" + this.getMainHand() + "]";
		}
	}


}

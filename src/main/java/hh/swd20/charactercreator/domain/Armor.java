package hh.swd20.charactercreator.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Armor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int defenceBuff;
	private int speedBuff;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "armor")
	private List<Character> characters;
	
	public Armor() {
		super();
		this.id = null;
		this.name = null;
		this.defenceBuff = 0;
		this.speedBuff = 0;
	}

	
	public Armor(Long id, String name, int defenceBuff, int speedBuff) {
		super();
		this.id = id;
		this.name = name;
		this.defenceBuff = defenceBuff;
		this.speedBuff = speedBuff;
		
	}
	
	public Armor(String name, int defenceBuff, int speedBuff) {
		super();
		this.name = name;
		this.defenceBuff = defenceBuff;
		this.speedBuff = speedBuff;
		
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDefenceBuff(int defenceBuff) {
		this.defenceBuff = defenceBuff;
	}


	public void setSpeedBuff(int speedBuff) {
		this.speedBuff = speedBuff;
	}


	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public int getDefenceBuff() {
		return defenceBuff;
	}


	public int getSpeedBuff() {
		return speedBuff;
	}


	public List<Character> getCharacters() {
		return characters;
	}


	@Override
	public String toString() {
		return "Armor [id=" + id + ", name=" + name + ", defenceBuff=" + defenceBuff + ", speedBuff=" + speedBuff + "]";
	}

}

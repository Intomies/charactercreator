package hh.swd20.charactercreator.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Offhand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int damage;
	private int defence;
	private int speed;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "offHand")
	private List<Character> characters;
	
	public Offhand() {
		super();
		this.id = null;
		this.name = null;
		this.damage = 0;
		this.defence = 0;
		this.speed = 0;
	}
	
	public Offhand(Long id, String name, int damage, int defence, int speed) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.defence = defence;
		this.speed = speed;
	}
	
	public Offhand(String name, int damage, int defence, int speed) {
		super();
		this.name = name;
		this.damage = damage;
		this.defence = defence;
		this.speed = speed;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public void setDefence(int defence) {
		this.defence = defence;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
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


	public int getDamage() {
		return damage;
	}


	public int getDefence() {
		return defence;
	}


	public int getSpeed() {
		return speed;
	}


	public List<Character> getCharacters() {
		return characters;
	}

	@Override
	public String toString() {
		return "OffHand [id=" + id + ", name=" + name + ", damage=" + damage + ", defence=" + defence + ", speed="
				+ speed + "]";
	}	
	
}

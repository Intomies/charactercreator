package hh.swd20.charactercreator.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffHand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int damage;
	private int defence;
	private int speed;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "offHand")
	private List<Character> characters;
	
	public OffHand(Long id, String name, int damage, int defence, int speed) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.defence = defence;
		this.speed = speed;
	}
	
	public OffHand(String name, int damage, int defence, int speed) {
		super();
		this.name = name;
		this.damage = damage;
		this.defence = defence;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "OffHand [id=" + id + ", name=" + name + ", damage=" + damage + ", defence=" + defence + ", speed="
				+ speed + "]";
	}
}

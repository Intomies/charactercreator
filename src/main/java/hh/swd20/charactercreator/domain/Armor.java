package hh.swd20.charactercreator.domain;

import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Armor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int defenceBuff;
	private int speedBuff;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "armor")
	private List<Character> characters;

	
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




}

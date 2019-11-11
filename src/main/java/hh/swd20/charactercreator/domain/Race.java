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
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int buffStr;
	private int buffDex;
	private int buffCon;
	private int buffWis;
	private int buffInte;
	private int buffCha;
	private int mainBasicDamage;
	private int offBasicDamage;
	private int basicArmor;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "race")
	private List<Character> characters;

	public Race(Long id, String name, int buffStr, int buffDex, int buffCon, int buffWis, int buffInte, int buffCha,
			int mainBasicDamage, int offBasicDamage, int basicArmor) {
		super();
		this.id = id;
		this.name = name;
		this.buffStr = buffStr;
		this.buffDex = buffDex;
		this.buffCon = buffCon;
		this.buffWis = buffWis;
		this.buffInte = buffInte;
		this.buffCha = buffCha;
		this.mainBasicDamage = mainBasicDamage;
		this.offBasicDamage = offBasicDamage;
		this.basicArmor = basicArmor;

	}

	public Race(String name, int buffStr, int buffDex, int buffCon, int buffWis, int buffInte, int buffCha,
			int mainBasicDamage, int offBasicDamage, int basicArmor) {
		super();
		this.name = name;
		this.buffStr = buffStr;
		this.buffDex = buffDex;
		this.buffCon = buffCon;
		this.buffWis = buffWis;
		this.buffInte = buffInte;
		this.buffCha = buffCha;
		this.mainBasicDamage = mainBasicDamage;
		this.offBasicDamage = offBasicDamage;
		this.basicArmor = basicArmor;

	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", buffStr=" + buffStr + ", buffDex=" + buffDex + ", buffCon="
				+ buffCon + ", buffWis=" + buffWis + ", buffInte=" + buffInte + ", buffCha=" + buffCha
				+ ", mainBasicDamage=" + mainBasicDamage + ", offBasicDamage=" + offBasicDamage + ", basicArmor="
				+ basicArmor + "]";
	}
}

package hh.swd20.charactercreator.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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

	public Race() {
		super();
		this.id = null;
		this.name = null;
		this.buffStr = 0;
		this.buffDex = 0;
		this.buffCon = 0;
		this.buffWis = 0;
		this.buffInte = 0;
		this.buffCha = 0;
		this.mainBasicDamage = 0;
		this.offBasicDamage = 0;
		this.basicArmor = 0;

	}

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

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBuffStr(int buffStr) {
		this.buffStr = buffStr;
	}

	public void setBuffDex(int buffDex) {
		this.buffDex = buffDex;
	}

	public void setBuffCon(int buffCon) {
		this.buffCon = buffCon;
	}

	public void setBuffWis(int buffWis) {
		this.buffWis = buffWis;
	}

	public void setBuffInte(int buffInte) {
		this.buffInte = buffInte;
	}

	public void setBuffCha(int buffCha) {
		this.buffCha = buffCha;
	}

	public void setMainBasicDamage(int mainBasicDamage) {
		this.mainBasicDamage = mainBasicDamage;
	}

	public void setOffBasicDamage(int offBasicDamage) {
		this.offBasicDamage = offBasicDamage;
	}

	public void setBasicArmor(int basicArmor) {
		this.basicArmor = basicArmor;
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

	public int getBuffStr() {
		return buffStr;
	}

	public int getBuffDex() {
		return buffDex;
	}

	public int getBuffCon() {
		return buffCon;
	}

	public int getBuffWis() {
		return buffWis;
	}

	public int getBuffInte() {
		return buffInte;
	}

	public int getBuffCha() {
		return buffCha;
	}

	public int getMainBasicDamage() {
		return mainBasicDamage;
	}

	public int getOffBasicDamage() {
		return offBasicDamage;
	}

	public int getBasicArmor() {
		return basicArmor;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", buffStr=" + buffStr + ", buffDex=" + buffDex + ", buffCon="
				+ buffCon + ", buffWis=" + buffWis + ", buffInte=" + buffInte + ", buffCha=" + buffCha
				+ ", mainBasicDamage=" + mainBasicDamage + ", offBasicDamage=" + offBasicDamage + ", basicArmor="
				+ basicArmor + "]";
	}
}

package challenge;
import java.util.Date;


public class Jogador {

	private String id;
	private String name;
	private String fullName;
	private String club;
	private Integer age;
	private String nationality;
	private float eur;
	private float eurWage;
	private Date birthDate;

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getFullName() {
		return fullName;
	}

	public final void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public final String getClub() {
		return club;
	}

	public final void setClub(String club) {
		this.club = club;
	}

	public final Integer getAge() {
		return age;
	}

	public final void setAge(int age) {
		this.age = age;
	}

	public final String getNationality() {
		return nationality;
	}

	public final void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public final float getEur() {
		return eur;
	}

	public final void setEur(float eur) {
		this.eur = eur;
	}

	public final float getEurWage() {
		return eurWage;
	}

	public final void setEurWage(float eurWage) {
		this.eurWage = eurWage;
	}

	public final Date getBirthDate() {
		return birthDate;
	}

	public final void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
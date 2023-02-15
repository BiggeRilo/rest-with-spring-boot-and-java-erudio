package br.com.atom.juice.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstname;

	private String lastname;

	private String adress;

	private String gender;

	private Date birthday;

	public PersonVOV2() {
	}

	public PersonVOV2(Long id, String firstname, String lastname, String adress, String gender, Date birthday) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.gender = gender;
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, firstname, gender, id, lastname, birthday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVOV2 other = (PersonVOV2) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(birthday, other.birthday);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return adress;
	}

	public void setAddress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}

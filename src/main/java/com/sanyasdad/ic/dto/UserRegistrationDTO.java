package com.sanyasdad.ic.dto;

import javax.validation.constraints.NotEmpty;

import com.sanyasdada.ic.Validator.Age;

public class UserRegistrationDTO {

	@NotEmpty(message= "{string.notEmpty}")
	private String name;
	
	
	private String userName;
	private char[] password;
	private String countryName;
	private String[] hobbies;
	private String gender;
    // if we aren't defined any lower, upper and message default value will be work
	@Age(lower = 30, upper = 75)
	private Integer age;

	private CommunicationDTO communicationDTO;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

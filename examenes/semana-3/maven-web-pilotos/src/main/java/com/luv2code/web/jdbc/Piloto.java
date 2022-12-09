package com.luv2code.web.jdbc;

public class Piloto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String team;

	public Piloto(String firstName, String lastName, String email, String team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.team = team;
	}

	public Piloto(int id, String firstName, String lastName, String email, String team) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Piloto{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", team='" + team + '\'' +
				'}';
	}
}

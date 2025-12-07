package com.wipro;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id; // simple id (could be UUID)
	private String name;
	private String email;
	private String phone;
	private String notes;

	public Contact() {
	}

	public Contact(String id, String name, String email, String phone, String notes) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
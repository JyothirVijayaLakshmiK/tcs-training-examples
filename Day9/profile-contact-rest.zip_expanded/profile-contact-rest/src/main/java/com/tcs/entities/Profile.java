package com.tcs.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	private LocalDate dob; 
	
	@Column(name = "phone")
	private long phoneNo;
	
	// create a List<Contact> that is mapped to the Profile
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id") 
	// maps the primary key of Profile to the foreign key of Contact, profile_id is foreign key column name
	private List<Contact> contactsList;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Contact> getContactsList() {
		return contactsList;
	}

	public void setContactsList(List<Contact> contactsList) {
		this.contactsList = contactsList;
	}
	
}

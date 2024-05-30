package com.insurance.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String mobileNumber;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_policies", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "policy_no"))
	private List<Policy> policylist;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_nominee", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "nominee_id"))
	private List<Nominee> nomineelist;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_premiium", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "premium_id"))
	private List<Premium> premiumlist;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Policy> getPolicylist() {
		return policylist;
	}

	public void setPolicylist(List<Policy> policylist) {
		this.policylist = policylist;
	}

	public List<Nominee> getNomineelist() {
		return nomineelist;
	}

	public void setNomineelist(List<Nominee> nomineelist) {
		this.nomineelist = nomineelist;
	}

	public List<Premium> getPremiumlist() {
		return premiumlist;
	}

	public void setPremiumlist(List<Premium> premiumlist) {
		this.premiumlist = premiumlist;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", email=" + email + ", mobileNumber=" + mobileNumber + ", policylist="
				+ policylist + ", nomineelist=" + nomineelist + ", premiumlist=" + premiumlist + "]";
	}

}

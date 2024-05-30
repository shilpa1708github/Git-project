package com.insurance.response;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.model.Nominee;
import com.insurance.model.Policy;
import com.insurance.model.Premium;

@ResponseBody
public class UserResponse {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private List<Policy> policylist;
	private List<Nominee> nomineelist;
	private List<Premium> premiumlist;

	public UserResponse(String string) {
		// TODO Auto-generated constructor stub
	}

	public UserResponse() {

	}

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
		return "UserRequest [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", policylist=" + policylist + ", nomineelist=" + nomineelist
				+ ", premiumlist=" + premiumlist + "]";
	}

}

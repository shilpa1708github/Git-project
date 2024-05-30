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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long policyId;
	private String policyName;
	private String policyStatus;

	@ManyToMany (mappedBy = "policylist")
	private List<User> users;
	
	
	public Policy() {
		super();
	}
	
	
	public Policy(long policyId, String policyName) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
	}



	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyStatus=" + policyStatus
				+ "]";
	}
	
	
//	@OneToOne(targetEntity = Premium.class, cascade = CascadeType.ALL)
//	//@JoinTable(name = "policies_premium", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "premium_id"))
//	private Premium premium;
	
	
	
	
}

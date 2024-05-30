package com.insurance.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Premium {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long primiumId;
	private long premiumAmount;
	private String paymentFrequency;
	private String dueDate;
	private String paymentMethod;
	private String paymentStatus;
	private String coveragePeriod;
	@ManyToMany (mappedBy="premiumlist")
	private List<User> user;
	
	
	public Premium() {
		super();
	}

	public Premium(long primiumId, String paymentFrequency, String paymentMethod) {
		super();
		this.primiumId = primiumId;
		this.paymentFrequency = paymentFrequency;
		this.paymentMethod = paymentMethod;
	}

	public long getPrimiumId() {
		return primiumId;
	}
	public void setPrimiumId(long primiumId) {
		this.primiumId = primiumId;
	}
	public long getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(long premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getCoveragePeriod() {
		return coveragePeriod;
	}
	public void setCoveragePeriod(String coveragePeriod) {
		this.coveragePeriod = coveragePeriod;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Premium [primiumId=" + primiumId + ", premiumAmount=" + premiumAmount + ", paymentFrequency="
				+ paymentFrequency + ", dueDate=" + dueDate + ", paymentMethod=" + paymentMethod + ", paymentStatus="
				+ paymentStatus + ", coveragePeriod=" + coveragePeriod + ", user=" + user + "]";
	}
	
	
}

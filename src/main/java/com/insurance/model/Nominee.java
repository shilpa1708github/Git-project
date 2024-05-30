package com.insurance.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Nominee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nomineeid;
	private String nomineeName;
	private int nomineeAge;
	private String relation;
	
	public Nominee() {
		super();
	}

	

	public Nominee(long nomineeid, String nomineeName, int nomineeAge, String relation) {
		super();
		this.nomineeid = nomineeid;
		this.nomineeName = nomineeName;
		this.nomineeAge = nomineeAge;
		this.relation = relation;
	}



	@ManyToMany (mappedBy = "nomineelist")
	private List<User> user;

	public long getNomineeid() {
		return nomineeid;
	}

	public void setNomineeid(long nomineeid) {
		this.nomineeid = nomineeid;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public int getNomineeAge() {
		return nomineeAge;
	}

	public void setNomineeAge(int nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Nominee [nomineeid=" + nomineeid + ", nomineeName=" + nomineeName + ", nomineeAge=" + nomineeAge
				+ ", relation=" + relation + ", user=" + user + "]";
	}
	
	
	
	
	

}

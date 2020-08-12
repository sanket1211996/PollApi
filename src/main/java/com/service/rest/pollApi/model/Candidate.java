package com.service.rest.pollApi.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate  implements Comparable<Candidate>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;	
	String name;
	Long numChallenge;
	String expertise;
	Long votes;
	Long expLevel;
	
	
	public Long getExpLevel() {
		return expLevel;
	}



	public void setExpLevel(Long expLevel) {
		this.expLevel = expLevel;
	}



	public Candidate() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumChallenge() {
		return numChallenge;
	}

	public void setNumChallenge(Long numChallenge) {
		this.numChallenge = numChallenge;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Candidate(String name, Long numChallenge, String expertise, Long expLevel) {
		this.name = name;
		this.numChallenge = numChallenge;
		this.expertise = expertise;
		this.expLevel = expLevel;
		this.votes = 0L;
	}



	@Override
	public int compareTo(Candidate o) {
		
		return (int) (this.id - o.getId());
	}
	
	
	public static Comparator<Candidate> votesComparator = new Comparator<Candidate>() {
		
		@Override
		public int compare(Candidate o1, Candidate o2) {
			
			return (int) (o1.getVotes() - o2.getVotes());
		}
	};
	
}

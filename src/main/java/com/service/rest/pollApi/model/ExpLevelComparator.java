package com.service.rest.pollApi.model;

import java.util.Comparator;

public class ExpLevelComparator implements Comparator<Candidate>{

	@Override
	public int compare(Candidate o1, Candidate o2) {
		return (int) (o1.getExpLevel() - o2.getExpLevel());
	}

}

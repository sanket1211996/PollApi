package com.service.rest.pollApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.rest.pollApi.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

	List<Candidate> findByNameContaining(String name);

}

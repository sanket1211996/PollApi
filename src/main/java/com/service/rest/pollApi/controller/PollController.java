package com.service.rest.pollApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.rest.pollApi.model.Candidate;
import com.service.rest.pollApi.model.Shape;
import com.service.rest.pollApi.repository.CandidateRepository;

@CrossOrigin(origins = "http://pollingangular.s3-website.us-east-2.amazonaws.com")
@RestController
@RequestMapping("/api")
public class PollController {

	@Autowired
	CandidateRepository candidateRepository;
	
	
	@Autowired
	Shape shape;
	
	@RequestMapping("/")
	public  String welcome() {
		return "pollingApi is Live with shape: " + shape.getShapeName();
	}

	@GetMapping("/candidates")
	public ResponseEntity<List<Candidate>> getAllcandidates(@RequestParam(required = false) String name) {

		List<Candidate> candidates = new ArrayList<>();

		try {

			if (null == name) {
				candidates.addAll(candidateRepository.findAll());
			} else {
				candidates.addAll(candidateRepository.findByNameContaining(name));
			}

			if (candidates.isEmpty()) {
				return new ResponseEntity<>(candidates, HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(candidates, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(candidates, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/candidates/{id}")
	public ResponseEntity<Candidate> findById(@PathVariable long id) {

		Optional<Candidate> tuOptional = candidateRepository.findById(id);
		if (tuOptional.isPresent()) {
			return new ResponseEntity<>(tuOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/candidates")
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate Candidate) {
		try {

			Candidate = candidateRepository.save(Candidate);
			return new ResponseEntity<Candidate>(Candidate, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/candidates/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable long id, @RequestBody Candidate candidate) {

		try {
			Optional<Candidate> optCandidate = candidateRepository.findById(id);
			if (optCandidate.isPresent()) {
				Candidate _candidate = optCandidate.get();
				_candidate.setName(candidate.getName());
				_candidate.setNumChallenge(candidate.getNumChallenge());
				_candidate.setExpertise(candidate.getExpertise());
				_candidate.setExpLevel(candidate.getExpLevel());
				_candidate.setVotes(candidate.getVotes());
				return new ResponseEntity<>(candidateRepository.save(_candidate), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Candidate>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/candidates/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
		try {
			candidateRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/candidates")
	public ResponseEntity<HttpStatus> deleteAll() {
		try {
			candidateRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/adminAuth") 
	public ResponseEntity<HttpStatus> authenticate(@RequestBody String authKey) {

		
		if(authKey.equals("hackerearth") ) { 
			return new ResponseEntity<>(HttpStatus.OK); 
		} 
		else { 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		 
		
	}
}

package com.mlc.portfolio.controllers;

import com.mlc.portfolio.models.Identity;
import com.mlc.portfolio.models.Projekt;
import com.mlc.portfolio.models.Skill;
import com.mlc.portfolio.repository.IdentityRepository;
import com.mlc.portfolio.repository.ProjektRepository;
import com.mlc.portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/acces")
public class AccesController {

	@Autowired
	private IdentityRepository identityRepository;

	@Autowired
	private ProjektRepository projektRepository;

	@Autowired
	private SkillRepository skillRepository;

	@GetMapping("/all")
	public ResponseEntity<?> allAccess() {
		Identity identity = identityRepository.findFirstById(1);
		List <Projekt> projekts = projektRepository.findAll();
		List <Skill> skills = skillRepository.findAll();
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("identity", identity);
		result.put ("projekts", projekts);
		result.put ("skills", skills);
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "image_1.jpg";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}

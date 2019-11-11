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
import org.springframework.web.bind.annotation.*;

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
		Map<String, Object> result = new HashMap<>();
		result.put("identity", identity);
		result.put ("projekts", projekts);
		result.put ("skills", skills);
		return new ResponseEntity<>(result, HttpStatus.OK);
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

	//Methodes Skill
	@GetMapping("/getSkills")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getSkills() {
		List <Skill> skills = skillRepository.findAll();
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}

	@PostMapping("/newSkill")
    public ResponseEntity<?> postSkill(@RequestParam String Titre,
                                      @RequestParam String Description){
	    Skill newSkill = new Skill();
	    newSkill.setTitre(Titre);
	    newSkill.setDescription(Description);
	    skillRepository.save(newSkill);
	    return new ResponseEntity<>(newSkill, HttpStatus.OK);
    }

	@PutMapping("/putSkill")
    public ResponseEntity<?> updateSkill(@RequestParam int id,
                                         @RequestParam String Titre,
                                         @RequestParam String Description) {
        Skill updateSkill = skillRepository.findById(id);
        if (updateSkill != null) {
           updateSkill.setTitre(Titre);
            updateSkill.setDescription(Description);
            skillRepository.save(updateSkill);
        }
        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }

    @GetMapping("/deleteSkill")
    public ResponseEntity<?> deleteSkill(@RequestParam int id) {
        Skill deleteSkill = skillRepository.findById(id);
        if (deleteSkill != null) {
            skillRepository.delete(deleteSkill);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

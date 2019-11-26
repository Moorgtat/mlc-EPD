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

	//Methode Identité
	@GetMapping("/getIdentity")
	public ResponseEntity<?> getIdentity() {
		List <Identity> identities = identityRepository.findAll();
		return new ResponseEntity<>(identities, HttpStatus.OK);
	}

	@PutMapping("/putIdentity")
	public ResponseEntity<?> updateIdentity( @RequestParam String name,
										     @RequestParam String poste,
											 @RequestParam String presentation,
											 @RequestParam String mail,
											 @RequestParam String git,
											 @RequestParam String twitter) {
		Identity updateIdentity = identityRepository.findFirstById(1);
		if (updateIdentity != null) {
			updateIdentity.setName(name);
			updateIdentity.setPoste(poste);
			updateIdentity.setPresentation(presentation);
			updateIdentity.setMail(mail);
			updateIdentity.setGit(git);
			updateIdentity.setTwitter(twitter);
			identityRepository.save(updateIdentity);
		}
		return new ResponseEntity<>(updateIdentity, HttpStatus.OK);
	}

	//Methodes Compétences
	@GetMapping("/getSkills")
	public ResponseEntity<?> getSkills() {
		List <Skill> skills = skillRepository.findAll();
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}

	@PostMapping("/newSkill")
    public ResponseEntity<?> postSkill(@RequestParam String titre,
                                       @RequestParam String description,
									   @RequestParam String type,
									   @RequestParam String logo){
	    Skill newSkill = new Skill();
	    newSkill.setTitre(titre);
	    newSkill.setDescription(description);
		newSkill.setType(type);
		newSkill.setLogo(logo);
	    skillRepository.save(newSkill);
	    return new ResponseEntity<>(newSkill, HttpStatus.OK);
    }

	@PutMapping("/putSkill")
    public ResponseEntity<?> updateSkill(@RequestParam int id,
                                         @RequestParam String titre,
                                         @RequestParam String description,
										 @RequestParam String type,
										 @RequestParam String logo) {
        Skill updateSkill = skillRepository.findById(id);
        if (updateSkill != null) {
           updateSkill.setTitre(titre);
            updateSkill.setDescription(description);
			updateSkill.setType(type);
			updateSkill.setLogo(logo);
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

    // Méthodes Projekt
    @GetMapping("/getProjekts")
    public ResponseEntity<?> getProjekts(){
	    List <Projekt> projekts = projektRepository.findAll();
	    return new ResponseEntity<>(projekts, HttpStatus.OK);
    }

    @PostMapping("/newProjekt")
    public ResponseEntity<?> postProjekt(@RequestParam String titre,
                                         @RequestParam String description,
                                         @RequestParam String github,
										 @RequestParam String slide_1,
										 @RequestParam String slide_2,
										 @RequestParam String slide_3) {
	    Projekt newProjekt = new Projekt();
	    newProjekt.setTitre(titre);
	    newProjekt.setDescription(description);
	    newProjekt.setGithub(github);
		newProjekt.setSlide_1(slide_1);
		newProjekt.setSlide_2(slide_2);
		newProjekt.setSlide_3(slide_3);
	    projektRepository.save(newProjekt);
	    return new ResponseEntity<>(newProjekt, HttpStatus.OK);
    }

    @PutMapping("/putProjekt")
    public  ResponseEntity<?> updateProjekt(@RequestParam int id,
                                            @RequestParam String titre,
                                            @RequestParam String description,
                                            @RequestParam String github,
											@RequestParam String slide_1,
											@RequestParam String slide_2,
											@RequestParam String slide_3) {
	    Projekt updateProjekt = projektRepository.findById(id);
        if (updateProjekt != null) {
            updateProjekt.setTitre(titre);
            updateProjekt.setDescription(description);
            updateProjekt.setGithub(github);
			updateProjekt.setSlide_1(slide_1);
			updateProjekt.setSlide_2(slide_2);
			updateProjekt.setSlide_3(slide_3);
            projektRepository.save(updateProjekt);
        }
        return new ResponseEntity<>(updateProjekt, HttpStatus.OK);
    }

    @GetMapping("/deleteProjekt")
    public ResponseEntity<?> deleteProjekt(@RequestParam int id) {
        Projekt deleteProjekt = projektRepository.findById(id);
        if (deleteProjekt != null) {
            projektRepository.delete(deleteProjekt);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.mlc.portfolio;

//import com.mlc.portfolio.models.Identity;
//import com.mlc.portfolio.models.Projekt;
//import com.mlc.portfolio.models.Skill;
//import com.mlc.portfolio.repository.IdentityRepository;
//import com.mlc.portfolio.repository.ProjektRepository;
//import com.mlc.portfolio.repository.SkillRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPortfolioApplication implements CommandLineRunner{

//	@Autowired
//	private IdentityRepository identityRepository;
//
//	@Autowired
//	private ProjektRepository projektRepository;
//
//	@Autowired
//	private SkillRepository skillRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPortfolioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Identity identity1 = identityRepository.save(new Identity("Mathieu Le Cardinal",
//				"Developpeur Full Stack",
//				"mat.lecardinal@gmail.com",
//				"github",
//				"twitter",
//				"Mes objectifs",
//				"Description objectifs."));
//
//		Skill skill1 = skillRepository.save(new Skill("Titre Skill1",
//				"Description Skill1 Lorem ipsum dolor sit amet, ipsum dolor sit amet, ipsum dolor sit amet.",
//				"null",
//				"null",
//				"null",
//				"null"));
//
//		Skill skill2 = skillRepository.save(new Skill("Titre Skill2",
//				"Description Skill2  Lorem ipsum dolor sit amet, ipsum dolor sit amet, ipsum dolor sit amet.",
//				"null",
//				"null",
//				"null",
//				"null"));
//
//		Projekt projekt1 = projektRepository.save(new Projekt("Projet 1",
//				"Description Projet 1",
//				"lien GitHub",
//				"null",
//				"null",
//				"null"));
//
//		Projekt projekt2 = projektRepository.save(new Projekt("Projet 2",
//				"Description Projet 2",
//				"lien GitHub",
//				"null",
//				"null",
//				"null"));
//
//		Projekt projekt3 = projektRepository.save(new Projekt("Projet 3",
//				"Description Projet 3",
//				"lien GitHub",
//				"null",
//				"null",
//				"null"));
//
//		Projekt projekt4 = projektRepository.save(new Projekt("Projet 4",
//				"Description Projet 4",
//				"lien GitHub",
//				"null",
//				"null",
//				"null"));
	}

}

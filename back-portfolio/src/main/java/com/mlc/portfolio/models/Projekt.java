package com.mlc.portfolio.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projekts")
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 30)
    private String titre;
    @NotBlank
    @Size(max = 500)
    private String description;
    @NotBlank
    @Size(max = 30)
    private String github;
    @NotBlank
    @Size(max = 30)
    private String slide_1;
    @NotBlank
    @Size(max = 30)
    private String slide_2;
    @NotBlank
    @Size(max = 30)
    private String slide_3;

    public Projekt() {
    }

    public Projekt(@NotBlank @Size(max = 30) String titre, @NotBlank @Size(max = 500) String description, @NotBlank @Size(max = 30) String github, @NotBlank @Size(max = 30) String slide_1, @NotBlank @Size(max = 30) String slide_2, @NotBlank @Size(max = 30) String slide_3) {
        this.titre = titre;
        this.description = description;
        this.github = github;
        this.slide_1 = slide_1;
        this.slide_2 = slide_2;
        this.slide_3 = slide_3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getSlide_1() {
        return slide_1;
    }

    public void setSlide_1(String slide_1) {
        this.slide_1 = slide_1;
    }

    public String getSlide_2() {
        return slide_2;
    }

    public void setSlide_2(String slide_2) {
        this.slide_2 = slide_2;
    }

    public String getSlide_3() {
        return slide_3;
    }

    public void setSlide_3(String slide_3) {
        this.slide_3 = slide_3;
    }
}

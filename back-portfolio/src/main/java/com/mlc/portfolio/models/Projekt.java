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

    public Projekt() {
    }

    public Projekt(@NotBlank @Size(max = 30) String titre, @NotBlank @Size(max = 500) String description, @NotBlank @Size(max = 30) String github) {
        this.titre = titre;
        this.description = description;
        this.github = github;
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
}

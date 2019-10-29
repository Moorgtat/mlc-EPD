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
    @Size(max = 200)
    private String description;
    @NotBlank
    @Size(max = 30)
    private String github;
    @Size(max = 40)
    private String image_1;
    @Size(max = 40)
    private String image_2;
    @Size(max = 40)
    private String image_3;

    public Projekt() {
    }

    public Projekt(@NotBlank @Size(max = 30) String titre, @NotBlank @Size(max = 200) String description, @NotBlank @Size(max = 30) String github, @Size(max = 40) String image_1, @Size(max = 40) String image_2, @Size(max = 40) String image_3) {
        this.titre = titre;
        this.description = description;
        this.github = github;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
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

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }
}

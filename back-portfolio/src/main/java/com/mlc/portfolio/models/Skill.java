package com.mlc.portfolio.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "skills")
public class Skill {
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
    private String type;
    @NotBlank
    @Size(max = 30)
    private String logo;

    public Skill() {
    }

    public Skill(@NotBlank @Size(max = 30) String titre, @NotBlank @Size(max = 500) String description, @NotBlank @Size(max = 30) String type, @NotBlank @Size(max = 30) String logo) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.logo = logo;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

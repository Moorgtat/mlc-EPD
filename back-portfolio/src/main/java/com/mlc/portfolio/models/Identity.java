package com.mlc.portfolio.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "identity")
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 30)
    private String name;
    @NotBlank
    @Size(max = 30)
    private String poste;
    @NotBlank
    @Size(max = 50)
    @Email
    private String mail;
    @NotBlank
    @Size(max = 20)
    private String lien_git;
    @NotBlank
    @Size(max = 20)
    private String lien_twitter;
    @NotBlank
    @Size(max = 20)
    private String objectif_titre;
    @NotBlank
    @Size(max = 200)
    private String objectif_description;

    public Identity() {
    }

    public Identity(@NotBlank @Size(max = 30) String name, @NotBlank @Size(max = 30) String poste, @NotBlank @Size(max = 50) @Email String mail, @NotBlank @Size(max = 20) String lien_git, @NotBlank @Size(max = 20) String lien_twitter, @NotBlank @Size(max = 20) String objectif_titre, @NotBlank @Size(max = 200) String objectif_description) {
        this.name = name;
        this.poste = poste;
        this.mail = mail;
        this.lien_git = lien_git;
        this.lien_twitter = lien_twitter;
        this.objectif_titre = objectif_titre;
        this.objectif_description = objectif_description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLien_git() {
        return lien_git;
    }

    public void setLien_git(String lien_git) {
        this.lien_git = lien_git;
    }

    public String getLien_twitter() {
        return lien_twitter;
    }

    public void setLien_twitter(String lien_twitter) {
        this.lien_twitter = lien_twitter;
    }

    public String getObjectif_titre() {
        return objectif_titre;
    }

    public void setObjectif_titre(String objectif_titre) {
        this.objectif_titre = objectif_titre;
    }

    public String getObjectif_description() {
        return objectif_description;
    }

    public void setObjectif_description(String objectif_description) {
        this.objectif_description = objectif_description;
    }
}

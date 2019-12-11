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
    @Size(max = 500)
    private String presentation;
    @NotBlank
    @Size(max = 50)
    @Email
    private String mail;
    @NotBlank
    @Size(max = 40)
    private String git;
    @NotBlank
    @Size(max = 40)
    private String twitter;
    @NotBlank
    @Size(max = 40)
    private String titreprojet;
    @NotBlank
    @Size(max = 40)
    private String lienbouton;
    @NotBlank
    @Size(max = 40)
    private String lienphotoprofil;
    @NotBlank
    @Size(max = 300)
    private String texteapplat;
    @NotBlank
    @Size(max = 300)
    private String texteform;

    public Identity() {
    }

    public Identity(@NotBlank @Size(max = 30) String name, @NotBlank @Size(max = 30) String poste, @NotBlank @Size(max = 500) String presentation, @NotBlank @Size(max = 50) @Email String mail, @NotBlank @Size(max = 40) String git, @NotBlank @Size(max = 40) String twitter, String titreprojet, @Size(max = 50) @Email String lienbouton, @NotBlank @Size(max = 40) String lienphotoprofil, @NotBlank @Size(max = 300) String texteapplat, @NotBlank @Size(max = 300) String texteform) {
        this.name = name;
        this.poste = poste;
        this.presentation = presentation;
        this.mail = mail;
        this.git = git;
        this.twitter = twitter;
        this.titreprojet = titreprojet;
        this.lienbouton = lienbouton;
        this.lienphotoprofil = lienphotoprofil;
        this.texteapplat = texteapplat;
        this.texteform = texteform;
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

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTitreprojet() {
        return titreprojet;
    }

    public void setTitreprojet(String titreprojet) {
        this.titreprojet = titreprojet;
    }

    public String getLienbouton() {
        return lienbouton;
    }

    public void setLienbouton(String lienbouton) {
        this.lienbouton = lienbouton;
    }

    public String getLienphotoprofil() {
        return lienphotoprofil;
    }

    public void setLienphotoprofil(String lienphotoprofil) {
        this.lienphotoprofil = lienphotoprofil;
    }

    public String getTexteapplat() {
        return texteapplat;
    }

    public void setTexteapplat(String texteapplat) {
        this.texteapplat = texteapplat;
    }

    public String getTexteform() {
        return texteform;
    }

    public void setTexteform(String texteform) {
        this.texteform = texteform;
    }
}

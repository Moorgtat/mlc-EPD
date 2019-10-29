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
    @Size(max = 200)
    private String description;
    @Size(max = 40)
    private String image_1;
    @Size(max = 40)
    private String image_2;
    @Size(max = 40)
    private String image_3;
    @Size(max = 40)
    private String image_4;

    public Skill() {
    }

    public Skill(@NotBlank @Size(max = 30) String titre, @NotBlank @Size(max = 200) String description, @Size(max = 40) String image_1, @Size(max = 40) String image_2, @Size(max = 40) String image_3, @Size(max = 40) String image_4) {
        this.titre = titre;
        this.description = description;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;
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

    public String getImage_4() {
        return image_4;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }
}

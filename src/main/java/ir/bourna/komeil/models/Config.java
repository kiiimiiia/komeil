package ir.bourna.komeil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "config")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;
    @Column(name = "about_us_part_one")
    private String aboutUsPartOne;
    @Column(name = "about_us_part_two")
    private String aboutUsPartTwo;
    @Column(name = "descriptionMetatag")
    private String descriptionMetatag;
    @Column(name = "canonicalMetatag")
    private String canonicalMetatag;
    @Column(name = "titleMetatag")
    private String titleMetatag;
    public Config() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutUsPartOne() {
        return aboutUsPartOne;
    }

    public void setAboutUsPartOne(String aboutUsPartOne) {
        this.aboutUsPartOne = aboutUsPartOne;
    }

    public String getAboutUsPartTwo() {
        return aboutUsPartTwo;
    }

    public void setAboutUsPartTwo(String aboutUsPartTwo) {
        this.aboutUsPartTwo = aboutUsPartTwo;
    }

    public String getDescriptionMetatag() {
        return descriptionMetatag;
    }

    public void setDescriptionMetatag(String descriptionMetatag) {
        this.descriptionMetatag = descriptionMetatag;
    }

    public String getCanonicalMetatag() {
        return canonicalMetatag;
    }

    public void setCanonicalMetatag(String canonicalMetatag) {
        this.canonicalMetatag = canonicalMetatag;
    }

    public String getTitleMetatag() {
        return titleMetatag;
    }

    public void setTitleMetatag(String titleMetatag) {
        this.titleMetatag = titleMetatag;
    }
}

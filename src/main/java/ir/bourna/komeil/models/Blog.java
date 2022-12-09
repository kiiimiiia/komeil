package ir.bourna.komeil.models;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Long created_at;
    @Column(name = "updated_at")
    private Long updated_at;
    @Column(name = "topic")
    private String topic;
    @Column(name = "description")
    private String description;
    @Column(name = "primary_image_url")
    private String imageurl;
@Column(name = "enable")
private boolean enable;
    @Column(name = "firstadditionalimage")
    private String firstadditionalimage;

    @Column(name = "secondadditionalimage")
    private String secondadditionalimage;

    @Column(name = "thirdadditionalimage")
    private String thirdadditionalimage;

    @Column(name = "descriptionMetatag")
    private String descriptionMetatag;
    @Column(name = "canonicalMetatag")
    private String canonicalMetatag;
    @Column(name = "titleMetatag")
    private String titleMetatag;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public Long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Long updated_at) {
        this.updated_at = updated_at;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getFirstadditionalimage() {
        return firstadditionalimage;
    }

    public void setFirstadditionalimage(String firstadditionalimage) {
        this.firstadditionalimage = firstadditionalimage;
    }

    public String getSecondadditionalimage() {
        return secondadditionalimage;
    }

    public void setSecondadditionalimage(String secondadditionalimage) {
        this.secondadditionalimage = secondadditionalimage;
    }

    public String getThirdadditionalimage() {
        return thirdadditionalimage;
    }

    public void setThirdadditionalimage(String thirdadditionalimage) {
        this.thirdadditionalimage = thirdadditionalimage;
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

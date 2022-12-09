package ir.bourna.komeil.DTO.Request;


public class NewsRequestDTO {
    private String topic;
    private String description;
    private String imageurl;
    private String firstadditionalimage;
    private String secondadditionalimage;
    private String thirdadditionalimage;
    private String descriptionMetatag;
    private String canonicalMetatag;
    private String titleMetatag;
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

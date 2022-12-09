package ir.bourna.komeil.DTO.Request;

public class ConfigRequestDTO {
    String partoneaboutus;
    String parttwoaboutus;
    String descriptionMetaTag;
    String canonicalMetatag;
    String titleMetatag;
    public String getPartoneaboutus() {
        return partoneaboutus;
    }

    public void setPartoneaboutus(String partoneaboutus) {
        this.partoneaboutus = partoneaboutus;
    }

    public String getParttwoaboutus() {
        return parttwoaboutus;
    }

    public void setParttwoaboutus(String parttwoaboutus) {
        this.parttwoaboutus = parttwoaboutus;
    }

    public String getDescriptionMetaTag() {
        return descriptionMetaTag;
    }

    public void setDescriptionMetaTag(String descriptionMetaTag) {
        this.descriptionMetaTag = descriptionMetaTag;
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

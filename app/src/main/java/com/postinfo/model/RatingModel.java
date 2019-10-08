package com.postinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingModel {

    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("proportion")
    @Expose
    private Double proportion;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public RatingModel withLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RatingModel withValue(Integer value) {
        this.value = value;
        return this;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public RatingModel withCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public RatingModel withProportion(Double proportion) {
        this.proportion = proportion;
        return this;
    }
}

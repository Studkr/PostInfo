package com.postinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarImage {

    @SerializedName("url_medium")
    @Expose
    private String urlMedium;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_large")
    @Expose
    private String urlLarge;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;
    @SerializedName("url_origin")
    @Expose
    private String urlOrigin;
    @SerializedName("url_medium_origin")
    @Expose
    private String urlMediumOrigin;
    @SerializedName("url_large_origin")
    @Expose
    private String urlLargeOrigin;
    @SerializedName("url_small_origin")
    @Expose
    private String urlSmallOrigin;
    @SerializedName("mentioned_users_count")
    @Expose
    private Integer mentionedUsersCount;

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public AvatarImage withUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AvatarImage withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AvatarImage withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrlLarge() {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
    }

    public AvatarImage withUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
        return this;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public AvatarImage withUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
        return this;
    }

    public String getUrlOrigin() {
        return urlOrigin;
    }

    public void setUrlOrigin(String urlOrigin) {
        this.urlOrigin = urlOrigin;
    }

    public AvatarImage withUrlOrigin(String urlOrigin) {
        this.urlOrigin = urlOrigin;
        return this;
    }

    public String getUrlMediumOrigin() {
        return urlMediumOrigin;
    }

    public void setUrlMediumOrigin(String urlMediumOrigin) {
        this.urlMediumOrigin = urlMediumOrigin;
    }

    public AvatarImage withUrlMediumOrigin(String urlMediumOrigin) {
        this.urlMediumOrigin = urlMediumOrigin;
        return this;
    }

    public String getUrlLargeOrigin() {
        return urlLargeOrigin;
    }

    public void setUrlLargeOrigin(String urlLargeOrigin) {
        this.urlLargeOrigin = urlLargeOrigin;
    }

    public AvatarImage withUrlLargeOrigin(String urlLargeOrigin) {
        this.urlLargeOrigin = urlLargeOrigin;
        return this;
    }

    public String getUrlSmallOrigin() {
        return urlSmallOrigin;
    }

    public void setUrlSmallOrigin(String urlSmallOrigin) {
        this.urlSmallOrigin = urlSmallOrigin;
    }

    public AvatarImage withUrlSmallOrigin(String urlSmallOrigin) {
        this.urlSmallOrigin = urlSmallOrigin;
        return this;
    }

    public Integer getMentionedUsersCount() {
        return mentionedUsersCount;
    }

    public void setMentionedUsersCount(Integer mentionedUsersCount) {
        this.mentionedUsersCount = mentionedUsersCount;
    }

    public AvatarImage withMentionedUsersCount(Integer mentionedUsersCount) {
        this.mentionedUsersCount = mentionedUsersCount;
        return this;
    }

}

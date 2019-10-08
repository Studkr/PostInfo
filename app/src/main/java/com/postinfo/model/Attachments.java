package com.postinfo.model;

import android.media.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attachments {
    @SerializedName("images")
    @Expose
    private List<ImageModel> images = null;
    @SerializedName("videos")
    @Expose
    private Object videos;
    @SerializedName("posts")
    @Expose
    private Object posts;


    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public Object getVideos() {
        return videos;
    }

    public void setVideos(Object videos) {
        this.videos = videos;
    }

    public Attachments withVideos(Object videos) {
        this.videos = videos;
        return this;
    }

    public Object getPosts() {
        return posts;
    }

    public void setPosts(Object posts) {
        this.posts = posts;
    }

    public Attachments withPosts(Object posts) {
        this.posts = posts;
        return this;
    }

}


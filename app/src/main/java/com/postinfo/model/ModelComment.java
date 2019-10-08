package com.postinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelComment {
   @SerializedName("data")
   @Expose
    private List<ModelLike> data;
    @SerializedName("links")
    @Expose
    private LinksModel links;
    @SerializedName("meta")
    @Expose
    private MetaModel meta;

    public List<ModelLike> getData() {
        return data;
    }

    public void setData(List<ModelLike> data) {
        this.data = data;
    }

   public LinksModel getLinks() {
        return links;
    }

    public void setLinks(LinksModel links) {
        this.links = links;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }
}

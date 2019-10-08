package com.postinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelArray {
    @SerializedName("data")
    @Expose
    private List<ModelLike> model;

    public List<ModelLike> getModel() {
        return model;
    }

    public void setModel(List<ModelLike> model) {
        this.model = model;
    }
}

package com.postinfo.Interfaces;

import com.postinfo.model.ModelViews;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface getViewsInterface {
    @POST("./users/posts/get")
    Call<ModelViews> getViews(@Header("Authorization")String token, @Query("id") String id);
}

package com.postinfo.Interfaces;


import com.postinfo.model.ModelArray;
import com.postinfo.model.ModelLike;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface getAllLike {
    @POST("./users/posts/likers/all")
    Call<ModelArray> getLike(@Header("Authorization")String token, @Query("id") String id);
}

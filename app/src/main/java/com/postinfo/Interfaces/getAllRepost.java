package com.postinfo.Interfaces;

import com.postinfo.model.ModelComment;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface getAllRepost {
    @POST("./users/posts/reposters/all")
    Call<ModelComment> getRepost(@Header("Authorization")String token, @Query("id") String id);
}

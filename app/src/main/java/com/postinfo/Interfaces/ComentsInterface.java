package com.postinfo.Interfaces;

import com.postinfo.model.ModelComment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ComentsInterface {
    @POST("./users/posts/commentators/all")
    Call<ModelComment> getComents(@Header("Authorization")String token, @Query("id") String id);
}

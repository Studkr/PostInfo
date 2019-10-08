package com.postinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.postinfo.Adapters.AdapterAttachment;
import com.postinfo.Adapters.ComentsAdapter;
import com.postinfo.Adapters.LikeAdapter;
import com.postinfo.Adapters.RepostAdapter;
import com.postinfo.Interfaces.ComentsInterface;
import com.postinfo.Interfaces.getAllLike;
import com.postinfo.Interfaces.getAllRepost;
import com.postinfo.Interfaces.getAttachPeople;
import com.postinfo.Interfaces.getViewsInterface;
import com.postinfo.model.LinksModel;
import com.postinfo.model.ModelArray;
import com.postinfo.model.ModelComment;
import com.postinfo.model.ModelLike;
import com.postinfo.model.ModelViews;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String url = "https://api.inrating.top/v1/";
    private String auth_token;
    private List<ModelLike> list = new ArrayList<>();
    private RecyclerView recyclerView_like, recycler_coments,recycler_attach,recyclerView_repost;
    private LinearLayoutManager linearLayoutManager_liked, linearLayoutManager_coments,linearLayoutManager_attach,linearLayoutManager_repost;
    private LikeAdapter likeAdapter;
    private ComentsAdapter comentsAdapter;
    private AdapterAttachment adapterAttachment;
    private RepostAdapter repostAdapter;
    private TextView text_liked,see_like,coment_text,text_view,people_attach,repost_text,bookmarks_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        auth_token =getResources().getString(R.string.auth_token);
       Asynk asynk = new Asynk();
       asynk.execute();

    }


    public void findID(){
        linearLayoutManager_liked =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_like = findViewById(R.id.recycler_liked);
        recyclerView_like.setLayoutManager(linearLayoutManager_liked);
        text_liked = findViewById(R.id.text_like);
        see_like = findViewById(R.id.see_like);
        coment_text = findViewById(R.id.coment_textview);
        recycler_coments = findViewById(R.id.recycler_coments);
        linearLayoutManager_coments = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager_attach =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycler_coments.setLayoutManager(linearLayoutManager_coments);
        recycler_attach = findViewById(R.id.recycler_attach);
        recycler_attach.setLayoutManager(linearLayoutManager_attach);
        text_view = findViewById(R.id.view_text);
        people_attach = findViewById(R.id.peopel_textview);
        recyclerView_repost = findViewById(R.id.recycler_repost);
        linearLayoutManager_repost =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_repost.setLayoutManager(linearLayoutManager_repost);
        repost_text = findViewById(R.id.repost_textview);
        bookmarks_text = findViewById(R.id.bookmarks_text);
    }

    class Asynk extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            final Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            getAllLike getAllLike = retrofit.create(com.postinfo.Interfaces.getAllLike.class);
            Call<ModelArray>callmodel =getAllLike.getLike("Bearer "+auth_token,"2720");
            callmodel.enqueue(new Callback<ModelArray>() {
                @Override
                public void onResponse(Call<ModelArray> call, Response<ModelArray> response) {
                    if(response.isSuccessful()) {
                        List<ModelLike> model = new ArrayList<>();
                        model = response.body().getModel();
                        list = model;
                        setupAdapter(list);
                    }
                }
                @Override
                public void onFailure(Call<ModelArray> call, Throwable t) {
                    Log.e("Error",""+t.getMessage());
                }
            });

            ComentsInterface comentsInterface = retrofit.create(ComentsInterface.class);
            Call<ModelComment>commentCall = comentsInterface.getComents("Bearer "+auth_token,"2720");
            commentCall.enqueue(new Callback<ModelComment>() {

                @Override
                public void onResponse(Call<ModelComment> call, Response<ModelComment> response) {
                    if(response.isSuccessful()) {
                        List<ModelLike> modelComments = new ArrayList<>();

                        modelComments = response.body().getData();
                        setupComments(modelComments);
                    }

                }
                @Override
                public void onFailure(Call<ModelComment> call, Throwable t) {
                    Log.e("Error",""+t.getMessage());
                }
            });


            getViewsInterface interViews = retrofit.create(getViewsInterface.class);
            Call<ModelViews> viewsCall = interViews.getViews("Bearer "+auth_token,"2720");
            viewsCall.enqueue(new Callback<ModelViews>() {
                @Override
                public void onResponse(Call<ModelViews> call, Response<ModelViews> response) {
                    if(response.isSuccessful()) {
                        Log.d("Response", "" + response.body().getViewsCount());
                        setupViews(response.body().getViewsCount());
                        setBookmarks(response.body().getBookmarksCount());
                    }
                }

                @Override
                public void onFailure(Call<ModelViews> call, Throwable t) {
                    Log.e("Error",""+t.getMessage());
                }
            });

            getAttachPeople people = retrofit.create(getAttachPeople.class);
            Call<ModelComment> viewMarked = people.getMarked("Bearer "+auth_token,"2720");
            viewMarked.enqueue(new Callback<ModelComment>() {
                @Override
                public void onResponse(Call<ModelComment> call, Response<ModelComment> response) {
                    if(response.isSuccessful()) {
                        List<ModelLike> model = response.body().getData();
                        setAttachmend(model);
                    }
                }

                @Override
                public void onFailure(Call<ModelComment> call, Throwable t) {
                    Log.e("Error",""+t.getMessage());
                }
            });

            getAllRepost repost = retrofit.create(getAllRepost.class);
            Call<ModelComment> repost_mod = repost.getRepost("Bearer "+auth_token,"2720");
            repost_mod.enqueue(new Callback<ModelComment>() {
                @Override
                public void onResponse(Call<ModelComment> call, Response<ModelComment> response) {
                    if(response.isSuccessful()) {
                        List<ModelLike> model = response.body().getData();
                        setRepost(model);
                    }
                }

                @Override
                public void onFailure(Call<ModelComment> call, Throwable t) {
                    Log.e("Error",""+t.getMessage());
                }
            });
            return null;
        }
    }






    private void setBookmarks(int bookmarks){
        bookmarks_text.setText(getResources().getString(R.string.bookmarks)+" "+bookmarks);
    }

    private void setRepost(List<ModelLike> list){
        if(list.size()==0){
        recyclerView_repost.setVisibility(View.GONE);
        }else{
            recyclerView_repost.setVisibility(View.VISIBLE);
            repostAdapter = new RepostAdapter(this,list);
            recyclerView_repost.setAdapter(repostAdapter);
        }
        repost_text.setText(getResources().getString(R.string.repost)+" "+list.size());
    }

    private void setupViews(int viewCount){
        text_view.setText(getResources().getString(R.string.prosmot)+" "+viewCount);
    }

    private void setAttachmend(List<ModelLike> list){
        if(list.size()==0){
           recycler_attach.setVisibility(View.GONE);
        }else{
            recycler_attach.setVisibility(View.VISIBLE);
            adapterAttachment = new AdapterAttachment(this,list);
            recycler_attach.setAdapter(adapterAttachment);
        }
        people_attach.setText(getResources().getString(R.string.attach)+" "+list.size());

    }

    private void setupComments(List<ModelLike> list){
        coment_text.setText(getResources().getString(R.string.comments)+" " + list.size());
        comentsAdapter = new ComentsAdapter(this,list);
        recycler_coments.setAdapter(comentsAdapter);

    }

    private void setupAdapter(List<ModelLike> list){
        text_liked.setText(getResources().getString(R.string.likes)+" "+list.size());
        if(list.size()==0){
            recyclerView_like.setVisibility(View.GONE);
        }else{
            recyclerView_like.setVisibility(View.VISIBLE);
            int last = linearLayoutManager_liked.findLastCompletelyVisibleItemPosition();
            int el = list.size()-last;
            see_like.setText((getResources().getString(R.string.more)+ el));
            likeAdapter = new LikeAdapter(MainActivity.this,list);
            recyclerView_like.setAdapter(likeAdapter);
        }

    }


}

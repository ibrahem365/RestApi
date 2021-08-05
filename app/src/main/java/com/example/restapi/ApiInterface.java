package com.example.restapi;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

     //Get for 1 post
//    @GET("posts/1")
//    public Call<Post> getPost();

    //Get from query
    @GET("posts")
    public Call<List<Post>> getPost(@Query("userId") String userId);

    @POST("posts")
    public Call<Post> storePost(@Body Post post);

    //post separated objects
    @POST("posts")
    public Call<Post> storeMab(@Body HashMap<Object,Object> map);

}

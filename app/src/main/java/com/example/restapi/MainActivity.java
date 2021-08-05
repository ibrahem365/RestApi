package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Post object
        Post post = new Post(5,"Ibrahem","Hi ibrahem");

        // Post separated objects
        HashMap<Object,Object> map = new HashMap<>();
        map.put("title","ibme");
        map.put("body","bome");
        map.put("userId","6");

        // pass map to retrofit

        TextView postTv = findViewById(R.id.post_item_tv);

        //Create Builder with base url for both get and post
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Full the interface by Builder for both get and post
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        //use call
        // get post
//        Call<List<Post>> call = apiInterface.getPost("1");
//
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                postTv.setText(response.body().get(0).getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                postTv.setText(t.getMessage());
//            }
//        });

        //post an object by retrofit
        Call<Post> call = apiInterface.storePost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                postTv.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postTv.setText(t.getMessage());
            }
        });

        // pass map to retrofit
        Call<Post> mapCall = apiInterface.storeMab(map);
        //and complete


    }
}
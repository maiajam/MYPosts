package com.maiajam.maiposts.data.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("Posts")
    Call<> getAllPosts();


}

package com.maiajam.maiposts.data.retrofit;

import com.maiajam.maiposts.data.model.AllPost;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("Posts")
    Observable<List<AllPost>> getAllPosts();
}

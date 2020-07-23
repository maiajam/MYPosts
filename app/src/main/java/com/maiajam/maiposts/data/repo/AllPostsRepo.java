package com.maiajam.maiposts.data.repo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.maiajam.maiposts.data.model.AllPost;
import com.maiajam.maiposts.data.retrofit.ApiClient;
import com.maiajam.maiposts.data.retrofit.ApiService;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AllPostsRepo {

    private static ApiService apiService;
    private static Observable<List<AllPost>> allPostsObservable;
    private static MutableLiveData<List<AllPost>> allPostsLiveData;
    private static Throwable throwable;
    private static AllPostsRepo instance;

    public static AllPostsRepo getInstance() {
        if(instance == null) {
            instance = new AllPostsRepo();
            allPostsLiveData = instance.getAllPosts();
        }
        return instance;
    }

    private MutableLiveData<List<AllPost>> getAllPosts() {
        if (allPostsLiveData == null) {
            allPostsLiveData = new MutableLiveData<>();
            fetchAllPosts();
        }
        return allPostsLiveData;
    }

    public MutableLiveData<List<AllPost>> getAllPostsLists()
    {
        return allPostsLiveData;
    }

    private static void fetchAllPosts() {
        apiService = ApiClient.getApiClient().create(ApiService.class);
        allPostsObservable = apiService.getAllPosts();
        allPostsObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AllPost>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(List<AllPost> allPosts) {
                        allPostsLiveData.setValue(allPosts);
                        Log.d("on next","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                      instance.setThrowable(e);
                    }

                    @Override
                    public void onComplete() {
                    Log.d("on Complete","onComplete");
                    }
                });

    }

    private void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public  Throwable getThrowable() {
        return throwable;
    }
}

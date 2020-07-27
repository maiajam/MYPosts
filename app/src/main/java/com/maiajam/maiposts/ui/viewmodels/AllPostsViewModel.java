package com.maiajam.maiposts.ui.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.maiposts.data.model.AllPost;
import com.maiajam.maiposts.data.repo.AllPostsRepo;
import com.maiajam.maiposts.helper.HelperMethods;

import java.util.List;

import static com.maiajam.maiposts.helper.HelperMethods.isNetworkAvailable;

public class AllPostsViewModel extends ViewModel {


    public  Boolean isNetworkAvailable(Context context) {
        if (isNetworkAvailable(context))
            return true;
        else
            return false;
    }

    public MutableLiveData<List<AllPost>> getAllPosts() {
        return AllPostsRepo.getInstance().getAllPostsLists();
    }

    public Throwable getThrowable() {
        return AllPostsRepo.getInstance().getThrowable();
    }
}

package com.maiajam.maiposts.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.maiposts.data.model.AllPost;
import com.maiajam.maiposts.data.repo.AllPostsRepo;

import java.util.List;

public class AllPostsViewModel extends ViewModel {


    public MutableLiveData<List<AllPost>> getAllPosts()
    {
       return AllPostsRepo.getInstance().getAllPostsLists();
    }

    public Throwable getThrowable()
    {
        return AllPostsRepo.getInstance().getThrowable();
    }
}

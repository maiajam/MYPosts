package com.maiajam.maiposts.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maiajam.maiposts.R;
import com.maiajam.maiposts.databinding.ActivityAllPostsBinding;

public class AllPostsActivity extends Fragment {

    ActivityAllPostsBinding allPostsBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allPostsBinding = DataBindingUtil.setContentView(this,R.layout.activity_all_posts);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_all_posts,container,false);
        initialAllPost();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initialAllPost() {
        allPostsBinding.AllPostsRVAllPosts.setLayoutManager(new LinearLayoutManager(this));
    }
}

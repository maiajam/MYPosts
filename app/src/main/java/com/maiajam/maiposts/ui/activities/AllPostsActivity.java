package com.maiajam.maiposts.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.maiajam.maiposts.R;
import com.maiajam.maiposts.databinding.ActivityAllPostsBinding;

public class AllPostsActivity extends AppCompatActivity {

    ActivityAllPostsBinding allPostsBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allPostsBinding = DataBindingUtil.setContentView(this,R.layout.activity_all_posts);

        initialAllPost();


    }

    private void initialAllPost() {
        allPostsBinding.AllPostsRVAllPosts.setLayoutManager(new LinearLayoutManager(this));

    }
}

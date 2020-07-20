package com.maiajam.maiposts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maiajam.maiposts.R;
import com.maiajam.maiposts.data.model.AllPost;

import java.util.ArrayList;

public class AllPostsAdapter extends RecyclerView.Adapter<AllPostsAdapter.Holder> {

    ArrayList<AllPost> allPostsArrayList ;
    Context context;

    public AllPostsAdapter(ArrayList<AllPost> allPostsArrayList, Context context) {
        this.allPostsArrayList = allPostsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AllPostsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewRoot = LayoutInflater.from(context).inflate(R.layout.item_all_posts,parent,false);
        return viewRoot;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder{

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

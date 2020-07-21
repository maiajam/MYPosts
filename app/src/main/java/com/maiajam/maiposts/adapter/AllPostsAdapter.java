package com.maiajam.maiposts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.maiajam.maiposts.R;
import com.maiajam.maiposts.data.model.AllPost;
import com.maiajam.maiposts.databinding.ItemAllPostsBinding;

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

        ItemAllPostsBinding itemAllPostsBinding = ItemAllPostsBinding.inflate(LayoutInflater.from(context),parent,false);
        return new Holder(itemAllPostsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        AllPost allPost = allPostsArrayList.get(position);
        holder.binding(allPost);
    }



    @Override
    public int getItemCount() {
        return allPostsArrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ItemAllPostsBinding itemBinding;
        public Holder(ItemAllPostsBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        public void binding(AllPost allPost)
        {
            itemBinding.setAllPost(allPost);
            itemBinding.executePendingBindings();
        }

    }
}

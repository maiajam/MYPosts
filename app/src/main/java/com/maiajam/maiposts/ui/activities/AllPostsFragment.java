package com.maiajam.maiposts.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.maiajam.maiposts.R;
import com.maiajam.maiposts.adapter.AllPostsAdapter;
import com.maiajam.maiposts.data.model.AllPost;
import com.maiajam.maiposts.data.retrofit.ApiClient;
import com.maiajam.maiposts.data.retrofit.ApiService;
import com.maiajam.maiposts.databinding.ActivityAllPostsBinding;
import com.maiajam.maiposts.ui.viewmodels.AllPostsViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AllPostsFragment extends Fragment {

    ActivityAllPostsBinding allPostsBinding ;
    AllPostsAdapter allPostsAdapter;
    private ApiService apiService;
    Observable<List<AllPost>> allPostsObservable ;
    private AllPostsViewModel allPostsViewModel;
    private String errorMassage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allPostsBinding = DataBindingUtil.setContentView(getActivity(),R.layout.activity_all_posts);
        apiService = ApiClient.getApiClient().create(ApiService.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_all_posts,container,false);
        initialAllPost();
        return v;
    }

    private void initialAllPost() {
        allPostsViewModel = new ViewModelProvider(this).get(AllPostsViewModel.class);
        if(allPostsViewModel.getThrowable()!= null){
            allPostsViewModel.getAllPosts().observe(getActivity(), new androidx.lifecycle.Observer<List<AllPost>>() {
                @Override
                public void onChanged(List<AllPost> allPosts) {
                    fillAllThePosts(allPosts);
                }
            });  
        }else{
             errorMassage = allPostsViewModel.getThrowable().getMessage().toString();
            Toast.makeText(getActivity(),errorMassage,Toast.LENGTH_LONG).show();
        }
      
    }

    private void fillAllThePosts(List<AllPost> allPosts) {
        allPostsBinding.AllPostsRVAllPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        allPostsAdapter = new AllPostsAdapter((ArrayList<AllPost>) allPosts,getActivity());
        allPostsAdapter.notifyDataSetChanged();
    }
}

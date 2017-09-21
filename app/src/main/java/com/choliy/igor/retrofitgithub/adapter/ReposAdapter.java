package com.choliy.igor.retrofitgithub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubRepo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposHolder> {

    private List<GitHubRepo> mRepos;

    public ReposAdapter(List<GitHubRepo> repos) {
        mRepos = repos;
    }

    @Override
    public ReposHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_repos, parent, Boolean.FALSE);
        return new ReposHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposHolder holder, int position) {
        holder.mName.setText(mRepos.get(position).getName());
        holder.mDescription.setText(mRepos.get(position).getDescription());
        holder.mLanguage.setText(mRepos.get(position).getLanguage());
        holder.mRepoUrl = mRepos.get(position).getUrl();
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }
}
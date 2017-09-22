package com.choliy.igor.retrofitgithub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoHolder> {

    private List<GitHubRepo> mRepos = new ArrayList<>();

    @Override
    public RepoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_repos, parent, Boolean.FALSE);
        return new RepoHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoHolder holder, int position) {
        holder.bindData(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public void setRepos(List<GitHubRepo> repos) {
        mRepos = repos;
        notifyDataSetChanged();
    }
}
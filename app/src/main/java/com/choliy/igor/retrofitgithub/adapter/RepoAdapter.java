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
    private OnLastItemCallback mCallback;

    public RepoAdapter(OnLastItemCallback callback) {
        mCallback = callback;
    }

    @Override
    public RepoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_repos, parent, Boolean.FALSE);
        return new RepoHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoHolder holder, int position) {
        holder.bindData(mRepos.get(position));

        // Callback on the end of the list
        if (position == getItemCount() - 1) {
            mCallback.onLastItem();
        }
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public void addRepos(List<GitHubRepo> repos) {
        mRepos.addAll(repos);
        notifyDataSetChanged();
    }

    public interface OnLastItemCallback {
        void onLastItem();
    }
}
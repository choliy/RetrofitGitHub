package com.choliy.igor.retrofitgithub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.activity.WebActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

class ReposHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_repo_name) TextView mName;
    @BindView(R.id.tv_repo_description) TextView mDescription;
    @BindView(R.id.tv_repo_language) TextView mLanguage;
    String mRepoUrl;

    ReposHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        view.getContext().startActivity(WebActivity.newInstance(view.getContext(), mRepoUrl));
    }
}
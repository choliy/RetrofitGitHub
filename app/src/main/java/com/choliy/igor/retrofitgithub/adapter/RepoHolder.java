package com.choliy.igor.retrofitgithub.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.activity.WebActivity;
import com.choliy.igor.retrofitgithub.model.GitHubRepo;

import butterknife.BindView;
import butterknife.ButterKnife;

class RepoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_repo_name) private TextView mName;
    @BindView(R.id.tv_repo_description) private TextView mDescription;
    @BindView(R.id.tv_repo_language) private TextView mLanguage;
    private String mRepoUrl;

    RepoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        WebActivity.newInstance(view.getContext(), mRepoUrl);
    }

    void bindData(GitHubRepo repo) {
        // set name
        mName.setText(repo.getName());

        // set description
        if (TextUtils.isEmpty(repo.getDescription())) {
            setNoInfoData(mDescription);
        } else {
            mDescription.setText(repo.getDescription());
        }

        // set language
        if (TextUtils.isEmpty(repo.getLanguage())) {
            setNoInfoData(mLanguage);
        } else {
            mLanguage.setText(repo.getLanguage());
        }

        // set url
        mRepoUrl = repo.getUrl();
    }

    private void setNoInfoData(TextView textView) {
        int colorGrey = ContextCompat.getColor(textView.getContext(), R.color.colorGrey);
        textView.setTextColor(colorGrey);
        textView.setText(R.string.text_no_info);
    }
}
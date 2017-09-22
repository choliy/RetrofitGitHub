package com.choliy.igor.retrofitgithub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubUser;
import com.choliy.igor.retrofitgithub.util.DateUtils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class InfoActivity extends AbstractActivity implements View.OnClickListener {

    @BindView(R.id.iv_avatar) CircleImageView mAvatar;
    @BindView(R.id.tv_username) TextView mUsername;
    @BindView(R.id.tv_full_name) TextView mFullName;
    @BindView(R.id.tv_company) TextView mCompany;
    @BindView(R.id.tv_location) TextView mLocation;
    @BindView(R.id.tv_email) TextView mEmail;
    @BindView(R.id.tv_about) TextView mAbout;
    @BindView(R.id.tv_repos) TextView mRepos;
    @BindView(R.id.tv_gists) TextView mGists;
    @BindView(R.id.tv_followers) TextView mFollowers;
    @BindView(R.id.tv_following) TextView mFollowing;
    @BindView(R.id.tv_created) TextView mCreated;
    private GitHubUser mUser;

    public static void newInstance(Context context, GitHubUser user) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(InfoActivity.class.getSimpleName(), user);
        context.startActivity(intent);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_info;
    }

    @Override
    public void setupUi() {
        mUser = getIntent().getParcelableExtra(InfoActivity.class.getSimpleName());
        bindData(mUser);
    }

    @Override
    public void onClick(View view) {
        RepoActivity.newInstance(this, mUser.getUsername());
    }

    private void bindData(GitHubUser user) {
        // set avatar
        loadAvatar(user.getAvatarUrl());

        // set username
        mUsername.setText(user.getUsername());

        // set fullName
        if (TextUtils.isEmpty(user.getFullName())) {
            setNoInfoText(mFullName);
        } else {
            mFullName.setText(user.getFullName());
        }

        // set company
        if (TextUtils.isEmpty(user.getCompany())) {
            setNoInfoText(mCompany);
        } else {
            mCompany.setText(user.getCompany());
        }

        // set location
        if (TextUtils.isEmpty(user.getLocation())) {
            setNoInfoText(mLocation);
        } else {
            mLocation.setText(user.getLocation());
        }

        // set email
        if (TextUtils.isEmpty(user.getEmail())) {
            setNoInfoText(mEmail);
        } else {
            mEmail.setText(user.getEmail());
        }

        // set about
        if (TextUtils.isEmpty(user.getAbout())) {
            setNoInfoText(mAbout);
        } else {
            mAbout.setText(user.getAbout());
        }

        // set repos
        mRepos.setText(String.valueOf(user.getRepos()));
        if (user.getRepos() > 0) {
            mRepos.setOnClickListener(this);
            mRepos.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        }

        // set gists
        mGists.setText(String.valueOf(user.getGists()));

        // set followers
        mFollowers.setText(String.valueOf(user.getFollowers()));

        // set following
        mFollowing.setText(String.valueOf(user.getFollowing()));

        // set created date
        mCreated.setText(DateUtils.formatDate(this, user.getCreated()));
    }

    private void loadAvatar(String avatarUrl) {
        if (!TextUtils.isEmpty(avatarUrl)) Glide.with(this).load(avatarUrl).into(mAvatar);
    }

    private void setNoInfoText(TextView textView) {
        textView.setText(getString(R.string.text_no_info));
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorGrey));
    }
}
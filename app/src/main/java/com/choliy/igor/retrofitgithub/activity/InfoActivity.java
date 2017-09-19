package com.choliy.igor.retrofitgithub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubUser;
import com.choliy.igor.retrofitgithub.util.Utils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class InfoActivity extends AbstractActivity {

    private static final String KEY_INFO = "key_info";

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
    @BindView(R.id.iv_avatar) CircleImageView mAvatar;

    public static Intent newInstance(Context context, GitHubUser user) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(KEY_INFO, user);
        return intent;
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_info;
    }

    @Override
    public void setupUi() {
        GitHubUser user = getIntent().getParcelableExtra(KEY_INFO);
        bindData(user);
    }

    private void bindData(GitHubUser user) {
        // set username
        mUsername.setText(user.getUsername());

        // set fullName
        if (user.getFullName() != null) mFullName.setText(user.getFullName());
        else setNoInfoText(mFullName);

        // set company
        if (user.getCompany() != null) mCompany.setText(user.getCompany());
        else setNoInfoText(mCompany);

        // set location
        if (user.getLocation() != null) mLocation.setText(user.getLocation());
        else setNoInfoText(mLocation);

        // set email
        if (user.getEmail() != null) mEmail.setText(user.getEmail());
        else setNoInfoText(mEmail);

        // set about
        if (user.getAbout() != null) mAbout.setText(user.getAbout());
        else setNoInfoText(mAbout);

        // set repos
        mRepos.setText(String.valueOf(user.getRepos()));

        // set gists
        mGists.setText(String.valueOf(user.getGists()));

        // set followers
        mFollowers.setText(String.valueOf(user.getFollowers()));

        // set following
        mFollowing.setText(String.valueOf(user.getFollowing()));

        // set created date
        mCreated.setText(Utils.formatDate(this, user.getCreated()));

        // set avatar
        loadAvatar(user.getAvatarUrl());
    }

    private void loadAvatar(String avatarUrl) {
        if (!TextUtils.isEmpty(avatarUrl)) Glide.with(this).load(avatarUrl).into(mAvatar);
    }

    private void setNoInfoText(TextView textView) {
        textView.setText(getString(R.string.text_no_info));
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorGrey));
    }
}
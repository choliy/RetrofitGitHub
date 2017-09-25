package com.choliy.igor.retrofitgithub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.adapter.RepoAdapter;
import com.choliy.igor.retrofitgithub.model.GitHubRepo;
import com.choliy.igor.retrofitgithub.rest.ApiClient;
import com.choliy.igor.retrofitgithub.rest.ApiService;
import com.choliy.igor.retrofitgithub.util.InfoUtils;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoActivity extends AbstractActivity implements RepoAdapter.OnLastItemCallback {

    private static final String KEY_INTENT_USERNAME = "key_intent_username";
    private int mPageNumber = ApiService.DEFAULT_PAGE_NUMBER;
    private boolean mNoModeDataToFetch;
    private RepoAdapter mAdapter;

    @BindView(R.id.rv_repositories) RecyclerView mRecyclerView;
    @BindView(R.id.progress_repo) ProgressBar mProgress;

    public static void newInstance(Context context, String username) {
        Intent intent = new Intent(context, RepoActivity.class);
        intent.putExtra(KEY_INTENT_USERNAME, username);
        context.startActivity(intent);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_repo;
    }

    @Override
    public void setupUi() {
        setupAdapter();
        loadRepositories();
    }

    @Override
    public void onLastItem() {
        if (!mNoModeDataToFetch) {
            mPageNumber = ++mPageNumber;
            showProgress(Boolean.TRUE);
            loadRepositories();
        }
    }

    private void setupAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this, layoutManager.getOrientation());
        mAdapter = new RepoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setHasFixedSize(Boolean.TRUE);
    }

    private void loadRepositories() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        String username = getIntent().getStringExtra(KEY_INTENT_USERNAME);
        Call<List<GitHubRepo>> call = apiService.getRepos(username, mPageNumber, ApiService.REPOS_PER_PAGE);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                showProgress(Boolean.FALSE);
                if (response.isSuccessful()) {
                    mAdapter.addRepos(response.body());
                    if (response.body().size() < ApiService.REPOS_PER_PAGE) {
                        mNoModeDataToFetch = Boolean.TRUE;
                    }
                } else {
                    InfoUtils.showErrorCode(RepoActivity.this, response.code());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                showProgress(Boolean.FALSE);
                InfoUtils.showInfoToast(RepoActivity.this, getString(R.string.text_check_internet));
            }
        });
    }

    private void showProgress(boolean show) {
        if (show) {
            mProgress.setVisibility(View.VISIBLE);
        } else {
            mProgress.setVisibility(View.INVISIBLE);
        }
    }
}
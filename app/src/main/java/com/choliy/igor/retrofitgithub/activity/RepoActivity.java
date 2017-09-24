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

public class RepoActivity extends AbstractActivity {

    private static final String KEY_INTENT_USERNAME = "key_intent_username";
    private RepoAdapter mAdapter;
    private int mPageNumber = 1;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this, layoutManager.getOrientation());
        mAdapter = new RepoAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setHasFixedSize(Boolean.TRUE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadRepositories();
    }

    private void loadRepositories() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        String username = getIntent().getStringExtra(KEY_INTENT_USERNAME);
        Call<List<GitHubRepo>> call = apiService.getRepos(username);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                mProgress.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    mAdapter.setRepos(response.body());
                } else {
                    InfoUtils.showErrorCode(RepoActivity.this, response.code());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                mProgress.setVisibility(View.INVISIBLE);
                InfoUtils.showInfoToast(RepoActivity.this, getString(R.string.text_check_internet));
            }
        });
    }
}
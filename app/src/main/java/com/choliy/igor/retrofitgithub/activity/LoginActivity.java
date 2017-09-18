package com.choliy.igor.retrofitgithub.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubUser;
import com.choliy.igor.retrofitgithub.rest.ApiClient;
import com.choliy.igor.retrofitgithub.rest.ApiService;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AbstractActivity {

    @BindView(R.id.edit_text) EditText mUsername;
    @BindView(R.id.progress) ProgressBar mProgress;

    @Override
    public int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void setupUi() {
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        if (!TextUtils.isEmpty(mUsername.getText().toString())) {
            mProgress.setVisibility(View.VISIBLE);
            loadData();
        } else {
            showToast(getString(R.string.text_enter_username));
        }
    }

    private void loadData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<GitHubUser> call = apiService.getUser(mUsername.getText().toString());
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                mProgress.setVisibility(View.INVISIBLE);
                startActivity(InfoActivity.newInstance(LoginActivity.this, response.body()));
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                mProgress.setVisibility(View.INVISIBLE);
                showToast(getString(R.string.text_no_user));
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
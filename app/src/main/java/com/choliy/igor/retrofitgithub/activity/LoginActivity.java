package com.choliy.igor.retrofitgithub.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.choliy.igor.retrofitgithub.R;
import com.choliy.igor.retrofitgithub.model.GitHubUser;
import com.choliy.igor.retrofitgithub.rest.ApiClient;
import com.choliy.igor.retrofitgithub.rest.ApiService;
import com.choliy.igor.retrofitgithub.util.InfoUtils;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AbstractActivity {

    @BindView(R.id.edit_text) EditText mUsername;
    @BindView(R.id.progress_login) ProgressBar mProgress;

    @Override
    public int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void setupUi() {
        // leave empty for current activity
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        if (!TextUtils.isEmpty(mUsername.getText().toString())) {
            mProgress.setVisibility(View.VISIBLE);
            loadUserData();
        } else {
            InfoUtils.showInfoToast(LoginActivity.this, getString(R.string.text_enter_username));
        }
    }

    private void loadUserData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<GitHubUser> call = apiService.getUser(mUsername.getText().toString());
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                mProgress.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    InfoActivity.newInstance(LoginActivity.this, response.body());
                } else {
                    InfoUtils.showErrorCode(LoginActivity.this, response.code());
                    // for getting error string:
                    // response.errorBody().string()
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                mProgress.setVisibility(View.INVISIBLE);
                InfoUtils.showInfoToast(LoginActivity.this, getString(R.string.text_check_internet));
            }
        });
    }
}
package com.choliy.igor.retrofitgithub.activity;

import android.widget.EditText;

import com.choliy.igor.retrofitgithub.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends AbstractActivity {

    @BindView(R.id.edit_text) EditText mUsername;

    @Override
    public int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void setupUi() {

    }

    @OnClick(R.id.btn_login)
    public void onClick() {

    }
}
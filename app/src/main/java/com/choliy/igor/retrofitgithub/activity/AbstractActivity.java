package com.choliy.igor.retrofitgithub.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class AbstractActivity extends AppCompatActivity {

    public abstract int layoutRes();

    public abstract void setupUi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
        setupUi();
    }
}
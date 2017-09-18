package com.choliy.igor.retrofitgithub.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import icepick.Icepick;

public abstract class AbstractActivity extends AppCompatActivity {

    public abstract int layoutRes();

    public abstract void setupUi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(layoutRes());
        setupUi();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}
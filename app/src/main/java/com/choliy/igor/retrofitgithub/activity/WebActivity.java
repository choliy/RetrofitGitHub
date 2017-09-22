package com.choliy.igor.retrofitgithub.activity;

import android.content.Context;
import android.content.Intent;

import com.choliy.igor.retrofitgithub.R;

public class WebActivity extends AbstractActivity {

    public static void newInstance(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(WebActivity.class.getSimpleName(), url);
        context.startActivity(intent);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_web;
    }

    @Override
    public void setupUi() {

    }
}
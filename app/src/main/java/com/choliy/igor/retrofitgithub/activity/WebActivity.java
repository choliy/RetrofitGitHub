package com.choliy.igor.retrofitgithub.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.choliy.igor.retrofitgithub.R;

import butterknife.BindView;

public class WebActivity extends AbstractActivity {

    private static final String KEY_INTENT_NAME = "key_intent_name";
    private static final String KEY_INTENT_URL = "key_intent_url";
    private static final int ONE_HUNDRED_PERCENT = 100;

    @BindView(R.id.progress_web) ProgressBar mProgress;
    @BindView(R.id.web_view) WebView mWebView;

    public static void newInstance(Context context, String name, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(KEY_INTENT_NAME, name);
        intent.putExtra(KEY_INTENT_URL, url);
        context.startActivity(intent);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_web;
    }

    @Override
    public void setupUi() {
        String repoName = getIntent().getStringExtra(KEY_INTENT_NAME);
        setTitle(getString(R.string.label_web, repoName));

        mWebView.getSettings().setJavaScriptEnabled(Boolean.TRUE);
        mWebView.getSettings().setLoadWithOverviewMode(Boolean.TRUE);
        mWebView.getSettings().setUseWideViewPort(Boolean.TRUE);
        mWebView.getSettings().setBuiltInZoomControls(Boolean.TRUE);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return Boolean.FALSE;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == ONE_HUNDRED_PERCENT) {
                    mProgress.setVisibility(View.INVISIBLE);
                } else {
                    mProgress.setVisibility(View.VISIBLE);
                }
            }
        });
        mWebView.loadUrl(getIntent().getStringExtra(KEY_INTENT_URL));
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
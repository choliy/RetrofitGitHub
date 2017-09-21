package com.choliy.igor.retrofitgithub.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {

    @SerializedName("name")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("language")
    private String mLanguage;

    @SerializedName("html_url")
    private String mUrl;

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public String getUrl() {
        return mUrl;
    }
}
package com.choliy.igor.retrofitgithub.rest;

import com.choliy.igor.retrofitgithub.model.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiCalls {

    /**
     * By GitHub documentation for getting user info path current url
     * "https://api.github.com/users/{user}"
     *
     * Go by this link for more info
     * https://api.github.com/
     */
    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);
}
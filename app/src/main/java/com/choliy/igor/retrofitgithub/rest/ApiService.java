package com.choliy.igor.retrofitgithub.rest;

import com.choliy.igor.retrofitgithub.model.GitHubRepo;
import com.choliy.igor.retrofitgithub.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Go by this link for more API info:
 * https://api.github.com/
 */
public interface ApiService {

    /**
     * By GitHub documentation for getting user info:
     * "https://api.github.com/users/{user}"
     */
    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);

    /**
     * By GitHub documentation for getting users repositories:
     * "https://api.github.com/users/{user}/repos"
     */
    @GET("users/{username}/repos")
    Call<List<GitHubRepo>> getRepos(@Path("username") String username);
}
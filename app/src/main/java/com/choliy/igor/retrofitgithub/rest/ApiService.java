package com.choliy.igor.retrofitgithub.rest;

import com.choliy.igor.retrofitgithub.model.GitHubRepo;
import com.choliy.igor.retrofitgithub.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Go by this link for more API info:
 * https://api.github.com/
 */
public interface ApiService {

    /**
     * By GitHub documentation for getting user info:
     * https://api.github.com/users/{user}
     */
    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);

    /**
     * By GitHub documentation for getting users repositories:
     * https://api.github.com/users/{user}/repos
     * 100 repos per page is a maximum value in gitHub API
     */
    @GET("users/{username}/repos?per_page=100")
    Call<List<GitHubRepo>> getRepos(@Path("username") String username);

    /**
     * By GitHub documentation custom query with search options:
     * https://api.github.com/users/{user}/repos{?type,page,per_page,sort}
     */
    @GET("users/{username}/repos")
    Call<List<GitHubRepo>> getQueryRepos(@Path("username") String username,
                                         @Query("page") int page,
                                         @Query("sort") String sortType);

}
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

    int DEFAULT_PAGE_NUMBER = 1;
    int REPOS_PER_PAGE = 50;

    /**
     * By GitHub documentation for getting user info:
     * "https://api.github.com/users/{user}"
     */
    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);

    /**
     * By GitHub documentation for getting user repositories:
     * "https://api.github.com/users/{user}/repos{?type,page,per_page,sort}"
     * <p>
     * 100 items per page is a maximum value by gitHub API
     * by default it will returns 30 items per request
     *
     * @Query("key") equals "users/{username}/repos?page=2&per_page=50"
     */
    @GET("users/{username}/repos")
    Call<List<GitHubRepo>> getRepos(@Path("username") String username,
                                    @Query("page") int page,
                                    @Query("per_page") int perPage);
}
package com.choliy.igor.retrofitgithub.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {

    @SerializedName("login")
    private String mUsername;

    @SerializedName("name")
    private String mFullName;

    @SerializedName("company")
    private String mCompany;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("bio")
    private String mAbout;

    @SerializedName("created_at")
    private String mCreated;

    @SerializedName("html_url")
    private String mWebUrl;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("public_repos")
    private int mRepos;

    @SerializedName("public_gists")
    private int mGists;

    @SerializedName("followers")
    private int mFollowers;

    @SerializedName("following")
    private int mFollowing;

    public GitHubUser(
            String username,
            String fullName,
            String company,
            String location,
            String email,
            String about,
            String created,
            String webUrl,
            String avatarUrl,
            int repos,
            int gists,
            int followers,
            int following) {
        setUsername(username);
        setFullName(fullName);
        setCompany(company);
        setLocation(location);
        setEmail(email);
        setAbout(about);
        setCreated(created);
        setWebUrl(webUrl);
        setAvatarUrl(avatarUrl);
        setRepos(repos);
        setGists(gists);
        setFollowers(followers);
        setFollowing(following);
    }

    public String getUsername() {
        return mUsername;
    }

    private void setUsername(String username) {
        mUsername = username;
    }

    public String getFullName() {
        return mFullName;
    }

    private void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getCompany() {
        return mCompany;
    }

    private void setCompany(String company) {
        mCompany = company;
    }

    public String getLocation() {
        return mLocation;
    }

    private void setLocation(String location) {
        mLocation = location;
    }

    public String getEmail() {
        return mEmail;
    }

    private void setEmail(String email) {
        mEmail = email;
    }

    public String getAbout() {
        return mAbout;
    }

    private void setAbout(String about) {
        mAbout = about;
    }

    public String getCreated() {
        return mCreated;
    }

    private void setCreated(String created) {
        mCreated = created;
    }

    public String getWebUrl() {
        return mWebUrl;
    }

    private void setWebUrl(String webUrl) {
        mWebUrl = webUrl;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    private void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public int getRepos() {
        return mRepos;
    }

    private void setRepos(int repos) {
        mRepos = repos;
    }

    public int getGists() {
        return mGists;
    }

    private void setGists(int gists) {
        mGists = gists;
    }

    public int getFollowers() {
        return mFollowers;
    }

    private void setFollowers(int followers) {
        mFollowers = followers;
    }

    public int getFollowing() {
        return mFollowing;
    }

    private void setFollowing(int following) {
        mFollowing = following;
    }
}
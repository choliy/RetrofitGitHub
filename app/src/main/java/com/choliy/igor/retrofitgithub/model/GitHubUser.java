package com.choliy.igor.retrofitgithub.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GitHubUser implements Parcelable {

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
        setAvatarUrl(avatarUrl);
        setRepos(repos);
        setGists(gists);
        setFollowers(followers);
        setFollowing(following);
    }

    protected GitHubUser(Parcel in) {
        mUsername = in.readString();
        mFullName = in.readString();
        mCompany = in.readString();
        mLocation = in.readString();
        mEmail = in.readString();
        mAbout = in.readString();
        mCreated = in.readString();
        mAvatarUrl = in.readString();
        mRepos = in.readInt();
        mGists = in.readInt();
        mFollowers = in.readInt();
        mFollowing = in.readInt();
    }

    public static final Creator<GitHubUser> CREATOR = new Creator<GitHubUser>() {
        @Override
        public GitHubUser createFromParcel(Parcel in) {
            return new GitHubUser(in);
        }

        @Override
        public GitHubUser[] newArray(int size) {
            return new GitHubUser[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUsername);
        parcel.writeString(mFullName);
        parcel.writeString(mCompany);
        parcel.writeString(mLocation);
        parcel.writeString(mEmail);
        parcel.writeString(mAbout);
        parcel.writeString(mCreated);
        parcel.writeString(mAvatarUrl);
        parcel.writeInt(mRepos);
        parcel.writeInt(mGists);
        parcel.writeInt(mFollowers);
        parcel.writeInt(mFollowing);
    }
}
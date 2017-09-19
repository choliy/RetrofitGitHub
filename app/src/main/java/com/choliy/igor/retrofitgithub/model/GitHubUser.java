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

    private GitHubUser(Parcel in) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getAbout() {
        return mAbout;
    }

    public String getCreated() {
        return mCreated;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public int getRepos() {
        return mRepos;
    }

    public int getGists() {
        return mGists;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public int getFollowing() {
        return mFollowing;
    }
}
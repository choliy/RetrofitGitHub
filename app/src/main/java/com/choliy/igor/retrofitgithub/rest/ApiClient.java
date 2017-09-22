package com.choliy.igor.retrofitgithub.rest;

import com.choliy.igor.retrofitgithub.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://api.github.com/";
    private static Retrofit sRetrofit;

    public static Retrofit getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(addLoggingClient()) // (optional) for logging calls
                    .build();
        }
        return sRetrofit;
    }

    private static OkHttpClient addLoggingClient() {
        // create Http client
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        // create logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        // set type level of logs (how many info logs will show up)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // add interceptor only in debug mode for better performance in release version
        if (BuildConfig.DEBUG) okHttpClientBuilder.addInterceptor(loggingInterceptor);

        return okHttpClientBuilder.build();
    }
}
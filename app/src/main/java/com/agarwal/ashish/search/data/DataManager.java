package com.agarwal.ashish.search.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.agarwal.ashish.search.data.remote.ApiService;

@Singleton
public class DataManager {

    private final ApiService mApiService;

    @Inject
    public DataManager(ApiService apiService) {
        mApiService = apiService;
    }

    public ApiService getmApiService() {
        return mApiService;
    }
}

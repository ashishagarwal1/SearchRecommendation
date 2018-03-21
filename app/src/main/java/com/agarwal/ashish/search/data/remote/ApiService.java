package com.agarwal.ashish.search.data.remote;

import com.agarwal.ashish.search.OkHttpClientProvider;
import com.agarwal.ashish.search.data.remote.model.SearchResponse;
import com.agarwal.ashish.search.data.AppConstants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/users")
    Call<SearchResponse> getSearchResults(@Query("q") String params);

    class Creator {
        public static ApiService newApiService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(AppConstants.BASE_URL)
                    .client(new OkHttpClientProvider().getOkHttpClient())
                    .build();
            return retrofit.create(ApiService.class);
        }
    }
}

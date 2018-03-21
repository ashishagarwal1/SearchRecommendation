package com.agarwal.ashish.search.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashishaggarwal on 21/03/18.
 */

public class SearchResponse {

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean inCompleteResults;

    @SerializedName("items")
    private List<SearchData> searchData;

    public List<SearchData> getSearchData() {
        return searchData;
    }
}

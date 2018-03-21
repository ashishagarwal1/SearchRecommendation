package com.agarwal.ashish.search.ui.main;

import java.util.List;

import com.agarwal.ashish.search.data.remote.model.SearchData;
import com.agarwal.ashish.search.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void setErrorState();

    void setList(List<SearchData> searchData);
}

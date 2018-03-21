package com.agarwal.ashish.search.ui.main;

import android.text.TextUtils;
import android.util.Log;

import com.agarwal.ashish.search.data.remote.model.SearchData;
import com.agarwal.ashish.search.data.remote.model.SearchResponse;
import com.agarwal.ashish.search.data.remote.ApiService;
import com.agarwal.ashish.search.injection.ConfigPersistent;
import com.agarwal.ashish.search.ui.base.BasePresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import retrofit2.Call;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final ApiService apiService;

    private PublishSubject mSearchResultsSubject = PublishSubject.create();

    private DisposableObserver<SearchResponse> listDisposableObserver;

    @Inject
    public MainPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
        placeSearchOvservable();
    }

    private void placeSearchOvservable() {
        listDisposableObserver = (DisposableObserver<SearchResponse>) mSearchResultsSubject.debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(s -> {
                    Call call = apiService.getSearchResults(s.toString());
                    return call.execute().body();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<SearchResponse>() {

                    @Override
                    public void onNext(SearchResponse searchResponse) {
                        setDataOnUi(searchResponse.getSearchData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        listDisposableObserver.dispose();
                        e.printStackTrace();
                        setErrorState();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void setErrorState() {
        getMvpView().setErrorState();
    }

    public void searchdata(String key) {
        if (listDisposableObserver.isDisposed())
            placeSearchOvservable();
        if (!TextUtils.isEmpty(key)) {
            mSearchResultsSubject.onNext(key);
        }
    }


    private void setDataOnUi(List<SearchData> searchDataList) {
        getMvpView().setList(searchDataList);
    }

    @Override
    public void detachView() {

        Log.d("ashish1234", "detach");
        if (listDisposableObserver != null)
            listDisposableObserver.dispose();
        super.detachView();
    }

}

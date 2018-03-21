package com.agarwal.ashish.search.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.agarwal.ashish.search.R;
import com.agarwal.ashish.search.data.remote.model.SearchData;
import com.agarwal.ashish.search.data.remote.ApiService;
import com.agarwal.ashish.search.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @Inject
    SearchDataAdapter mSearchDataAdapter;

    @Inject
    ApiService mApiService;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.edit_text)
    EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        placeEditTextListener();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSearchDataAdapter);
        Log.d("ashish1234", mMainPresenter+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    private void placeEditTextListener() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mMainPresenter.searchdata(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void setErrorState() {
        Toast.makeText(this, getString(R.string.some_error_occured), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setList(List<SearchData> searchData) {
        mSearchDataAdapter.setSearchDataList(searchData);
    }
}

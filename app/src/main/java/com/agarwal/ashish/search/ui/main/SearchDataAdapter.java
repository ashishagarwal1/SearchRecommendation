package com.agarwal.ashish.search.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agarwal.ashish.search.R;
import com.agarwal.ashish.search.data.remote.model.SearchData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchDataAdapter extends RecyclerView.Adapter<SearchDataAdapter.SearchDataViewHolder> {


    private List<SearchData> searchDataList;

    @Inject
    public SearchDataAdapter() {
        searchDataList = new ArrayList<>();
    }

    public void setSearchDataList(List<SearchData> searchDataList) {
        this.searchDataList = searchDataList;
        notifyDataSetChanged();
    }

    @Override
    public SearchDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_data, parent, false);
        return new SearchDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SearchDataViewHolder holder, int position) {
        holder.nameTextView.setText(searchDataList.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return searchDataList.size();
    }

    class SearchDataViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name)
        TextView nameTextView;

        public SearchDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

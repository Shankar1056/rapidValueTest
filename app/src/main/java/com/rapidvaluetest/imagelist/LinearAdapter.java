package com.rapidvaluetest.imagelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rapidvaluetest.BR;
import com.rapidvaluetest.R;
import com.rapidvaluetest.databinding.LinearRowItemBinding;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {
    private List<ImageModelList> dataModelList;

    public LinearAdapter(List<ImageModelList> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public LinearAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearRowItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.linear_row_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.ViewHolder holder, int position) {
        ImageModelList imageModelList = dataModelList.get(position);
        holder.bind(imageModelList);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearRowItemBinding itemRowBinding;

        public ViewHolder(LinearRowItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.imagelistmodel, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}

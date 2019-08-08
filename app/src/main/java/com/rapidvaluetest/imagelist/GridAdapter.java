package com.rapidvaluetest.imagelist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rapidvaluetest.BR;
import com.rapidvaluetest.R;
import com.rapidvaluetest.databinding.GridRowLayoutBinding;
import com.rapidvaluetest.databinding.LinearRowItemBinding;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<ImageModelList> dataModelList;

    public GridAdapter(List<ImageModelList> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GridRowLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.grid_row_layout, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageModelList imageModelList = dataModelList.get(position);
        holder.bind(imageModelList);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public GridRowLayoutBinding itemRowBinding;

        public ViewHolder(GridRowLayoutBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.imagelistmodel, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}

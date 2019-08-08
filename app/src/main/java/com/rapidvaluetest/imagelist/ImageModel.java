package com.rapidvaluetest.imagelist;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.rapidvaluetest.BR;

import java.util.ArrayList;

public class ImageModel extends BaseObservable {

    @SerializedName("totalHits")
    public String totalHits;

    @SerializedName("hits")
    public ArrayList<ImageModelList> hits;

}

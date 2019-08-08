package com.rapidvaluetest.imagelist;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rapidvaluetest.remote.ApiServices;
import com.rapidvaluetest.remote.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImageViewModel extends ViewModel {

    MutableLiveData<ImageModel> data;

    public ImageViewModel(){
        data = new MutableLiveData<>();
        data = getImageList();
    }



    public MutableLiveData<ImageModel> getImageList() {

        ApiServices apiServices = RetroClass.getRetrofit().create(ApiServices.class);
        Call<ImageModel> imageCalll = apiServices.getImageList();
        imageCalll.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                Log.e("response error", t.getMessage());
            }
        });
        return data;
    }

    public MutableLiveData<ImageModel> getResponseVal(){
        return data;
    }
}

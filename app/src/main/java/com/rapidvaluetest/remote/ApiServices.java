package com.rapidvaluetest.remote;

import com.rapidvaluetest.imagelist.ImageModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("?key=13148476-1f6e7e6df91b8170023dfcfb0&q=yellow+flowers&image_type=photo&pretty=true")
    Call<ImageModel> getImageList();
}

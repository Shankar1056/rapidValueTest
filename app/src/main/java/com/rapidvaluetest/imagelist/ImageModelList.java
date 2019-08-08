package com.rapidvaluetest.imagelist;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class ImageModelList {
    @SerializedName("tags")
    public String tags;
    @SerializedName("likes")
    public String likes;
    @SerializedName("comments")
    public String comments;
    @SerializedName("user")
    public String user;
    @SerializedName("userImageURL")
    public String userImageURL;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }


    @BindingAdapter("userImageURL")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())
                .into(view);
    }

}

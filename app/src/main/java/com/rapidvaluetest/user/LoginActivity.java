package com.rapidvaluetest.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.rapidvaluetest.imagelist.ImageListActivity;
import com.rapidvaluetest.R;
import com.rapidvaluetest.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginResultCallBacks {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        activityLoginBinding.setViewModel(ViewModelProviders.of(
                this, new LoginViewModelFactory(this))
                .get(LoginViewModel.class));

    }

    @Override
    public void success() {

        startActivity(new Intent(LoginActivity.this, ImageListActivity.class));
        finish();
    }

    @Override
    public void fail(String errorMessage) {
        Toast.makeText(this, "" + errorMessage, Toast.LENGTH_SHORT).show();
    }
}

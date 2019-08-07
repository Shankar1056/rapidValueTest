package com.rapidvaluetest.user;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

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
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail() {
        Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
    }
}

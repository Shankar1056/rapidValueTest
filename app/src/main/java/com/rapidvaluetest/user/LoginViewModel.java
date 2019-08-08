package com.rapidvaluetest.user;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;

import androidx.lifecycle.ViewModel;

import com.rapidvaluetest.SharedPrefernce;
import com.rapidvaluetest.SplashActivity;

public class LoginViewModel extends ViewModel {

    private LoginModel userModel;
    private LoginResultCallBacks loginResultCallBacks;

    public LoginViewModel(LoginResultCallBacks loginResultCallBacks) {
        this.loginResultCallBacks = loginResultCallBacks;
        this.userModel = new LoginModel();
    }

    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                userModel.setEmailId(editable.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                userModel.setPassword(editable.toString());
            }
        };
    }

    public void onClicked(View view) {
        if (userModel.getEmailId() == null || userModel.getEmailId().equalsIgnoreCase("")) {
            loginResultCallBacks.fail("Email id can't be blank");
        } else if (!Utils.isValidEmail1(userModel.getEmailId())) {
            loginResultCallBacks.fail("Email id is incorrect");
        } else if (userModel.getPassword() == null || userModel.getPassword().equalsIgnoreCase("")) {
            loginResultCallBacks.fail("Password can't be blank");
        } else if (userModel.getPassword().trim().length() < 5) {
            loginResultCallBacks.fail("Password must be 6 character");
        } else {
            loginResultCallBacks.success();
        }
    }

    public void onCheckedChanged(View v) {
        SharedPrefernce.setPreferences(SplashActivity.LOGINSTATUS, ((CheckBox) v).isChecked());
    }

}

package com.rapidvaluetest.user;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    private LoginResultCallBacks loginResultCallBacks ;

    public LoginViewModelFactory(LoginResultCallBacks loginResultCallBacks ){
        this.loginResultCallBacks = loginResultCallBacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginResultCallBacks);
    }
}

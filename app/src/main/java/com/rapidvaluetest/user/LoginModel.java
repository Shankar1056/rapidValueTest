package com.rapidvaluetest.user;

import androidx.databinding.BaseObservable;

public class LoginModel extends BaseObservable {

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String emailId, password;

   /* public LoginModel(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }*/


    /*public boolean isEmailValid() {
        return Utils.isValidEmail1(getEmailId());
    }


    public boolean isPasswordValid() {
        return getPassword().length() > 5;
    }
*/
}

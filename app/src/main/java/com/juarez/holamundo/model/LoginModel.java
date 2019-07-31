package com.juarez.holamundo.model;

import android.util.Log;

import com.juarez.holamundo.presenter.ILoginPresenter;

public class LoginModel implements ILoginModel {
    private String TAG = "LoginModel";
    private ILoginPresenter presenter;

    public LoginModel(ILoginPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void Login(String username, String password) {
        Log.e(TAG,"-> MODELO O INTERACTOR");

        if(username.equals("jose") && password.equals("123456"))
            presenter.showLoginResult("Success Login");
        else
            presenter.showLoginResult("Failure Login");
    }
}

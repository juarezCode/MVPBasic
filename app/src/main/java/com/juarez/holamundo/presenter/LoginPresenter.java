package com.juarez.holamundo.presenter;

import android.util.Log;

import com.juarez.holamundo.model.ILoginModel;
import com.juarez.holamundo.model.LoginModel;
import com.juarez.holamundo.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    private String TAG = "LoginPresenter";
    private ILoginView View;
    private ILoginModel model;

    public LoginPresenter(ILoginView view){
        this.View = view;
        model = new LoginModel(this);

    }


    @Override
    public void login(String username, String password) {
        Log.e(TAG,"-> PRESENTADOR");
        model.Login(username,password);

    }

    @Override
    public void showLoginResult(String result) {
        Log.e(TAG,"<- PRESENTADOR");
        View.showLoginResult(result);

    }
}

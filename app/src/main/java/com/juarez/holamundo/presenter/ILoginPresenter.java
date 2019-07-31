package com.juarez.holamundo.presenter;

public interface ILoginPresenter {
    void login(String username , String password);
    void showLoginResult(String result);
}

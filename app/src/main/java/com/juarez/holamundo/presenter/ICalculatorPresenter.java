package com.juarez.holamundo.presenter;

public interface ICalculatorPresenter {
    void showResult(String result);
    void alCuadrado(String data);
    //void showError(String error);
    void add(String number1, String number2);
    void substraction(String number1, String number2);
    void divide(String number1, String number2);
    void multiplication(String number1, String number2);
    void root(String number1);

}

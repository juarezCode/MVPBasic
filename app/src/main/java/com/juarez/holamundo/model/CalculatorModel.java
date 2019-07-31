package com.juarez.holamundo.model;

import android.util.Log;

import com.juarez.holamundo.presenter.ICalculatorPresenter;

public class CalculatorModel implements ICalculatorModel {
    private String  TAG = "CalculatorModel";
    private ICalculatorPresenter presenter;
    private double resultado;

    public CalculatorModel(ICalculatorPresenter presenter){
        Log.e(TAG,"Modelo");
        this.presenter = presenter;
    }

    @Override
    public void alCuadrado(String data) {
        resultado = Double.valueOf(data)*Double.valueOf(data);
        presenter.showResult(String.valueOf(resultado));


    }

    @Override
    public void add(String number1, String number2) {
        Log.e(TAG,"-> CAPA MODELO O INTERACTOR");
        resultado = Double.valueOf(number1)+Double.valueOf(number2);
        presenter.showResult(String.valueOf(resultado));

    }

    @Override
    public void substraction(String number1, String number2) {
            resultado = Double.valueOf(number1)-Double.valueOf(number2);
            presenter.showResult(String.valueOf(resultado));

    }

    @Override
    public void divide(String number1, String number2) {
        resultado = Double.valueOf(number1)/Double.valueOf(number2);
        presenter.showResult(String.valueOf(resultado));
    }

    @Override
    public void multiplication(String number1, String number2) {
        resultado = Double.valueOf(number1)*Double.valueOf(number2);
        presenter.showResult(String.valueOf(resultado));
    }

    @Override
    public void root(String number1) {
        Log.e(TAG,number1);
        resultado = Math.sqrt(Double.valueOf(number1));
        presenter.showResult(String.valueOf(resultado));
     }
}

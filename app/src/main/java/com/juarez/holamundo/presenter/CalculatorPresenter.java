package com.juarez.holamundo.presenter;

import android.util.Log;

import com.juarez.holamundo.model.CalculatorModel;
import com.juarez.holamundo.view.ICalculatorView;
import com.juarez.holamundo.model.ICalculatorModel;

public class CalculatorPresenter implements ICalculatorPresenter {
    private String TAG = "CalculatorPresenter";
    private ICalculatorView view;
    private ICalculatorModel model;

    public CalculatorPresenter(ICalculatorView view){
        Log.e(TAG,"Presentador");
        this.view = view;
        model = new CalculatorModel(this);
    }

    @Override
    public void alCuadrado(String data) {
            model.alCuadrado(data);
    }


    @Override
    public void add(String number1, String number2) {
        Log.e(TAG,"-> CAPA PRESENTADOR");
            model.add(number1,number2);
    }

    @Override
    public void substraction(String number1, String number2) {
            model.substraction(number1,number2);
    }

    @Override
    public void divide(String number1, String number2) {
        model.divide(number1,number2);
    }

    @Override
    public void multiplication(String number1, String number2) {
        model.multiplication(number1,number2);
    }

    @Override
    public void root(String number1) {
        model.root(number1);
    }

    @Override
    public void showResult(String result) {
        Log.e(TAG,"<- CAPA PRESENTADOR");
            view.showResult(result);


    }
}

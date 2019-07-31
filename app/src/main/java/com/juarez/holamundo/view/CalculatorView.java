package com.juarez.holamundo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juarez.holamundo.presenter.CalculatorPresenter;
import com.juarez.holamundo.presenter.ICalculatorPresenter;
import com.juarez.holamundo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorView extends AppCompatActivity implements ICalculatorView {
    private String TAG = "CalculatorView";
    private ICalculatorPresenter presenter;
    private  boolean isEmpty;
    @BindView(R.id.edtNumber1)
    EditText edtNumber1;
    @BindView(R.id.edtAlCuadrado)
    EditText edtNumber2;
    @BindView(R.id.txtAlCuadrado)
    TextView txtResult;
    @BindView(R.id.btnDivide)
    Button btnDivide;
    @BindView(R.id.btnMulti)
    Button btnMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
        presenter = new CalculatorPresenter(this);
        Log.e(TAG, "Vista");

        //onClick desde onCreate
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumber1.getText().length() == 0) {
                    showError("number 1 its necessary");
                } else if (edtNumber2.getText().length() == 0){
                    showError("number 2 its necessary");
                }else
                    presenter.divide(edtNumber1.getText().toString(), edtNumber2.getText().toString());
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumber1.getText().length() == 0) {
                    showError("number 1 its necessary");
                } else if (edtNumber2.getText().length() == 0){
                    showError("number 2 its necessary");
                }else
                    presenter.multiplication(edtNumber1.getText().toString(), edtNumber2.getText().toString());
            }
        });
    }

    //onClick desde XMl propiedad onClick de Boton
    public void exp2(View view) {
        if(edtNumber1.getText().length() == 0)
            showError("number 2 its necessary");
        else
            presenter.alCuadrado(edtNumber1.getText().toString());
    }

    public void add(View view) {
        Log.e(TAG,"-> CAPA VISTA");
        if (edtNumber1.getText().length() == 0) {
            showError("number 1 its necessary");
        } else if (edtNumber2.getText().length() == 0){
            showError("number 2 its necessary");
        }else
            presenter.add(edtNumber1.getText().toString(), edtNumber2.getText().toString());
    }

    public void substraction(View view) {
        if (edtNumber1.getText().length() == 0) {
            showError("number 1 its necessary");
        } else if (edtNumber2.getText().length() == 0){
            showError("number 2 its necessary");
        }else
            presenter.substraction(edtNumber1.getText().toString(), edtNumber2.getText().toString());
    }

    public  void root(View view){
        if (edtNumber1.getText().length() == 0) {
            showError("number 1 its necessary");
        }else
            presenter.root(edtNumber1.getText().toString());
    }

    @Override
    public void showResult(String result) {
        Log.e(TAG,"<- CAPA VISTA");
        txtResult.setText(result);
    }

    public void screen2(View view){
        //solo envia a segunda pantalla
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}

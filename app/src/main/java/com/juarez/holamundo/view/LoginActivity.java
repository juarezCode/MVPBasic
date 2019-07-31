package com.juarez.holamundo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.juarez.holamundo.R;
import com.juarez.holamundo.presenter.ILoginPresenter;
import com.juarez.holamundo.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private ILoginPresenter loginPresenter;
    private String TAG = "LoginActivity";
    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.edtPass)
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void validatedField(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }


    public void login(View view) {
        Log.e(TAG,"-> VISTA");
        if(edtUsername.getText().length() == 0) {
            validatedField("write an username");
        }else if(edtPassword.getText().length() == 0) {
            validatedField("write password");
        }else
            loginPresenter.login(edtUsername.getText().toString(),edtPassword.getText().toString());
    }

    @Override
    public void showLoginResult(String result) {
        Log.e(TAG,"<- VISTA");
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}

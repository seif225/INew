package com.example.inew.LogIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.inew.R;

public class LogInActivity extends AppCompatActivity implements  ILoginActivity{
    private EditText mailEt,passwordEt;
    private String mail,password;
    private Button login;
    private LogInPresenter logInPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initializeFields();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEmptyEditTextsAndLogin();
            }
        });


    }
    @Override
     public void initializeFields() {
        logInPresenter=new LogInPresenter(this);
        login=findViewById(R.id.login_button_LoginActivity);
        mailEt=findViewById(R.id.login_email_et);
        passwordEt=findViewById(R.id.login_password_et);
    }

    @Override
    public void handleEmptyEditTextsAndLogin(){
        mail = mailEt.getText().toString().trim();
        password=passwordEt.getText().toString();

        if(mail.isEmpty()){

            mailEt.setError("you cant leave this field empty");

        }
        else if (password.isEmpty()){
            passwordEt.setError("you can't leave this empty");

        }
        else {

            logInPresenter.signIn(mail,password);
        }
    };
}

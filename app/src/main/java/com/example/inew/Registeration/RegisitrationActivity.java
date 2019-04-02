package com.example.inew.Registeration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.inew.R;
import com.google.firebase.FirebaseApp;

public class RegisitrationActivity extends AppCompatActivity {
        private EditText mailEt,passWordEt;
        private Button signInButton;
        String mail,password;
        private RegistrationPresenter registrationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisitration);
        FirebaseApp.initializeApp(this);
        intializeFields();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMailAndPassword();
                if(mail.trim().isEmpty()){
                    mailEt.setText("you cant leave this field Empty");
                }
                else if(password.trim().isEmpty()){
                    passWordEt.setError("you can't leave this field empty");
                }
                else{
                registrationPresenter.createNewUser(mail,password);
                }
            }
        });
    }

    private void getMailAndPassword() {
        mail=mailEt.getText().toString();
        password=passWordEt.getText().toString();
    }

    private void intializeFields() {
        mailEt=findViewById(R.id.mail_register);
        passWordEt=findViewById(R.id.password_register);
        signInButton=findViewById(R.id.regist_button);
    registrationPresenter = new RegistrationPresenter(this);
    }
}

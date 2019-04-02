package com.example.inew.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inew.LogIn.LogInActivity;
import com.example.inew.R;
import com.example.inew.Registeration.RegisitrationActivity;
import com.example.inew.Registeration.RegistrationPresenter;

public class splashActivity extends AppCompatActivity {
    Button loginButton,regisButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intilalizeFields();



    }

    private void intilalizeFields() {
    loginButton=findViewById(R.id.login);
    regisButton=findViewById(R.id.register);
    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), LogInActivity.class) );
        }
    });
    regisButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), RegisitrationActivity.class) );

        }
    });

    }
}

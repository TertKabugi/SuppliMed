package com.king.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Activity_Login extends AppCompatActivity {


    EditText mName, mPass;
    Button mBtnLogin, mBtnSign, mBtnForgot;
    RelativeLayout rellay1,rellay2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
        rellay1.setVisibility(View.VISIBLE);
        rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
        mBtnLogin = findViewById(R.id.btnLogIn);
        mBtnSign = findViewById(R.id.btnSignup);
        mBtnForgot = findViewById(R.id.btnForgot);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_Login.this,Navbar.class);
                startActivity(i);
            }
        });
        mBtnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(Activity_Login.this,RegistrationActivity.class);
                startActivity(n);
            }
        });
        mBtnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(Activity_Login.this,PasswordActivity.class);
                startActivity(t);
            }
        });
        mName = findViewById(R.id.edtName);
        mPass = findViewById(R.id.edtPass);
        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);

        handler.postDelayed(runnable,2000);

    }
}

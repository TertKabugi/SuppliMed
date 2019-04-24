package com.king.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText mName, mEmail, mPassword, mPassword1;
    Button mBtnRegister;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mName = findViewById(R.id.edtName);
        mEmail = findViewById(R.id.edtMail);
        mPassword = findViewById(R.id.edtPass);
        mPassword1 = findViewById(R.id.edtPass1);
        mBtnRegister = findViewById(R.id.btnReg);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please wait...");

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CREATE A UNIQUE VALUE TO FORM THE TABLE ROW
                long time = System.currentTimeMillis();

                //CREATE ATABLE CALLED USERS IN THE DATABASE
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users/"+time);

                //CHECK IF THE USER HAS ENTERD ALL THE DETAILS
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String password1 = mPassword1.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || password1.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Fill in all input", Toast.LENGTH_SHORT).show();
                }else {
                    //THE CODE TO SAVE INTO THE DATABASE
                    User mtu = new User(name,email,password,String.valueOf(time));
                    dialog.show();
                    ref.setValue(mtu).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                mEmail.setText("");
                                mName.setText("");
                                mPassword.setText("");
                                mPassword1.setText("");
                            }else {
                                Toast.makeText(RegistrationActivity.this, "Saving Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getApplicationContext(),UsersActivity.class);
                startActivity(view);
            }
        });
    }
}

package com.example.yum1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    //variables
    private FirebaseAuth mAuth;
    private Database db;

    private String email,password;
    EditText emailEt, passwordEt;
    Button loginBtn,forgotBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //init db
        db = new Database();

        //connect to widget
        emailEt = findViewById(R.id.etEmail);
        passwordEt = findViewById(R.id.etPass);
        loginBtn = findViewById(R.id.BtnLogIn);
        forgotBtn = findViewById(R.id.forgotPassBtn);
        signUpBtn = findViewById(R.id.gotoSignUpBtn);

        //button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from edit text
                email = emailEt.getText().toString();
                password = passwordEt.getText().toString();

                if(email!="" && password!="")
                {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(Login.this, "Welcome Back!",
                                                Toast.LENGTH_SHORT).show();

                                        FirebaseUser user = mAuth.getCurrentUser();
                                        db.readUser(user.getUid());
                                        db.readRestaurants();

                                        //Intent
                                        Intent myIntent = new Intent(Login.this, LoadingScreen.class);
                                        Login.this.startActivity(myIntent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
                else
                {
                    //Toast
                    Toast.makeText(Login.this, "Please complete all fields",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Login.this, Signup.class);
                Login.this.startActivity(myIntent);
            }
        });

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Login.this, ForgotPassword.class);
                Login.this.startActivity(myIntent);
            }
        });
    }

}
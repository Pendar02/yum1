package com.example.yum1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Signup extends AppCompatActivity {

    //variables
    private FirebaseAuth mAuth;
    private Database db;

    private String email,password, name, confirmpass, address;
    EditText emailEt, passwordEt,confirmpasswordET, nameET, addressEt;
    Button signupBtn,loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //init db
        db = new Database();

        //connect to widget
        emailEt = findViewById(R.id.etEmailSignup);
        passwordEt = findViewById(R.id.etPassSignup);
        confirmpasswordET = findViewById(R.id.etConfirmPassSignup);
        nameET = findViewById(R.id.etNameSignUp);
        addressEt = findViewById(R.id.etAddressSignup);
        signupBtn = findViewById(R.id.BtnSignup);
        loginBtn = findViewById(R.id.backtoLoginbtn);


        //buttons
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data
                email = emailEt.getText().toString();
                name = nameET.getText().toString();
                password = passwordEt.getText().toString();
                confirmpass = confirmpasswordET.getText().toString();
                address = addressEt.getText().toString();

                //check for all data
                if(email!="" && password!="" && name!=""&& confirmpass!=""&& address!="")
                {
                    //check for password
                    if (password.equals(confirmpass))
                    {
                        //signup
                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information

                                            Toast.makeText(Signup.this, "Successful!",
                                                    Toast.LENGTH_SHORT).show();

                                            FirebaseUser user = mAuth.getCurrentUser();
                                            db.updateUser(new User(
                                                    user.getUid(), name, email, address,
                                                    new ArrayList<String>(),new ArrayList<String>())
                                            );
                                            db.readUser(user.getUid());
                                            db.readRestaurants();

                                            //Intent
                                            Intent myIntent = new Intent(Signup.this, LoadingScreen.class);
                                            Signup.this.startActivity(myIntent);

                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(Signup.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });
                    }
                    else
                    {
                        //Toast
                        Toast.makeText(Signup.this, "Passwords don't match!",
                                Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    //Toast
                    Toast.makeText(Signup.this, "Please complete all fields",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup.this.finish();
            }
        });
    }
}
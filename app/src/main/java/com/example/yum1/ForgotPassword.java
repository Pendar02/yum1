package com.example.yum1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    //variables
    private FirebaseAuth mAuth;
    private Database db;

    private String email;
    EditText emailEt;
    Button BTNsendEmail;
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //init db
        db = new Database();

        //connect to widget
        emailEt = findViewById(R.id.etEmailForgot);
        BTNsendEmail = findViewById(R.id.BtnSendEmail);
        backBtn = findViewById(R.id.forgotBackbtn);


        //buttons
        BTNsendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data
                email = emailEt.getText().toString();

                //check for all data
                if (email != "") {
                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        //Toast
                                        Toast.makeText(ForgotPassword.this, "Email sent!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    //Toast
                    Toast.makeText(ForgotPassword.this, "Please fill the box!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPassword.this.finish();
            }
        });
    }

}

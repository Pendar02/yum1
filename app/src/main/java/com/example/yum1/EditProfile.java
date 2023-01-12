package com.example.yum1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class EditProfile extends AppCompatActivity {

    //variables
    private FirebaseAuth mAuth;
    private Database db;

    private String email, name, address;
    EditText emailEt, nameEt, addressEt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Initialize Firebase Auth
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User updatingUser = Globals.user;

        //init db
        db = new Database();

        //connect to widget
        emailEt = findViewById(R.id.newEmail);
        nameEt = findViewById(R.id.newName);
        addressEt = findViewById(R.id.newAddress);
        saveBtn = findViewById(R.id.BtnSave);


        //button
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from edit text
                email = emailEt.getText().toString();
                name = nameEt.getText().toString();
                address = addressEt.getText().toString();

                if(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    //Firestore
                    updatingUser.setName(name);
                    updatingUser.setEmail(email);
                    updatingUser.setAddress(address);
                    db.updateUser(updatingUser);

                    //Authentication
                    user.updateEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        //toast
                                    }
                                }
                            });
                }

                else {
                    //toast
                }
                


            }
        });
    }
}
//package com.example.yum1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.google.firebase.auth.FirebaseAuth;
//
//public class Profile extends AppCompatActivity {
//
//    //variables
//    private FirebaseAuth mAuth;
//    private Database db;
//
//    private String email,name,address;
//    TextView emailTv,nameTv,addressTv;
//    Button editBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        emailTv = findViewById(R.id.existingEmail);
//        nameTv = findViewById(R.id.existingName);
//        addressTv = findViewById(R.id.existingAddress);
//        editBtn = findViewById(R.id.BtnEditProfile);
//
//        nameTv.setText(Globals.user.getName());
//        emailTv.setText(Globals.user.getName());
//        addressTv.setText(Globals.user.getName());
//
//
//    }
//}
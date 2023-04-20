package com.knit.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {
        EditText editTextEmail,editTextPasswd;
        Button submitBtn;
        FirebaseAuth mAuth;
        ProgressBar progressBar;
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView login=findViewById(R.id.pass_login_from_signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myint= new Intent(getApplicationContext(), login.class);
                startActivity(myint);
                finish();
            }
        });
        mAuth = FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.email);
        editTextPasswd=findViewById(R.id.passwd);
        submitBtn=findViewById(R.id.submitButton);
        progressBar=findViewById(R.id.progressBar);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;
                email=String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPasswd.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(register.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(register.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {


                                    Toast.makeText(register.this, "account created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent myint= new Intent(getApplicationContext(), login.class);
                                    startActivity(myint);
                                    finish();


                                } else {


                                    Toast.makeText(register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });



    }
}
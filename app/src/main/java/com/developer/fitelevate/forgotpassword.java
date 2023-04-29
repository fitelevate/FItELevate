package com.developer.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {


    private Button forgotBtn;
    private EditText txtEmail;
    private String email;
    private FirebaseAuth auth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        auth=FirebaseAuth.getInstance();

        txtEmail=findViewById(R.id.email);
        forgotBtn=findViewById(R.id.forgotButton);
        progressBar=findViewById(R.id.progressBar);
        forgotBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                validateData();
            }

            private void validateData() {
                email=txtEmail.getText().toString();
                if(email.isEmpty()){
                    txtEmail.setError("Required");
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    forgetPass();
                }
            }

            private void forgetPass() {
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(forgotpassword.this, "Check Your Mail", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),login.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(forgotpassword.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        TextView forgotpassword=findViewById(R.id.login);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myint= new Intent(getApplicationContext(), login.class);
                startActivity(myint);
                finish();
            }

        });
    }
}
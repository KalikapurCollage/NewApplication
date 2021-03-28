 package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpFullNameEditText, signUpEmailEditText, signUpPasswordEditText, signUpConfirmPasswordEditText;
    private Button registerButton, loginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        signUpFullNameEditText = findViewById(R.id.signUpFullNameEditTextId);
        signUpEmailEditText = findViewById(R.id.signUpEmailEditTextId);
        signUpPasswordEditText = findViewById(R.id.signUpPasswordEditTextId);
        signUpConfirmPasswordEditText = findViewById(R.id.signUpConfirmPasswordEditTextId);
        registerButton = findViewById(R.id.registerButtonId);
        loginButton = findViewById(R.id.loginButtonId);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.registerButtonId:
                userRegister();
                break;

            case R.id.loginButtonId:
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                break;
        }

    }

    private void userRegister() {
        String fullName = signUpFullNameEditText.getText().toString().trim();
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();
        String confirmPassword = signUpConfirmPasswordEditText.getText().toString().trim();

        //checking the validity of the email
        if(fullName.isEmpty())
        {
            signUpFullNameEditText.setError("Full Name");
            signUpFullNameEditText.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Email Address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter Valid Email");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter an password address");
            signUpPasswordEditText.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            signUpEmailEditText.setError("Minimum length of a password should be 6");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(confirmPassword.isEmpty())
        {
            signUpConfirmPasswordEditText.setError("Enter an password address");
            signUpConfirmPasswordEditText.requestFocus();
            return;
        }

        if(!password.equals(confirmPassword)){
            signUpConfirmPasswordEditText.setError("Password Do not Match.");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                 {
                     Toast.makeText(getApplicationContext(),"Register is Successful.",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                     finish();
                 }
                else {
                     if(task.getException() instanceof FirebaseAuthUserCollisionException)
                     {
                         Toast.makeText(getApplicationContext(),"User is already Registered.",Toast.LENGTH_SHORT).show();
                     }else{
                         Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 }
            }
        });
    }
}
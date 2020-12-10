package com.example.transpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInCustomer extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    EditText Email,password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_customer);

        mAuth=FirebaseAuth.getInstance();
        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
        Email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

    }

    private void userLogin(){
        String mail=Email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if (mail.isEmpty()){
            Email.setError("email required");
            Email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            Email.setError("enter a valid email");
            Email.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            password.setError("password required");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Intent i =new Intent(SignInCustomer.this,VoyageListss.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView2:
                startActivity(new Intent(this,SignUpCustomer.class));
                break;
            case  R.id.button:
                userLogin();
                break;
        }
    }
}

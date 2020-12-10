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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpCustomer extends AppCompatActivity implements View.OnClickListener {
    EditText Name,Email,password,phone;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference reff;
    long mix=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_customer);
        Name=(EditText)findViewById(R.id.NameField);
        Email=(EditText)findViewById(R.id.MailField);
        password=(EditText)findViewById(R.id.PassField);
        phone=(EditText)findViewById(R.id.PhoneField);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        mAuth=FirebaseAuth.getInstance();


        findViewById(R.id.Signup_btn).setOnClickListener(this);
    }
    private void registerUser(){
        String name=Name.getText().toString().trim();
        String mail=Email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        String ph=phone.getText().toString().trim();

        if (name.isEmpty()){
            Name.setError("name required");
            Name.requestFocus();
            return;
        }
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

        if (ph.isEmpty()){
            phone.setError("phone is required");
            phone.requestFocus();
            return;
        }
        if (ph.length() !=8){
            phone.setError("enter a valid phone number");
            phone.requestFocus();
            return;
        }
        final CTmer customer=new CTmer();
        reff= FirebaseDatabase.getInstance().getReference().child("Customers");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    mix=dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Long Tph=Long.parseLong(phone.getText().toString().trim());
        customer.setMail(mail);
        customer.setName(name);
        customer.setPassword(pass);
        customer.setPhone(Tph);
        //reff.push().setValue(transporter);


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    reff.child(String.valueOf(FirebaseAuth.getInstance().getCurrentUser().getUid())).setValue(customer);
                    Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(SignUpCustomer.this,VoyageListss.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"you are already registered",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),task.getException() .getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Signup_btn:
                registerUser();
                break;

        }
    }
}

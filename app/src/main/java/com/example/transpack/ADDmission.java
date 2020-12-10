package com.example.transpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ADDmission extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText DDate,ADate,Price;
    Spinner spin1,spin2;
    String text1,text2;
    View o;
    Button btnSave;
    FirebaseUser user;
    String uid;
    DatabaseReference reff;
    long maxid=0;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmission);
        o=(View)findViewById(R.id.o);
        //o.getBackground().setAlpha(30);
        spin1=(Spinner)findViewById(R.id.spinner1);
        spin2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.cities,android.R.layout.simple_spinner_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spin1.setAdapter(adapter);
         spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 text1=parent.getItemAtPosition(position).toString();
                // Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.cities,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter1);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text2=parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(),text2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        DDate=(EditText)findViewById(R.id.DD);
        ADate=(EditText)findViewById(R.id.AD);
        Price=(EditText)findViewById(R.id.P);
        btnSave=(Button)findViewById(R.id.btn);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        final Voyages Voyy=new Voyages();
        mDatabase=FirebaseDatabase.getInstance().getReference().child("Transporters").child(uid);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String TransN=dataSnapshot.child("name").getValue().toString();
                final String TransP=dataSnapshot.child("phone").getValue().toString();
                reff= FirebaseDatabase.getInstance().getReference().child("Voyages");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists())
                        {

                            maxid=dataSnapshot.getChildrenCount();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Float Pri=Float.parseFloat(Price.getText().toString().trim());
                        //Voyy.setPaysdepart(DPlace.getText().toString().trim());
                        //Voyy.setPaysarrivee(APlace.getText().toString().trim());
                        Voyy.setDatedepart(DDate.getText().toString().trim());
                        Voyy.setPaysdepart(text1);
                        Voyy.setPaysarrivee(text2);
                        Voyy.setDatearrivee(ADate.getText().toString().trim());
                        Voyy.setPrix(Pri);
                        Voyy.setName(TransN);
                        Voyy.setPhone(Long.valueOf(TransP));
                        reff.child(String.valueOf(maxid+1)).setValue(Voyy);
                        Toast.makeText(ADDmission.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(ADDmission.this,VoyageListss.class);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



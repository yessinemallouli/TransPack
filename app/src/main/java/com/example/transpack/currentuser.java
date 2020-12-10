package com.example.transpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class currentuser extends AppCompatActivity {
    private RecyclerView mVoyList;
    private DatabaseReference mDatabase;
    DatabaseReference reff;
    FirebaseUser user;
    String uid;
    TextView name,oui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentuser);


        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        reff = FirebaseDatabase.getInstance().getReference().child("Transporters").child(uid);

        name = (TextView) findViewById(R.id.hisname);
        oui = (TextView) findViewById(R.id.ouiss);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String naming=dataSnapshot.child("phone").toString().trim();
                name.setText(naming);
                oui.setText(uid);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //mdatareference=FirebaseDatabase.getInstance().getReference().child("Transporters").child(uid);
        //final String n=mdatareference.
        //mdatareference.addValueEventListener(new ValueEventListener() {
        //  @Override
        //  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //     String naming= dataSnapshot.child("name").toString().trim();
//
        //   name.setText(naming);
        //  ouiss.setText(uid);
        //}

        //@Override
        //  public void onCancelled(@NonNull DatabaseError databaseError) {

        //    }
        //  });
    }
}

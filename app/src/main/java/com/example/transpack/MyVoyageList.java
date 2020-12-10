package com.example.transpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.String.valueOf;

public class MyVoyageList extends AppCompatActivity {

    private RecyclerView mVoyList;
    private DatabaseReference mDatabase;
    DatabaseReference reff;
    FirebaseUser user;
    String uid;
    String naming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voyage_list);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Voyages");
        mDatabase.keepSynced(true);
        mVoyList = (RecyclerView) findViewById(R.id.myrecycleview);
        mVoyList.setHasFixedSize(true);
        mVoyList.setLayoutManager(new LinearLayoutManager(this));
        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        reff=FirebaseDatabase.getInstance().getReference().child("Transporters").child(uid);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 naming = dataSnapshot.child("phone").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();



                         FirebaseRecyclerAdapter<Voyages, VoyViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Voyages, VoyViewHolder>(Voyages.class, R.layout.voyage_row, VoyViewHolder.class, mDatabase) {
                            @Override
                            protected void populateViewHolder(VoyViewHolder voyViewHolder, Voyages voyages, int i) {

                                if (voyages.getPhone()!=Long.parseLong(naming)){
                                    voyViewHolder.itemView.setVisibility(View.GONE);
                                    voyViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
                                }
                            voyViewHolder.setDP(voyages.getPaysdepart());
                                voyViewHolder.setAP(voyages.getPaysarrivee());
                                voyViewHolder.setDD(voyages.getDatedepart());
                                voyViewHolder.setAD(voyages.getDatearrivee());
                                voyViewHolder.setP(voyages.getPrix());
                                voyViewHolder.setName(voyages.getName());
                                voyViewHolder.setPh(voyages.getPhone());

                            }

                        };

                        mVoyList.setAdapter(firebaseRecyclerAdapter);





            }


        }

package com.example.transpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VoyageListss extends AppCompatActivity {

    private RecyclerView mVoyList;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voyage_listss);
        RelativeLayout relativeLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Voyages");
        mDatabase.keepSynced(true);
        mVoyList = (RecyclerView) findViewById(R.id.myrecycleview);
        mVoyList.setHasFixedSize(true);
        mVoyList.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Voyages,VoyViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Voyages, VoyViewHolder>(Voyages.class, R.layout.voyage_row, VoyViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(VoyViewHolder voyViewHolder, Voyages voyages, int i) {

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

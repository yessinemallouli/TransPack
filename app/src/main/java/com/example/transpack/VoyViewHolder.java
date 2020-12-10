package com.example.transpack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class VoyViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public VoyViewHolder(View itemView){
        super(itemView);
        mView=itemView;
    }
    public void setDP(String DP){
        TextView textViewDP=(TextView)mView.findViewById(R.id.textViewDP);
        textViewDP.setText(DP);
    }
    public void setAP(String AP){
        TextView textViewAP=(TextView)mView.findViewById(R.id.textViewAP);
        textViewAP.setText(AP);
    }
    public void setDD(String DD){
        TextView textViewDD=(TextView)mView.findViewById(R.id.textViewDD);
        textViewDD.setText(DD);
    }
    public void setAD(String AD){
        TextView textViewAD=(TextView)mView.findViewById(R.id.textViewAD);
        textViewAD.setText(AD);
    }
    public void setP(Float P){
        TextView textViewP=(TextView)mView.findViewById(R.id.textViewP);
        textViewP.setText(String.valueOf(P));
    }

    public void setName(String Name){
        TextView textViewTN=(TextView)mView.findViewById(R.id.textViewTN);
        textViewTN.setText(Name);
    }
    public void setPh(Long Ph){
        TextView textViewTP=(TextView)mView.findViewById(R.id.textViewTP);
        textViewTP.setText(String.valueOf(Ph));
    }

}
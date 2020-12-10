package com.example.transpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOption extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        findViewById(R.id.Btn1).setOnClickListener(this);
        findViewById(R.id.Btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btn1:
                startActivity(new Intent(this,ADDmission.class));
                break;
            case R.id.Btn2:
                startActivity(new Intent(this,MyVoyageList.class));
                break;
        }
    }

}

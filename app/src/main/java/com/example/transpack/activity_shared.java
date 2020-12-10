package com.example.transpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class activity_shared extends AppCompatActivity {
    View pp;

    Button btn_2, btn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        pp=(View)findViewById(R.id.pp);

        pp.getBackground().setAlpha(200);
        btn_1=(Button)findViewById(R.id.btn1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(activity_shared.this,SignInCustomer.class);
                startActivity(i);
            }
        });
        btn_2=(Button)findViewById(R.id.btn2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(activity_shared.this,SignIn.class);
                startActivity(i);
            }
        });

    }

}

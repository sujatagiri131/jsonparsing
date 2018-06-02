package com.android.jsontraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Draw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        String name = getIntent().getExtras().getString("name");
        String  Price= getIntent().getExtras().getString("itemprice");

        Toast.makeText(Draw.this, "Price of "+name+" is "+Price, Toast.LENGTH_LONG).show();
    };
}

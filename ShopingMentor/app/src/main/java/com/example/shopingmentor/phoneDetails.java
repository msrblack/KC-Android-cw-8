package com.example.shopingmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class phoneDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        Bundle b = getIntent().getExtras();


        ImageView honeyImg = findViewById(R.id.honeyImg);
        TextView honeyName = findViewById(R.id.honeyName);
        TextView honeyprice = findViewById(R.id.honeyprice);

        Items deliveredPhone = (Items) b.getSerializable("phone");

        honeyImg.setImageResource(deliveredPhone.getItemImg());
        honeyName.setText(deliveredPhone.getItemName());
        honeyprice.setText(deliveredPhone.getItemPrice()+"");


    }
}
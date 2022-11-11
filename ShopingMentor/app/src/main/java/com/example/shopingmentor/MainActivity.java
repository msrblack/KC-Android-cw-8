package com.example.shopingmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Items> Itemslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String honeyName, int honeyprice, int honeyImg, String chocolateName, int chocolateprice, int chocolateImg, String donutName, int donutprice, int donutImg, String coffeeName, int coffeeprice, int coffeeImg, String cheeseName, int cheeseprice, int cheeseImg, String friesName, int friesprice, int friesImg
        Items s1 = new Items("أ.سلمان النجدي",1000000,R.drawable.honey);
        Items s2 = new Items("أ.عبدال",1000000,R.drawable.chocolate);
        Items s3 = new Items("أ.محمد",1000000,R.drawable.donut);
        Items s4 = new Items("أ.هاجر",500000,R.drawable.coffee);
        Items s5 = new Items("أ.ماريا الشمري",500000,R.drawable.cheese);
        Items s6 = new Items("أ.موضي",100000,R.drawable.fries);

        Itemslist.add(s1);
        Itemslist.add(s2);
        Itemslist.add(s3);
        Itemslist.add(s4);
        Itemslist.add(s5);
        Itemslist.add(s6);


        ItemsAdapter ItemsAdapter = new ItemsAdapter(this, 0,Itemslist);
        ListView list2 = findViewById(R.id.list1);

        list2.setAdapter(ItemsAdapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Items currentPhone = Itemslist.get(i);

                Intent in = new Intent(MainActivity.this,phoneDetails.class);
                in.putExtra("phone",currentPhone);
                startActivity(in);

            }
        });

    }
}
package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Platform extends AppCompatActivity {
TextView weathera,directiona,bustiminga,placestovisita,hotelsa,resturanta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);
        getSupportActionBar().setTitle("Platform");
weathera=findViewById(R.id.weather);
directiona=findViewById(R.id.direction);
bustiminga=findViewById(R.id.bustiming);
placestovisita=findViewById(R.id.placestovisit);
hotelsa=findViewById(R.id.hotels);
resturanta=findViewById(R.id.Resturant);

        Intent i= getIntent();
        final String jagah =i.getStringExtra("place");


        weathera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(Platform.this, Weather.class);
                mintent.putExtra("place", jagah);
                startActivity(mintent);
            }
        });
        directiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent dintent = new Intent(Platform.this, Direction.class);
                dintent.putExtra("place", jagah);
                startActivity(dintent);
            }
        });
        bustiminga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bintent = new Intent(Platform.this, bustiming.class);
                bintent.putExtra("place", jagah);
                startActivity(bintent);
            }
        });
        placestovisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pintent = new Intent(Platform.this, placestovisit.class);
                pintent.putExtra("place", jagah);
                startActivity(pintent);
            }
        });
        hotelsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hintent = new Intent(Platform.this, hotels.class);
                hintent.putExtra("place", jagah);
                startActivity(hintent);
            }
        });
        resturanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rintent = new Intent(Platform.this, resturant.class);
                rintent.putExtra("place", jagah);
                startActivity(rintent);
            }
        });

    }


}

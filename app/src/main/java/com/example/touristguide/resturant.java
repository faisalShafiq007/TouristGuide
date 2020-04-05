package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class resturant extends AppCompatActivity {
    ImageView ione,itwo,ithree;
    TextView one,two,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant);
        getSupportActionBar().setTitle("Resturant");
        Intent i= getIntent();
        final String jagah =i.getStringExtra("place");
        one=findViewById(R.id.textview1);
        two=findViewById(R.id.textview2);
        three=findViewById(R.id.textview3);
        ione=findViewById(R.id.imgview1);
        itwo=findViewById(R.id.imgview2);
        ithree=findViewById(R.id.imgview3);



        if(TextUtils.equals( jagah,"Naran")){
            Naran();
        }
        else if(TextUtils.equals( jagah,"Jammu")){
            Jammu();

        }
        else if(TextUtils.equals( jagah,"Murree")){
            Muree();

        }
        else if(TextUtils.equals( jagah,"Gilgit")){
            gilgit();

        }
        else if(TextUtils.equals( jagah,"Gwadar")){
            gwadar();

        }
    }

    private void gwadar() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Pearl-Continental");
        two.setText("Royal Resort Gwadar");
        three.setText("Shinwari Hotel");
        ione.setImageResource(R.drawable.gwr1);
        itwo.setImageResource(R.drawable.gwr2);
        ithree.setImageResource(R.drawable.gwr3);
    }

    private void gilgit() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Dumani");
        two.setText("The Food Corridor ");
        three.setText("Gilgit Serena Hotel Dining");
        ione.setImageResource(R.drawable.gr1);
        itwo.setImageResource(R.drawable.gr2);
        ithree.setImageResource(R.drawable.gr3);
    }

    private void Muree() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Bundukhan");
        two.setText("Halal korean");
        three.setText("thaali a traditional");
        ione.setImageResource(R.drawable.mr1);
        itwo.setImageResource(R.drawable.mr2);
        ithree.setImageResource(R.drawable.mr3);
    }

    private void Jammu() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Kashmir Inn");
        two.setText("Crazy masala");
        three.setText("Stuttgart");
        ione.setImageResource(R.drawable.kr1);
        itwo.setImageResource(R.drawable.kr2);
        ithree.setImageResource(R.drawable.kr3);
    }

    private void Naran() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Moon Resturant");
        two.setText("Kiwai Abshar");
        three.setText("Diamond Hills");
        ione.setImageResource(R.drawable.nr1);
        itwo.setImageResource(R.drawable.nr2);
        ithree.setImageResource(R.drawable.nr3);
    }
}

package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class hotels extends AppCompatActivity {
    ImageView ione,itwo,ithree;
    TextView one,two,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        getSupportActionBar().setTitle("Hotels");
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
        one.setText("Hotel Sadaf");
        two.setText("Marjan Hotel");
        three.setText("Shinwari Hotel");
        ione.setImageResource(R.drawable.gwh1);
        itwo.setImageResource(R.drawable.gwh2);
        ithree.setImageResource(R.drawable.gwh3);
    }

    private void gilgit() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Gilgit Serena Hotel");
        two.setText("Capital Lodge");
        three.setText("Canopy Nexus Hotel");
        ione.setImageResource(R.drawable.gh1);
        itwo.setImageResource(R.drawable.gh2);
        ithree.setImageResource(R.drawable.gh3);
    }

    private void Muree() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Brightlands Hotel");
        two.setText("Hotel Metropole");
        three.setText("DAYS INN Muree Hotel ");
        ione.setImageResource(R.drawable.mh1);
        itwo.setImageResource(R.drawable.mh2);
        ithree.setImageResource(R.drawable.mh3);
    }

    private void Jammu() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("SWISS HOTEL");
        two.setText("Pearl Continental Hote");
        three.setText("Kashmir Lodges");
        ione.setImageResource(R.drawable.kh1);
        itwo.setImageResource(R.drawable.kh2);
        ithree.setImageResource(R.drawable.kh3);
    }

    private void Naran() {
        one.setVisibility(View.VISIBLE);
        ione.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        itwo.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        ithree.setVisibility(View.VISIBLE);
        one.setText("Pine Top Hotel");
        two.setText("Hotel Faran");
        three.setText("Rose valley hotel");
        ione.setImageResource(R.drawable.nh1);
        itwo.setImageResource(R.drawable.nh2);
        ithree.setImageResource(R.drawable.nh3);
    }
}

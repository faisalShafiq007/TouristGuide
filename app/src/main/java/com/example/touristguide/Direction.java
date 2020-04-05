package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Direction extends AppCompatActivity {
    WebView wv;
    String jagah;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        Intent i= getIntent();
        jagah =i.getStringExtra("place");
        getSupportActionBar().setTitle("Direction");
        if(TextUtils.equals( jagah,"Naran")){
            url="https://www.google.com/maps/place/Naran,+Mansehra,+Khyber+Pakhtunkhwa,+Pakistan/@34.9033505,73.6371018,14z/data=!3m1!4b1!4m5!3m4!1s0x38e751e0bc7c4883:0x75317955703e1213!8m2!3d34.9092505!4d73.6506776";

        }
        else if(TextUtils.equals( jagah,"Jammu")){
            url="https://www.google.com/maps/place/Jammu+and+Kashmir/@33.8830649,74.2838973,7z/data=!3m1!4b1!4m5!3m4!1s0x38e1092499ffa89d:0x6567a6d4697e7f1!8m2!3d33.778175!4d76.5761714";


        }
        else if(TextUtils.equals( jagah,"Murree")){
            url="https://www.google.com/maps/place/Murree,+Rawalpindi,+Punjab,+Pakistan/@33.9037871,73.3609268,13z/data=!3m1!4b1!4m5!3m4!1s0x38dfd715776097a9:0x17b2e1d6bfb8e190!8m2!3d33.9069576!4d73.3943017";


        }
        else if(TextUtils.equals( jagah,"Gilgit")){
            url="https://www.google.com/maps/place/Gilgit/@35.9102701,74.3019132,12z/data=!3m1!4b1!4m5!3m4!1s0x38e649e3642543b1:0x40fd0ca3ca17282b!8m2!3d35.881911!4d74.4642861";

        }
        else if(TextUtils.equals( jagah,"Gwadar")){
            url="https://www.google.com/maps/place/Gwadar,+Balochistan,+Pakistan/@25.1947296,62.1838912,11z/data=!3m1!4b1!4m5!3m4!1s0x3ebee23e2649061d:0x19fc28d08cb2e100!8m2!3d25.2460129!4d62.2861215";

        }

        wv=findViewById(R.id.weviewx);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);
        WebSettings webSettings=wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(wv.canGoBack()){
            wv.goBack();

        }
        else{
        super.onBackPressed();}
    }
}

package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class bustiming extends AppCompatActivity {
ImageView imgbilal,imgdaewoo;
    WebView wv;
    String jagah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bustiming);
        imgbilal=findViewById(R.id.bilal);
        wv=findViewById(R.id.weviewx);

        imgdaewoo=findViewById(R.id.daewoo);
        getSupportActionBar().setTitle("Bustiming");
        imgbilal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbilal.setVisibility(View.INVISIBLE);
                imgdaewoo.setVisibility(View.INVISIBLE);
                wv.setVisibility(View.VISIBLE);
                String url;
                url="http://bilaltravel.pk";

                wv.setWebViewClient(new WebViewClient());
                wv.loadUrl(url);
                WebSettings webSettings=wv.getSettings();
                webSettings.setJavaScriptEnabled(true);

            }
        });
        imgdaewoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbilal.setVisibility(View.INVISIBLE);
                imgdaewoo.setVisibility(View.INVISIBLE);
                wv.setVisibility(View.VISIBLE);
                String url="";
            url="https://daewoo.com.pk";

                wv.setWebViewClient(new WebViewClient());
                wv.loadUrl(url);
                WebSettings webSettings=wv.getSettings();
                webSettings.setJavaScriptEnabled(true);
            }
        });


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

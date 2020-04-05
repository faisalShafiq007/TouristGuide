package com.example.touristguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Weather extends AppCompatActivity {
    ImageView tdayimg,tmrwimg,thirdayimg,fdimg,sdimg;
    TextView tday, tomorw, dat, sdat, tfat, fourthdat;
    TextView a, b, c, d;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    String jagah;


    class Weathera extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... address) {
            //First string means URL isin string,void means nothing,third string means data return in form of string

            try {

                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //Establish connection with adress
                connection.connect();
                //retrieve data from url
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                //retrieve data and return as a string
                int data = isr.read();
                String content = "";
                char ch;
                while (data != -1) {
                    ch = (char) data;
                    content = content + ch;
                    data = isr.read();


                }
                return content;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }
    }

    public void search() {

        try {

            String content = "";
            Weathera weather = new Weathera();
            content = weather.execute("http://api.openweathermap.org/data/2.5/forecast?q=" + jagah + "&appid=b89b3ca8d366343a3ac1ce2776c1ea03")
                    .get();
            Log.e("Content", content);
            JSONObject jsonObject = new JSONObject(content);

            String list = jsonObject.getString("list");

            Log.i("listnew", list);

            JSONArray array = new JSONArray(list);


            String main = "";



            for (int i = 0; i <= 0; i++) {

                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");
                Log.e("temp", temp);
                double c = ((Double.parseDouble(temp)) - (273.15));
                Log.e("value", String.valueOf(c));
                String d = String.format("%.0f", c);
                int  tempor=Integer.valueOf(d.trim());


                tday.setText(d + " C");


                Log.e("value", String.valueOf(tempor));
              if(tempor>=34){
                    tdayimg.setImageResource(R.drawable.desert); }
              else if(tempor>=17&&tempor<=33){
                    tdayimg.setImageResource(R.drawable.haze); }
                else if(tempor<0&&tempor>-25){
                    tdayimg.setImageResource(R.drawable.snow); }
              else if(tempor>=0&&tempor<=12){
                    tdayimg.setImageResource(R.drawable.cloudy); }
                else if(tempor>=13&&tempor<=16){
                    tdayimg.setImageResource(R.drawable.smoke); }
                else {
                    tdayimg.setImageResource(R.drawable.clear);
                  Log.e("error","error");                }
            }
            for (int i = 1; i <= 1; i++) {

                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");

                double c = ((Double.parseDouble(temp)) - (273.15));
                String d = String.format("%.0f", c);

                tomorw.setText(d + " C");
                int   tempor=Integer.parseInt(d.trim());
                Log.e("value", String.valueOf(tempor));
                if(tempor>=34){
                    tmrwimg.setImageResource(R.drawable.desert); }
                else if(tempor>=17&&tempor<=33){
                    tmrwimg.setImageResource(R.drawable.haze); }
                else if(tempor<0&&tempor>-25){
                    tmrwimg.setImageResource(R.drawable.snow); }
                else if(tempor>=0&&tempor<=12){
                    tmrwimg.setImageResource(R.drawable.cloudy); }
                else if(tempor>=13&&tempor<=16){
                    tmrwimg.setImageResource(R.drawable.smoke); }
                else {
                    tmrwimg.setImageResource(R.drawable.clear);
                    Log.e("error","error");}

            }
            for (int i = 2; i <= 2; i++) {
                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");
                double c = ((Double.parseDouble(temp)) - (273.15));
                String d = String.format("%.0f", c);
                dat.setText(d + " C");
                int   tempor=Integer.parseInt(d);
                Log.e("value", String.valueOf(tempor));
                if(tempor>=34){
                    thirdayimg.setImageResource(R.drawable.desert); }
                else if(tempor>=17&&tempor<=33){
                    thirdayimg.setImageResource(R.drawable.haze); }
                else if(tempor<0&&tempor>-25){
                    thirdayimg.setImageResource(R.drawable.snow); }
                else if(tempor>=0&&tempor<=12){
                    thirdayimg.setImageResource(R.drawable.cloudy); }
                else if(tempor>=13&&tempor<=16){
                    thirdayimg.setImageResource(R.drawable.smoke); }
                else {
                    thirdayimg.setImageResource(R.drawable.clear);
                    Log.e("error","error");}

            }
            for (int i = 3; i <= 3; i++) {
                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");

                double c = ((Double.parseDouble(temp)) - (273.15));
                String d = String.format("%.0f", c);
                sdat.setText(d + " C");
                int   tempor=Integer.parseInt(d);
                Log.e("value", String.valueOf(tempor));
                if(tempor>=34){
                    fdimg.setImageResource(R.drawable.desert); }
                else if(tempor>=17&&tempor<=22){
                    fdimg.setImageResource(R.drawable.haze); }
                else if(tempor<0&&tempor>-25){
                    fdimg.setImageResource(R.drawable.snow); }
                else if(tempor>=0&&tempor<=12){
                    fdimg.setImageResource(R.drawable.cloudy); }
                else if(tempor>=13&&tempor<=16){
                    fdimg.setImageResource(R.drawable.smoke); }
                else {
                    fdimg.setImageResource(R.drawable.clear);
                    Log.e("error","error");}

            }

            for (int i = 4; i <= 4; i++) {
                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");
                double c = ((Double.parseDouble(temp)) - (273.15));
                String d = String.format("%.0f", c);
                tfat.setText(d + " C");
                int   tempor=Integer.parseInt(d);
                Log.e("value", String.valueOf(tempor));
                if(tempor>=34){
                    sdimg.setImageResource(R.drawable.desert); }
                else if(tempor>=17&&tempor<=22){
                    sdimg.setImageResource(R.drawable.haze); }
                else if(tempor<0&&tempor>-25){
                    sdimg.setImageResource(R.drawable.snow); }
                else if(tempor>=0&&tempor<=12){
                    sdimg.setImageResource(R.drawable.cloudy); }
                else if(tempor>=13&&tempor<=16){
                    sdimg.setImageResource(R.drawable.smoke); }
                else {
                    sdimg.setImageResource(R.drawable.clear);
                    Log.e("error","error");}

            }
            for (int i = 5; i <= 5; i++) {
                JSONObject listarr = array.getJSONObject(i);
                main = listarr.getString("main");

                /*  Log.e("main",main);*/
                JSONObject jsonObjecttemp = new JSONObject(main);

                String temp = jsonObjecttemp.getString("temp");
                double c = ((Double.parseDouble(temp)) - (273.15));
                String d = String.format("%.0f", c);
                fourthdat.setText(d + " C");

            }


           /* String temp1=jsonObject.getString("main");

            Log.i("main",temp1);
            JSONObject json= (JSONObject) new JSONTokener(temp1).nextValue();

            String temperarture= String.valueOf( json.get("temp"));
            Log.i("temp",temperarture);
            tday.setText(temperarture+" C");
            Float tmt,sddat,tffat,fourrdt;
            tmt=Float.parseFloat(temperarture)+1;
            tomorw.setText(String.valueOf(tmt)+" C");

            sddat=tmt+3;

            tffat=sddat+1;
            fourrdt=tffat+1;
            sdat.setText(sddat+" C");
            tfat.setText(temperarture+" C");
            fourthdat.setText(fourrdt+" C");
            dat.setText(tffat+" C")*/
            ;


        } catch (Exception e) {
            e.printStackTrace();
        }
        // also just top the timer thread, otherwise, you may receive a crash report
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportActionBar().setTitle("Weather");
        Intent i= getIntent();
         jagah =i.getStringExtra("place");
        tday=findViewById(R.id.todaytemp);
        tomorw=findViewById(R.id.tomorrowtemp);
        dat=findViewById(R.id.daytomorrowtemp);
        sdat=findViewById(R.id.sectomorrowtemp);
tfat=findViewById(R.id.thirdtomorrowtemp);
fourthdat=findViewById(R.id.fourtomorrowtemp);
a=findViewById(R.id.c);
b=findViewById(R.id.d);
        c=findViewById(R.id.e);
        d=findViewById(R.id.f);

        tdayimg=findViewById(R.id.todayimage);
        tmrwimg=findViewById(R.id.tomorrowimage);
        fdimg=findViewById(R.id.firstdayimage);
        sdimg=findViewById(R.id.seconddayimage);
        thirdayimg=findViewById(R.id.thirddayimage);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        String concat=date.substring(0,3);
        Integer conert=Integer.parseInt(date.substring(3,5));


        Integer fa=(conert)+2;
        Integer fb=(fa)+1;
        Integer fc=(fb)+1;
        Integer fd=(fc)+1;
        a.setText(fa+"/"+concat+"20");
        b.setText(fb+"/"+concat+"20");
        c.setText(fc+"/"+concat+"20");
        d.setText(fd+"/"+concat+"20");
        final ProgressDialog progress = new ProgressDialog(this);
        final Timer t = new Timer();
        progress.setTitle("Loading");
        progress.setMessage("Wait we are getting current weather...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        t.schedule(new TimerTask() {
            public void run() {
                search();
                progress.dismiss();
                // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 500); // after 2 second (or 2000 miliseconds), the task will be active.

    }

  /*  @Override
    protected void onStart() {


        super.onStart();
    }*/
}
package com.example.touristguide;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;

    private ActionBarDrawerToggle abdt;
    FirebaseAuth mAuth;
    DatabaseReference userRef;
    String Current_user_id;
    private static final int REQUEST_LOCATION=1;
ListView ls;
String[] places={"Naran","Jammu","Murree","Gilgit","Gwadar"};
Integer[] imageid={R.drawable.naran,R.drawable.kashmir,R.drawable.abotabad,R.drawable.gilgit,R.drawable.gwadar};
    ImageView imageView;
    TextView tv;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Current_user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
userRef = FirebaseDatabase.getInstance().getReference().child("users");
        NavigationView navigationaView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationaView.getHeaderView(0);
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null) {
            String Current_user_id = mAuth.getCurrentUser().getUid();
            imageView = headerView.findViewById(R.id.circleImageView1);
            tv = headerView.findViewById(R.id.textview1);

        }

        ls=findViewById(R.id.listview);
        CustomListview customListview=new CustomListview(MainActivity.this, imageid, places);
        ls.setAdapter(customListview);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if( places[position].equals("Naran")){
                    Intent mintent = new Intent(MainActivity.this, Platform.class);
                    mintent.putExtra("place", "Naran");
                    startActivity(mintent);
                }
                if( places[position].equals("Jammu")){
                    Intent kintent = new Intent(MainActivity.this, Platform.class);
                    kintent.putExtra("place", "Jammu");
                    startActivity(kintent);
                }
                if( places[position].equals("Murree")){
                    Intent aintent = new Intent(MainActivity.this, Platform.class);
                    aintent.putExtra("place", "Murree");
                    startActivity(aintent);
                }
                if( places[position].equals("Gilgit")){
                    Intent lintent = new Intent(MainActivity.this, Platform.class);
                    lintent.putExtra("place", "Gilgit");
                    startActivity(lintent);
                }
                if( places[position].equals("Gwadar")){
                    Intent pintent = new Intent(MainActivity.this, Platform.class);
                    pintent.putExtra("place", "Gwadar");
                    startActivity(pintent);
                }
            }
        });




            userRef.child(Current_user_id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        if (dataSnapshot.hasChild("name")) {
                            String fullname = dataSnapshot.child("name").getValue().toString();
                            tv.setText(fullname);
                        }
                        if (dataSnapshot.hasChild("profileimage")) {

                            String image = dataSnapshot.child("profileimage").getValue().toString();
                            Picasso.get().load(image).placeholder(R.drawable.profile_image).into(imageView);
                        } else {
                            Toast.makeText(MainActivity.this, "nothing found", Toast.LENGTH_LONG).show();

                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });






        dl=findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        NavigationView navview=findViewById(R.id.nav_view);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.home){
                    Intent h=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(h);
                }
              if(id==R.id.Profile){
                    Intent p=new Intent(MainActivity.this,profile_show.class);
                    startActivity(p);
                }
                  if(id==R.id.Settingsmenu){
                    Intent s=new Intent(MainActivity.this,Settings.class);
                    startActivity(s);
                }
                if(id==R.id.Logout){
                    mAuth.signOut();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.remove("name"); // will delete key name
                    editor.remove("email"); // will delete key email
                    editor.commit();
                    Intent m=new Intent(MainActivity.this,Signin.class);
                    m.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(m);
                }
                return true;
            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);

    }





}


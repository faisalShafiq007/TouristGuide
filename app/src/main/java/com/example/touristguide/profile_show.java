package com.example.touristguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class profile_show extends AppCompatActivity {
    TextView username,city,gender,phonenumber;
    CircleImageView imageview;
    StorageReference userprofileimageRef ;
    DatabaseReference profileuserref;
    String Currentuserid;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_show);
        username=findViewById(R.id.username);
        getSupportActionBar().setTitle("Profile");
        city=findViewById(R.id.city);
        gender=findViewById(R.id.gender);
        phonenumber=findViewById(R.id.phnenumber);
        imageview=findViewById(R.id.my_profile_pic);
        mAuth=FirebaseAuth.getInstance();
        Currentuserid=FirebaseAuth.getInstance().getCurrentUser().getUid();
        profileuserref= FirebaseDatabase.getInstance().getReference().child("users").child(Currentuserid);
        profileuserref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String image=dataSnapshot.child("profileimage").getValue().toString();
                    Picasso.get().load(image).placeholder(R.drawable.profile_image).into(imageview);

                }
                if (dataSnapshot.hasChild("name")) {
                    String fullname = dataSnapshot.child("name").getValue().toString();
                    username.setText("Name: "+fullname);
                }
                if (dataSnapshot.hasChild("city")) {
                    String city1 = dataSnapshot.child("city").getValue().toString();
                    city.setText("City: "+city1);
                }
                if (dataSnapshot.hasChild("name")) {
                    String phonenumber1 = dataSnapshot.child("phonenumber").getValue().toString();
                    phonenumber.setText("No: "+phonenumber1);
                }
                if (dataSnapshot.hasChild("gender")) {
                    String gender1 = dataSnapshot.child("gender").getValue().toString();
                    gender.setText("Gender: "+gender1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

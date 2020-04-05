package com.example.touristguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Settings extends AppCompatActivity {
    EditText number,gender,name,city;
    int GALLERY_PICK=1334;
    CircleImageView spimage;
    Button sbtn;
    StorageReference userprofileimageRef ;
    DatabaseReference profileuserref;
    String Currentuserid;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        number=findViewById(R.id.settings_number);
        gender=findViewById(R.id.settings_gender);
        name=findViewById(R.id.settings_username);
        userprofileimageRef= FirebaseStorage.getInstance().getReference().child("profileimage");
        city=findViewById(R.id.settings_city);
        getSupportActionBar().setTitle("Settings");
        spimage=findViewById(R.id.settings_profile_image);
        sbtn=findViewById(R.id.settingsbutton);
        mAuth=FirebaseAuth.getInstance();
        Currentuserid=FirebaseAuth.getInstance().getCurrentUser().getUid();
        profileuserref= FirebaseDatabase.getInstance().getReference().child("users").child(Currentuserid);
        profileuserref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    String image=dataSnapshot.child("profileimage").getValue().toString();
                    Picasso.get().load(image).placeholder(R.drawable.profile_image).into(spimage);

                }
                if (dataSnapshot.hasChild("name")) {
                    String fullname = dataSnapshot.child("name").getValue().toString();
                    name.setText(fullname);
                }
                if (dataSnapshot.hasChild("city")) {
                    String city1 = dataSnapshot.child("city").getValue().toString();
                    city.setText(city1);
                }
                if (dataSnapshot.hasChild("name")) {
                    String phonenumber1 = dataSnapshot.child("phonenumber").getValue().toString();
                    number.setText(phonenumber1);
                }
                if (dataSnapshot.hasChild("gender")) {
                    String gender1 = dataSnapshot.child("gender").getValue().toString();
                    gender.setText(gender1);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        spimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent=new Intent();
                galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_PICK);
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsbtn();

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1334 ){

            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
            Uri ImageUri=data.getData();
        }
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            if(resultCode==RESULT_OK){
                final ProgressDialog progress = new ProgressDialog(Settings.this);
                final Timer t = new Timer();
                progress.setTitle("Loading");
                progress.setMessage("Wait while uploading...");
                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progress.show();
                t.schedule(new TimerTask() {
                    public void run() {
                        progress.dismiss();
                        // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 6000);
                Uri resulturi=result.getUri();
                final StorageReference filepath=userprofileimageRef.child(Currentuserid +".jpg");
                filepath.putFile(resulturi).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        if(task.isSuccessful()){

                            /*final String downloadurl= task.getResult().getStorage().getDownloadUrl().toString();*/
                            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downloadurl=uri.toString();
                                    profileuserref.child("profileimage").setValue(downloadurl).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                  /*Intent setupintent=new Intent(setup.this,setup.class);
                                  startActivity(setupintent);*/
                                            Toast.makeText(Settings.this,"image stored",Toast.LENGTH_LONG).show();


                                        }
                                    });
                                }
                            });

                        }
                    }


                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {

                    }
                });

            }
        }
        super.onActivityResult(requestCode, resultCode, data);}
    private void settingsbtn() {
        String phonenumber= number.getText().toString();
        String Gender= gender.getText().toString();
        String name1=name.getText().toString();
        String City=city.getText().toString();
        profileuserref=FirebaseDatabase.getInstance().getReference().child("users").child(Currentuserid);
        HashMap usermap=new HashMap();
        usermap.put("phonenumber",phonenumber);
        usermap.put("gender",Gender);
        usermap.put("name",name1);
        usermap.put("city",City);
        profileuserref.updateChildren(usermap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                Toast.makeText(Settings.this,"data updated",Toast.LENGTH_LONG).show();
            }
        });
    }
    }


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

public class Profile extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText pnumber,gnder,user,cty;
    Button signupbtn;
    CircleImageView pimage;
    int GALLERY_PICK=1254;
    StorageReference userprofileimageRef;
    DatabaseReference userRef ;
    String Current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        mAuth=FirebaseAuth.getInstance();
        signupbtn=findViewById(R.id.Signupbutton);
        userprofileimageRef = FirebaseStorage.getInstance().getReference().child("profileimage");
        pnumber=findViewById(R.id.number);
        gnder=findViewById(R.id.gender);
        Current_user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userRef= FirebaseDatabase.getInstance().getReference().child("users").child(Current_user_id);
        user=findViewById(R.id.username);
        cty=findViewById(R.id.city);
        pimage=findViewById(R.id.profile_image);
        pimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent=new Intent();
                galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_PICK);

            }
        });

        //retrieving image from storage
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String image=dataSnapshot.child("profileimage").getValue().toString();
                    Picasso.get().load(image).placeholder(R.drawable.profile_image).into(pimage);

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1254 ){

            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
            Uri ImageUri=data.getData();
        }
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            if(resultCode==RESULT_OK){
                final ProgressDialog progress = new ProgressDialog(Profile.this);
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
                final StorageReference filepath=userprofileimageRef.child(Current_user_id +".jpg");
                filepath.putFile(resulturi).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        if(task.isSuccessful()){

                            /*final String downloadurl= task.getResult().getStorage().getDownloadUrl().toString();*/
                            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downloadurl=uri.toString();
                                    userRef.child("profileimage").setValue(downloadurl).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                  /*Intent setupintent=new Intent(setup.this,setup.class);
                                  startActivity(setupintent);*/
                                            Toast.makeText(Profile.this,"image stored",Toast.LENGTH_LONG).show();


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
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void signup() {
        String phonenumber= pnumber.getText().toString();
        String Gender= gnder.getText().toString();
        String name=user.getText().toString();
        String City=cty.getText().toString();
        userRef=FirebaseDatabase.getInstance().getReference().child("users").child(Current_user_id);
        HashMap usermap=new HashMap();
        usermap.put("phonenumber",phonenumber);
        usermap.put("gender",Gender);
        usermap.put("name",name);
        usermap.put("city",City);
        userRef.updateChildren(usermap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                final ProgressDialog progress = new ProgressDialog(Profile.this);
                final Timer t = new Timer();
                progress.setTitle("Creating Acount");
                progress.setMessage("Wait while we register you...");
                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progress.show();
                t.schedule(new TimerTask() {
                    public void run() {
                        progress.dismiss();
                        Intent intent=new Intent(Profile.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);


            }
        });


    }
    }


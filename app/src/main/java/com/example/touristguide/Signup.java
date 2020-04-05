package com.example.touristguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class Signup extends AppCompatActivity {
    EditText Email,pass;
    TextView signin,sg;
    FirebaseAuth mauth;
    Button signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        mauth=FirebaseAuth.getInstance();
        sg=findViewById(R.id.signin);
        Email=findViewById(R.id.email);
        signupbtn=findViewById(R.id.Signupbutton);
        pass=findViewById(R.id.password);
        signin=findViewById(R.id.signinintent);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupint=new Intent(Signup.this,Signin.class);
                signupint.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(signupint);

            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ssignup();
            }
        });
    }
    private void Ssignup() {
        String e=Email.getText().toString();
        String p=pass.getText().toString();
        if(e.isEmpty()){
            Email.setError("please type email");
        }
        if(p.isEmpty()){
            pass.setError("please enter password");
        }
        if(!e.contains("@")){
            Email.setError("please type full email e.g xxx@x.com ");
        }
        if(p.length()<8){
            pass.setError("please enter password with length 8");

        }



        else{
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("email", Email.getText().toString());
            editor.putString("password", pass.getText().toString());
            editor.commit();
            final ProgressDialog progress = new ProgressDialog(Signup.this);
            final Timer t = new Timer();
            progress.setTitle("Creating Acount");
            progress.setMessage("Wait while we register you...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();
            t.schedule(new TimerTask() {
                public void run() {
                    progress.dismiss();

                    // when the task active then close the dialog
                    t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                }
            }, 2000); // after 2 second (or 2000 miliseconds), the task will be active.
            mauth.createUserWithEmailAndPassword(Email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent mintent=new Intent(Signup.this,Profile.class);
                        mintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mintent);
                        Toast.makeText(Signup.this,"Signup complete",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(Signup.this,"Check internet connection",Toast.LENGTH_SHORT).show();


                    }
                }
            });
        }
    }
}

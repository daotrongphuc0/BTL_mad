package com.example.shoesshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.shoesshop.R;
import com.example.shoesshop.dao.UserDao;
import com.example.shoesshop.databinding.ActivityMainBinding;
import com.example.shoesshop.databinding.ActivitySignUpBinding;
import com.example.shoesshop.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);





        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        },2000);
    }

    private void nextActivity() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent;
        if(user == null){
            // chua login
            intent = new Intent(this, SignInActivity.class);
        }else{
            //da login
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
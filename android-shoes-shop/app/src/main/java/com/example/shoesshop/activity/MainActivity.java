package com.example.shoesshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoesshop.R;

import com.example.shoesshop.activity.fragment.MyProfileFragment;
import com.example.shoesshop.activity.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    UserFragment userFragment = new UserFragment();

    Fragment myProfileFragment ;

    private ImageView imageAvata;
    private TextView tvInfoEmail, tvInfoName,tvInfoNumber;
    private FrameLayout frame_layout_user_info;




    public static final int FRAGMENT_MY_PROFILE = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
       // frame_layout_user_info= findViewById(R.layout.fragment_my_profile);
        myProfileFragment = new MyProfileFragment();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, myProfileFragment).commit();
        initUi();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.action_user:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, myProfileFragment).commit();
                    return true;
            }
            return false;
        });
        showUserInfomation();
    }
    private void showUserInfomation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user== null){
            return;
        }


        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();
        if(name ==null){
            tvInfoName.setText("No name");
        }else{
            tvInfoName.setText(name);
        }

        tvInfoEmail.setText(email);
        Glide.with(this).load(photoUrl).error(R.drawable.no_image_profile).into(imageAvata);
    }
    private void initUi() {

        imageAvata = myProfileFragment.findViewById(R.id.imageInfoProfile);
        tvInfoEmail = myProfileFragment.findViewById(R.id.tvInfoEmail);
        tvInfoName = myProfileFragment.findViewById(R.id.tvInfoName);
        tvInfoNumber = myProfileFragment.findViewById(R.id.tvInfoNumber);
    }
}
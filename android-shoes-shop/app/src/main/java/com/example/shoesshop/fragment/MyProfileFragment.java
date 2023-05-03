package com.example.shoesshop.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoesshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyProfileFragment extends Fragment implements View.OnClickListener{

    private ImageView imageAvata;
    private TextView tvInfoEmail, tvInfoName,tvInfoNumber;
    private Button btDangXuat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle saveInstanceState){
        View view=  inflater.inflate(R.layout.fragment_my_profile, container,false);
        imageAvata = view.findViewById(R.id.imageInfoProfile);
        tvInfoEmail = view.findViewById(R.id.tvInfoEmail);
        tvInfoName = view.findViewById(R.id.tvInfoName);
        tvInfoNumber = view.findViewById(R.id.tvInfoNumber);
        btDangXuat =  view.findViewById(R.id.btdangxuat);

        showUserInfomation();
        return view;
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


    @Override
    public void onClick(View view) {

    }
}
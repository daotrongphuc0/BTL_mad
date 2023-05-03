package com.example.shoesshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shoesshop.R;
import com.example.shoesshop.dao.UserDao;
import com.example.shoesshop.databinding.ActivityChaneInfoBinding;
import com.example.shoesshop.databinding.ActivitySignUpBinding;
import com.example.shoesshop.databinding.FragmentHomeBinding;
import com.example.shoesshop.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChaneInfoActivity extends AppCompatActivity {
    private ActivityChaneInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChaneInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        render();
        binding.buttonSignUp.setOnClickListener(v -> {

        });
    }

    protected void render(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        binding.inputEmail.setText(currentUser.getEmail());
        UserDao userDao = new UserDao();

        userDao.findByEmail(currentUser.getEmail(), new UserDao.UserCallback() {

            @Override
            public void onSuccess(User user) {
                String fullName  = user.getFirstName()+" "+user.getLastName();
                binding.inputNumber.setText(user.getPhoneNumber());
                binding.inputNameSignIn.setText(user.getFirstName());
                binding.LastNameSignIn.setText(user.getLastName());
                binding.inputNumber.setText(user.getPhoneNumber());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    protected void update(){

    }
}

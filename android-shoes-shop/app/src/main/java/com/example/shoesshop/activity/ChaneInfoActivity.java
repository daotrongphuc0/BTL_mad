package com.example.shoesshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
            update();
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
        String email = binding.inputEmail.getText().toString();
        String firstName = binding.inputNameSignIn.getText().toString();
        String lastName  = binding.LastNameSignIn.getText().toString();
        String phoneNumber = binding.inputNumber.getText().toString();
        final String oldPass = binding.inputOldPassword.getText().toString();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        UserDao userDao = new UserDao();

        userDao.findByEmail(currentUser.getEmail(), new UserDao.UserCallback() {

            @Override
            public void onSuccess(User user) {
                if(!oldPass.equals(user.getPassword())){

                    Toast.makeText(ChaneInfoActivity.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ChaneInfoActivity.this, ChaneInfoActivity.class);
                    startActivity(i);
                    return;
                }
                else{
                    String newPass1 = binding.inputNewPassword.getText().toString();
                    String newPass2 = binding.inputConfirmPassword.getText().toString();
                    if(newPass1.equals("")){
                        newPass1 = oldPass;
                    }

                    if(!newPass1.equals(newPass2)){
                        Intent i = new Intent(ChaneInfoActivity.this, ChaneInfoActivity.class);
                        startActivity(i);return;
                    }
                    UserDao UD = new UserDao();
                    UD.updateUser(email,firstName,lastName,phoneNumber,newPass1,new UserDao.UserCallback(){

                        @Override
                        public void onSuccess(User user) {
                            Toast.makeText(ChaneInfoActivity.this, "update",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Exception e) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }
}

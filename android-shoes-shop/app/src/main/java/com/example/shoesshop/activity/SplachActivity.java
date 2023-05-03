package com.example.shoesshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.shoesshop.R;
import com.example.shoesshop.dao.BrandDao;
import com.example.shoesshop.dao.CartDao;
import com.example.shoesshop.dao.ShoeDao;
import com.example.shoesshop.dao.UserDao;
import com.example.shoesshop.databinding.ActivityMainBinding;
import com.example.shoesshop.databinding.ActivitySignUpBinding;
import com.example.shoesshop.model.Brand;
import com.example.shoesshop.model.Cart;
import com.example.shoesshop.model.Shoe;
import com.example.shoesshop.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.List;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
//  demo add shoe
//      ShoeDao SD = new ShoeDao();
//      Shoe shoe = new Shoe("Adidas Stansmith", "available", "Adidas", 1300000, 1100000, 4, 324,"notyet");
//      SD.addShoe(shoe);
        Cart cart = new Cart();
        cart.setQuantity(5);
        CartDao CD = new CartDao();
        UserDao UD = new UserDao();
        CD.findById("-NUW9LnJhfEo0mMON6lt", new CartDao.CartCallback() {
            @Override
            public void onSuccess(Cart cart) {
                Log.e("xin chao", cart.getUser().getEmail());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });




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
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            String userEmail = currentUser.getEmail();
            Log.e("email",userEmail);

        }
        startActivity(intent);
        finish();
    }
}
package com.example.shoesshop.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.Cart;
import com.example.shoesshop.model.DetailShoe;
import com.example.shoesshop.model.Shoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.List;

import com.example.shoesshop.model.Shoe;
import com.example.shoesshop.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CartDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("carts");
    public void addShoe(Cart cart){
        myRef.push().setValue(cart);
    }

    public interface CartsCallback {
        void onSuccess(List<Cart> CartList);
        void onFailure(Exception e);
    }
    public interface CartCallback {
        void onSuccess(Cart cart);
        void onFailure(Exception e);
    }


    public void findById(final String id, final CartDao.CartCallback callback) {
        myRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final Cart cart = dataSnapshot.getValue(Cart.class);
                if (cart != null) {
                    UserDao UD = new UserDao();
                    Log.e("test key--------------",dataSnapshot.getKey().toString());
                    UD.findByCartId(dataSnapshot.getKey().toString(), new UserDao.UserCallback() {
                        @Override
                        public void onSuccess(User user) {
                            cart.setUser(user);
                            Log.e("UserCallback", "onSuccess");

                           //  Gọi callback nếu cả hai callback đều đã được gọi
                            if (cart.getDetailShoe() != null) {
                                  callback.onSuccess(cart);
                            }


                        }

                        @Override
                        public void onFailure(Exception e) {

                        }
                    });
                    DetailShoeDao DSD = new DetailShoeDao();
                    DSD.findByCartId(dataSnapshot.getKey().toString(), new DetailShoeDao.DetailShoeCallback() {
                        @Override
                        public void onSuccess(DetailShoe DetailShoe) {
                            cart.setDetailShoe(DetailShoe);
                            Log.e("DetailShoeCallback", "onSuccess");

                            // Gọi callback nếu cả hai callback đều đã được gọi
                            if (cart.getUser() != null) {
                                callback.onSuccess(cart);
                            }
                        }

                        @Override
                        public void onFailure(Exception e) {

                        }
                    });
                } else {
                    callback.onSuccess(null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Cart", "findById:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }



}

package com.example.shoesshop.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");


    public void addUser(User user){
        myRef.push().setValue(user);
    }
    public void findUserByPhoneNumber(String phoneNumber, UserSingleCallback callback) {
        Query query = myRef.orderByChild("phoneNumber").equalTo(phoneNumber).limitToFirst(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getChildren().iterator().next().getValue(User.class);
                    callback.onCallback(user);
                } else {
                    callback.onCallback(null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("UserDao", "findByPhoneNumber:onCancelled", databaseError.toException());
            }
        });
    }

    public interface UserSingleCallback {
        void onCallback(User user);
    }


}

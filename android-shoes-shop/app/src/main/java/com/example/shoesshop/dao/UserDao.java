package com.example.shoesshop.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.Brand;
import com.example.shoesshop.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class    UserDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    public interface UserCallback {
        void onSuccess(User user);
        void onFailure(Exception e);
    }
    public void findByCartId(final String cartId, final UserDao.UserCallback callback) {
        Query query = myRef.orderByChild("cartId").equalTo(cartId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User DS = null;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DS = snapshot.getValue(User.class);
                    break; // chỉ cần lấy giày đầu tiên có UserId tương ứng
                }

                if (DS != null) {
                    callback.onSuccess(DS);
                } else {
                    callback.onFailure(new Exception("Không tìm thấy giày với UserId = " + cartId));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("canceled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }

    public void addUser(User user){
        myRef.push().setValue(user);
    }


    public void findByEmail(String email, final UserCallback callback) {
        Query query = myRef.orderByChild("email").equalTo(email);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DataSnapshot childSnapshot = dataSnapshot.getChildren().iterator().next();
                    User user = childSnapshot.getValue(User.class);
                    callback.onSuccess(user);
                } else {
                    callback.onFailure(new Exception("User with email " + email + " not found."));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("UserDao", "findByEmail:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }
    public void updateUser(String email, String firstName, String lastName, String phoneNumber, String password, final UserCallback callback) {
        Query query = myRef.orderByChild("email").equalTo(email);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    DataSnapshot childSnapshot = dataSnapshot.getChildren().iterator().next();
                    String key = childSnapshot.getKey();
                    User user = childSnapshot.getValue(User.class);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(password);
                    myRef.child(key).setValue(user);
                    callback.onSuccess(user);
                } else {
                    callback.onFailure(new Exception("User with email " + email + " not found."));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("UserDao", "updateUser:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }



}

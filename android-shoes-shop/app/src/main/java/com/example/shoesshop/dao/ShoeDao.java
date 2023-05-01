package com.example.shoesshop.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.Shoe;
import com.example.shoesshop.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShoeDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("shoes");
    public void addUser(Shoe shoe){
        myRef.push().setValue(shoe);
    }
}

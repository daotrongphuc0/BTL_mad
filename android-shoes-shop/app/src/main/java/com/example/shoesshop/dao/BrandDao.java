package com.example.shoesshop.dao;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.Brand;
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

public class BrandDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("brands");
    public void addBrand(Brand brand){
        myRef.push().setValue(brand);
    }
}

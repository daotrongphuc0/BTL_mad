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
    public interface BrandCallback {
        void onSuccess(List<Brand> brandList);
        void onFailure(Exception e);
    }
    public void getAll(final BrandCallback callback) {
        final List<Brand> brandList = new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                brandList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Brand brand = snapshot.getValue(Brand.class);
                    brandList.add(brand);
                }

                callback.onSuccess(brandList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BrandDao", "loadBrands:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }

    
    public void findByName(final String name, final BrandCallback callback) {
        final List<Brand> brandList = new ArrayList<>();

        Query query = myRef.orderByChild("name").equalTo(name);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                brandList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Brand brand = snapshot.getValue(Brand.class);
                    brandList.add(brand);
                }

                callback.onSuccess(brandList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BrandDao", "loadBrands:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }


}

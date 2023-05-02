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
    public void addShoe(Shoe shoe){
        myRef.push().setValue(shoe);
    }
    public interface ShoeCallback {
        void onSuccess(List<Shoe> shoeList);
        void onFailure(Exception e);
    }
    public void getAll(final ShoeCallback callback) {
        final List<Shoe> shoeList = new ArrayList<>();

        // Sử dụng phương thức ValueEventListener để lắng nghe dữ liệu từ Firebase
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                shoeList.clear();

                // Duyệt qua các node con của "shoes" và thêm các đối tượng Shoe vào danh sách
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Shoe shoe = snapshot.getValue(Shoe.class);
                    shoeList.add(shoe);
                }

                // Gọi lại phương thức callback và truyền danh sách các đối tượng Shoe đã lấy được
                callback.onSuccess(shoeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("ShoeDao", "loadShoes:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }

}
//
//    ShoeDao shoeDao = new ShoeDao();
//        shoeDao.getAll(new ShoeDao.ShoeCallback() {
//            @Override
//          public void onSuccess(List<Shoe> shoeList) {
//              xu li du lieu  voi shoeList la list tra ve
//           for(Shoe item : shoeList){
//
//           }
//        }
//
//          @Override
//          public void onFailure(Exception e) {
//           Xử lý lỗi
//        }
//        });
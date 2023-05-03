package com.example.shoesshop.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shoesshop.model.DetailShoe;
import com.example.shoesshop.model.DetailShoe;
import com.example.shoesshop.model.DetailShoe;
import com.example.shoesshop.model.Shoe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DetailShoeDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("detailShoes");
    public void addDetailShoe(DetailShoe detailShoe){
        myRef.push().setValue(detailShoe);
    }
    public interface DetailShoeCallback {
        void onSuccess(DetailShoe DetailShoe);
        void onFailure(Exception e);
    }
    public void findById(final String id, final DetailShoeDao.DetailShoeCallback callback) {
        myRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DetailShoe DetailShoe = dataSnapshot.getValue(DetailShoe.class);
                if (DetailShoe != null) {
                    ShoeDao SD = new ShoeDao();
                   String id = dataSnapshot.getKey().toString();
                   SD.findByDetailShoeId(id, new ShoeDao.ShoeCallback(){

                       @Override
                       public void onSuccess(Shoe shoe) {
                           DetailShoe.setShoe(shoe);
                       }

                       @Override
                       public void onFailure(Exception e) {

                       }
                   });
                    callback.onSuccess(DetailShoe);
                } else {
                    callback.onSuccess(null);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("DetailShoe", "findById:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }
    public void findByCartId(final String cartId, final DetailShoeDao.DetailShoeCallback callback) {
        Query query = myRef.orderByChild("cartId").equalTo(cartId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DetailShoe DS = null;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DS = snapshot.getValue(DetailShoe.class);
                    break; // chỉ cần lấy giày đầu tiên có detailShoeId tương ứng
                }

                if (DS != null) {
                    callback.onSuccess(DS);
                } else {
                    callback.onFailure(new Exception("Không tìm thấy giày với detailShoeId = " + cartId));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("canceled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }


}

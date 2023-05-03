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
import java.util.Collections;
import java.util.List;

public class ShoeDao {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("shoes");
    public void addShoe(Shoe shoe){
        myRef.push().setValue(shoe);
    }
    public interface ShoesCallback {
        void onSuccess(List<Shoe> shoeList);
        void onFailure(Exception e);
    }
    public interface ShoeCallback {
        void onSuccess(Shoe shoe );
        void onFailure(Exception e);
    }
    public void getAll(final ShoesCallback callback) {
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
    public void findByBrandName(final String brandName, final ShoesCallback callback) {
        getAll(new ShoesCallback() {
            @Override
            public void onSuccess(List<Shoe> shoeList) {
                List<Shoe> result = new ArrayList<>();

                // Lọc kết quả bằng brand name
                for (Shoe shoe : shoeList) {
                    if (shoe.getBrandName().equals(brandName)) {
                        result.add(shoe);
                    }
                }

                // Truyền danh sách các đối tượng Shoe đã lọc được vào callback
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }
    public void findById(final String id, final ShoesCallback callback) {
        myRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Shoe shoe = dataSnapshot.getValue(Shoe.class);
                if (shoe != null) {
                    callback.onSuccess(Collections.singletonList(shoe));
                } else {
                    callback.onSuccess(Collections.emptyList());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("ShoeDao", "findById:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }
    public void findByDetailShoeId(final String detailShoeId, final ShoeCallback callback) {
        Query query = myRef.orderByChild("detailShoeId").equalTo(detailShoeId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Shoe shoe = null;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    shoe = snapshot.getValue(Shoe.class);
                    break; // chỉ cần lấy giày đầu tiên có detailShoeId tương ứng
                }

                if (shoe != null) {
                    callback.onSuccess(shoe);
                } else {
                    callback.onFailure(new Exception("Không tìm thấy giày với detailShoeId = " + detailShoeId));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("ShoeDao", "findByDetailShoeId:onCancelled", databaseError.toException());
                callback.onFailure(databaseError.toException());
            }
        });
    }







}

//      getAll
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
//  findByBrandName
//         ShoeDao shoeDao = new ShoeDao();
//        shoeDao.findByBrandName("Adidas", new ShoeDao.ShoeCallback() {
//          @Override
//          public void onSuccess(List<Shoe> shoeList) {
//            // Xử lý danh sách sản phẩm được tìm thấy ở đây
//               for(Shoe item: shoeList){
//                    Log.e("test brand", item.getName());
//               }
//
//           }
//
//          @Override
//          public void onFailure(Exception e) {
//              // Xử lý khi có lỗi xảy ra ở đây
//            }
//           });




            //findById
//          ShoeDao shoeDao = new ShoeDao();
//          String shoeId = "-NUMhyqxrCRrm_ct0rGf"; // ID của đôi giày cần tìm kiếm
//          shoeDao.findById(shoeId, new ShoeDao.ShoeCallback() {
//
//
//          @Override
//          public void onSuccess(List<Shoe> shoeList) {
//
//               Log.e("test id",  shoeList.get(0).getName());
//           }
//
//          @Override
//          public void onFailure(Exception e) {
//
//         }
//            });

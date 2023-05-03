package com.example.shoesshop.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoesshop.R;
import com.example.shoesshop.dao.UserDao;
import com.example.shoesshop.databinding.FragmentHomeBinding;
import com.example.shoesshop.model.Shoe;
import com.example.shoesshop.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    private FragmentHomeBinding binding;

    public FragmentHome() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        UserDao userDao = new UserDao();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        userDao.findByEmail(user.getEmail(), new UserDao.UserCallback() {

            @Override
            public void onSuccess(User user) {
                binding.nameText.setText(user.getLastName());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        search();


    }
    public void search() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                binding.nameText.setText(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý sự kiện thay đổi nội dung tìm kiếm ở đây
                return false;
            }
        });

    }




}

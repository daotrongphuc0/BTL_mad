 package com.example.shoesshop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoesshop.R;


 public class FragmentOder extends Fragment {
     public FragmentOder() {
     }

     @Nullable
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_oder,container,false);
     }
 }

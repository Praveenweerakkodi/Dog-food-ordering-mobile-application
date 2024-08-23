package com.example.food.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.food.Adapter.BestDealAdapter;
import com.example.food.Adapter.CategoryAdapter;
import com.example.food.Domain.CategoryDomain;
import com.example.food.Domain.ItemDomain;
import com.example.food.Domain.LocationDomain;
import com.example.food.R;
import com.example.food.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            initLocation();
            initCategoryList();
            initBestDealList();
    }

    private void initBestDealList() {

        DatabaseReference myRef=database.getReference("Items");
        binding.progressBarBestDeal.setVisibility(View.VISIBLE);
        ArrayList<ItemDomain> list=new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(ItemDomain.class));
                    }
                    if (!list.isEmpty()){
                        binding.bestDealView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));
                        binding.bestDealView.setAdapter(new BestDealAdapter(list));
                    }
                    binding.progressBarBestDeal.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private void initCategoryList() {
        DatabaseReference myRef=database.getReference("Category");
        binding.progressBarCategory.setVisibility(View.VISIBLE);
        ArrayList<CategoryDomain> list=new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        list.add(issue.getValue(CategoryDomain.class));
                    }
                    if (!list.isEmpty()){
                        binding.catView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                        binding.catView.setAdapter(new CategoryAdapter(list));
                    }
                    binding.progressBarCategory.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initLocation() {
        DatabaseReference myref=database.getReference("Location");
        ArrayList<LocationDomain> list=new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for(DataSnapshot issue:snapshot.getChildren()){
                       list.add(issue.getValue(LocationDomain.class));
                    }
                    ArrayAdapter<LocationDomain> adapter=new ArrayAdapter<>(MainActivity.this,R.layout.sp_item, list);
                    binding.locationSp.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
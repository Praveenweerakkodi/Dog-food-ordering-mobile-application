package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Domain.CategoryDomain;
import com.example.food.databinding.ViewholderCategoryBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    ArrayList<CategoryDomain> Items;
    Context context;

    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.Items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderCategoryBinding binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
        holder.binding.titleTxt.setText(Items.get(position).getName());

        Glide.with(context)
                .load(Items.get(position).getImagePath())
                .into(holder.binding.img);

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderCategoryBinding binding;
        public Viewholder(ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

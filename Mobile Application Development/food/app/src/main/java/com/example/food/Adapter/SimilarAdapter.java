package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Domain.ItemDomain;
import com.example.food.databinding.ViewholderSimilarBinding;

import java.util.ArrayList;

public class SimilarAdapter extends RecyclerView.Adapter<SimilarAdapter.Viewholder> {
    ArrayList<ItemDomain> Items;
    Context context;

    public SimilarAdapter(ArrayList<ItemDomain> items) {
        this.Items = items;
    }

    @NonNull
    @Override
    public SimilarAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderSimilarBinding binding = ViewholderSimilarBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarAdapter.Viewholder holder, int position) {
        Glide.with(context)
                .load(Items.get(position).getImagePath())
                .into(holder.binding.img);

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderSimilarBinding binding;

        public Viewholder(ViewholderSimilarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

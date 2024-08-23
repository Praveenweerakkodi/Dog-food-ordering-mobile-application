package com.example.food.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Activity.DetailActivity;
import com.example.food.Domain.ItemDomain;
import com.example.food.databinding.ViewholderBestDealBinding;

import java.util.ArrayList;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.Viewholder> {
    ArrayList<ItemDomain> Items;
    Context context;

    public BestDealAdapter(ArrayList<ItemDomain> items) {
        this.Items = items;
    }

    @NonNull
    @Override
    public BestDealAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        ViewholderBestDealBinding binding = ViewholderBestDealBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BestDealAdapter.Viewholder holder, int position) {
        holder.binding.titleTxt.setText(Items.get(position).getTitle());
        holder.binding.priceTxt.setText(Items.get(position).getPrice()+" Rs./kg");

        Glide.with(context)
                .load(Items.get(position).getImagePath())
                .into(holder.binding.img);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object",Items.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        ViewholderBestDealBinding binding;

        public Viewholder(ViewholderBestDealBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

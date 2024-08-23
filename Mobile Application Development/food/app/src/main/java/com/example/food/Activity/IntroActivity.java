package com.example.food.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.food.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.startBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));

    }
}
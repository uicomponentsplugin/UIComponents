package com.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mvvm.databinding.ActivityMainBinding;
import com.mvvm.view_models.ProfileViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.getCount().observe(this, profile -> {
            binding.txtResponse.setText(String.valueOf(profileViewModel.getCount().getValue()));
        });
        binding.txtResponse.setOnClickListener(v -> profileViewModel.addCounter());
    }
}
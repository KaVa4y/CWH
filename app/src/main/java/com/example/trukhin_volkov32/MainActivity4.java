package com.example.trukhin_volkov32;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.trukhin_volkov32.databinding.ActivityMain4Binding;
import com.example.trukhin_volkov32.databinding.ActivityMainBinding;

public class MainActivity4 extends AppCompatActivity {
    ActivityMain4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Home){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.Recipes){
                replaceFragment(new RecipesFragment());
            } else if (item.getItemId() == R.id.Profile) {
                replaceFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.Liked) {
                replaceFragment(new LikedFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit();
    }

}
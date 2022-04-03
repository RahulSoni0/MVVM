package com.example.mvvm.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.model.postmodel;
import com.example.mvvm.viewModel.RetrofitClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<postmodel> heroList;
   TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitClient model = ViewModelProviders.of(this).get(RetrofitClient.class);
        model.getHeroes().observe(this, new Observer<List<postmodel>>() {
            @Override
            public void onChanged(@Nullable List<postmodel> heroList) {
                Log.d("#####", heroList.get(0).getTitle().toString());
            }

        });
    }
}
package com.rapidvaluetest.imagelist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rapidvaluetest.R;
import com.rapidvaluetest.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ImageListActivity extends AppCompatActivity {

    private ImageViewModel imageViewModel;
    private ActivityMainBinding activityMainBinding ;
    private RecyclerView recyclerView;
    private TextView switchView;
    private ArrayList<ImageModelList> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        activityMainBinding.setImagemodel(imageViewModel);
        activityMainBinding.setLifecycleOwner(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        switchView = findViewById(R.id.switchView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        switchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchView.getText().toString().equalsIgnoreCase(getResources().getString(R.string.grid))){
                    recyclerView.setLayoutManager(new GridLayoutManager(ImageListActivity.this, 2));
                    recyclerView.setAdapter(new GridAdapter(list));
                    switchView.setText(getResources().getString(R.string.list));
                }
                else {
                    recyclerView.setLayoutManager(new LinearLayoutManager(ImageListActivity.this));
                    recyclerView.setAdapter(new LinearAdapter(list));
                    switchView.setText(getResources().getString(R.string.grid));
                }
            }
        });

        imageViewModel.getResponseVal().observe(this, new Observer<ImageModel>() {
            @Override
            public void onChanged(ImageModel imageModel) {
                list = imageModel.hits;
                recyclerView.setAdapter(new LinearAdapter(imageModel.hits));
            }
        });

    }


}

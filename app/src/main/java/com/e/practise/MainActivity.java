package com.e.practise;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.e.practise.viewModel.AppViewModel;
import com.e.practise.viewModel.ViewModelProviderFactory;
import com.google.gson.Gson;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    AppViewModel appViewModal;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appViewModal = ViewModelProviders.of(this, providerFactory).get(AppViewModel.class);


        appViewModal.loadList();


        appViewModal.listObject.observe(this, objects -> {
            Gson gson = new Gson();
            String json = gson.toJson(objects);
            Log.d(TAG, "onCreate: " +json);
        });
    }
}
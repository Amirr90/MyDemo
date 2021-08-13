package com.e.practise.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.e.practise.api.Api;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ApiRepository {
    private static final String TAG = "ApiRepository";
    Api api;
    MutableLiveData<List<Object>> liveData = new MutableLiveData<>();

    @Inject
    public ApiRepository(Api api) {
        this.api = api;
    }

    public MutableLiveData<List<Object>> loadList() {
        if (null == liveData) {
            liveData = new MutableLiveData<>();
            loadData(liveData);
        }
        return liveData;
    }

    private void loadData(MutableLiveData<List<Object>> liveData) {
        Call<List<Object>> call = api.getList();
        notifyData(liveData, call);

    }

    private void notifyData(MutableLiveData<List<Object>> liveData, Call<List<Object>> call) {
        call.enqueue(new Callback<List<Object>>() {
            @Override
            public void onResponse(@NotNull Call<List<Object>> call, @NotNull Response<List<Object>> response) {

                if (response.code() == 200) {
                    if (response.body() != null && !response.body().isEmpty())
                        liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Object>> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}

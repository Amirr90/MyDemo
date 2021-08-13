package com.e.practise.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("gh/fawazahmed0/quran-api@1/fonts.json")
    Call<List<Object>> getList();
}

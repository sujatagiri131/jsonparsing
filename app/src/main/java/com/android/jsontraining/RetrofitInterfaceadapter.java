package com.android.jsontraining;

import com.android.jsontraining.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterfaceadapter {
    @GET("api.php")
    Call<List<Model>> getMenu();

}
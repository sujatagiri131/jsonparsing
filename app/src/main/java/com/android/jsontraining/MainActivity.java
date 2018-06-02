package com.android.jsontraining;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.jsontraining.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recycle);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading..........");
        progressDialog.setCancelable(false);
        progressDialog.show();
        getMenuJson();
    }
    public  void getMenuJson(){
        RetrofitInterfaceadapter  retrofitInterfaceadapter =RetrofitClitent.getRetrofit().create(RetrofitInterfaceadapter.class);
        Call<List<Model>>model=retrofitInterfaceadapter.getMenu();
        model.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> models = response.body();
                Recyclerviewadapter recyclerviewadapter=new Recyclerviewadapter(MainActivity.this,models);
               // Recyclerviewadapter recyclerviewadapter =new Recyclerviewadapter(MainActivity.this,response.body());
              //  RecyclerView.LayoutManager layoutManager =new GridLayoutManager(MainActivity.this,2);
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(horizontalLayoutManager);
                recyclerView.setHasFixedSize(true);
               // recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(recyclerviewadapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerviewadapter.notifyDataSetChanged();
                if (progressDialog.isShowing()
                        ) {
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}

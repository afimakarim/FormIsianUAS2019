package com.afimakarim.formisianuas2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.afimakarim.formisianuas2019.model.DataItem;
import com.afimakarim.formisianuas2019.model.ResponseUas;
import com.afimakarim.formisianuas2019.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilActivity extends AppCompatActivity {
    List<DataItem> data = new ArrayList<>();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        recycler = findViewById(R.id.recycleview);

        getDataUas();

        recycler.setAdapter(new UasAdapter(TampilActivity.this,data));
        recycler.setLayoutManager(new LinearLayoutManager(TampilActivity.this));
    }

    private void getDataUas() {
        final ProgressDialog progress = new ProgressDialog(TampilActivity.this);
        progress.setMessage("waiting...");
        progress.show();

        Call<ResponseUas> request = RetrofitConfig.getApiService().ambilData();
        request.enqueue(new Callback<ResponseUas>() {
            @Override
            public void onResponse(Call<ResponseUas> call, Response<ResponseUas> response) {
                progress.dismiss();
                if (response.isSuccessful()){
                    data = response.body().getData();
                    recycler.setAdapter(new UasAdapter(TampilActivity.this,data));
                } else {
                    Toast.makeText(TampilActivity.this, "Request not success",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUas> call, Throwable t) {

            }
        });
    }
}

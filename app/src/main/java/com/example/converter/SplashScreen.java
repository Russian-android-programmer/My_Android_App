package com.example.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.converter.Setters.CurrentValuteCurs;
import com.example.converter.api.CBApi;
import com.example.converter.models.ValCurs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CBApi.getInstance().getCurrentValuteCurs().enqueue(new Callback<ValCurs>() {
            @Override
            public void onResponse(Call<ValCurs> call, Response<ValCurs> response) {
                CurrentValuteCurs.setCurrentValuteCurs(response.body());
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<ValCurs> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Нет подключения к интернету", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

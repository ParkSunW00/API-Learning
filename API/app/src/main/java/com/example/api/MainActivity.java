package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sma-student.run.goorm.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApplicationService applicationService = retrofit.create(ApplicationService.class);

        applicationService.getData(20402).enqueue(new Callback<ResponseBody>() {
            //서버와 통신에 성공했을 때
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String message = response.body().string();
                    textView.setText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //서버와 통신에 실패했을 때
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
package com.example.retrofitpractice;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

      Call<OurMainDaataaClass> call =  ourRetrofitClient.getData("IptNrMu0cOh1wqTqdpHpaiY8f6oRoCXOAla2YfGCAYIPvPT0U0VGbHuAacji");


      call.enqueue(new Callback<OurMainDaataaClass>() {
          @Override
          public void onResponse(Call<OurMainDaataaClass> call, Response<OurMainDaataaClass> response) {

              if (response.isSuccessful()){

             List<ObjectDataClass> list=     response.body().getData();

             for (ObjectDataClass objectDataClass: list){

                 Log.d("id", String.valueOf(objectDataClass.getId()));
                 Log.d("name", String.valueOf(objectDataClass.getName()));
                 Log.d("resource", String.valueOf(objectDataClass.getResource()));
                 Log.d("updated_at", String.valueOf(objectDataClass.getUpdated_at()));
             }
              }else {
                  Log.d("response","fail");
              }

          }

          @Override
          public void onFailure(Call<OurMainDaataaClass> call, Throwable t) {

              Log.d("response","fail");
          }
      });
    }


}
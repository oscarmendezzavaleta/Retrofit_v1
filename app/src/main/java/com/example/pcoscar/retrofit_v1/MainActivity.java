package com.example.pcoscar.retrofit_v1;

import android.os.AsyncTask;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Peticion().execute();



    }

    //https://jarroba.com/multitarea-e-hilos-facil-y-muchas-ventajas/
    //https://www.youtube.com/watch?v=xYTgLP7dc_s
    //https://www.youtube.com/watch?v=OGBELKqlOsw
//http://www.vogella.com/tutorials/Retrofit/article.html
/*
    Una clase final no puede ser extendida por ninguna otra clase
    Una variable final no puede reasignarse a otro valor
    Un método final no puede ser anulado
    */


    public static class Peticion extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void...voids){

          final String url="https://androidtutorials.herokuapp.com/";

            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            servicesTutorial service=retrofit.create(servicesTutorial.class);

            Call<List<ResponSeservice>> response=service.getUsersGet();
            try{
                for(ResponSeservice user: response.execute().body())
                    Log.e("Respuesta;",user.getName()+ " " + user.getNickName());
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;

        }
    }
}

package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient extends ViewModel {

    private MutableLiveData<List<postmodel>> heroList;

    public LiveData<List<postmodel>> getHeroes() {
        //if the list is null 
        if (heroList == null) {
            heroList = new MutableLiveData<List<postmodel>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }

    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface api = retrofit.create(Apiinterface.class);
        Call<List<postmodel>> call = api.getPosts();


        call.enqueue(new Callback<List<postmodel>>() {
            @Override
            public void onResponse(Call<List<postmodel>> call, Response<List<postmodel>> response) {

                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<postmodel>> call, Throwable t) {

            }
        });
    }

}

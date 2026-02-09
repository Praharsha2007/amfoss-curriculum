package com.melofi.task_08

import com.melofi.task_08.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance { //Only one object is created. So entire app will use the same retrofit instance.
    private const val BASE_URL = "http://10.254.251.182:5000/"

    val api: ApiService by lazy { //The api will not be created immediately. It will be done only the first time it is accessed and after that it is saved in the memory.
        Retrofit.Builder() //Starts building the retrofit instance
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Tells retrofit to use gson to convert the json format into kotlin objects and vice verse
            .build() //Finalises and builds the final instance.
            .create(ApiService::class.java) //Reads the ApiService interface and reads get and post and stuff.
    }
}

//How Register works?
//So when the user inputs the credentials, the response object is created with the username, password. To convert them into the json format data classes are the medium used. They are then converted into json format and are sent to the flask backend. There it then creates a user object and stores it in the sqlite database.
//Data classes are required so that retrofit knows` how to map it.
package com.example.modul11.api

import com.example.modul11.model.Photo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {
    //memasukkan link API
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi

    //mengunakan retrofit
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    //method get yang return hasil data dari API
    fun getPhotos(): Single<List<Photo>> {
        return api.getPhotos()
    }
}
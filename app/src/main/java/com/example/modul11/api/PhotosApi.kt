package com.example.modul11.api

import com.example.modul11.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    //memasukkan fungsi get retrofit ke fungsi
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}
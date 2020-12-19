package com.example.modul11.model

import com.google.gson.annotations.SerializedName

//sebagai model data pada aplikasi yang berasal dari API
data class Photo(
    //untuk menyamakan nama model dengan yg ada di API
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnailUrl")
    val thumbnail: String
)
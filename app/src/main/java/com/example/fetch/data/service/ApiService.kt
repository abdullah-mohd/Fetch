package com.example.fetch.data.service

import com.example.fetch.data.model.ItemResponse
import retrofit2.http.GET

interface ApiService {

    @GET("hiring.json")
    suspend fun getItems(): List<ItemResponse>

}
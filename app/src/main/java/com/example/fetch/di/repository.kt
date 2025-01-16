package com.example.fetch.di

import com.example.fetch.data.repository.ItemRepositoryImpl
import com.example.fetch.data.service.ApiService

fun getItemRepository(apiService: ApiService) = ItemRepositoryImpl(apiService)
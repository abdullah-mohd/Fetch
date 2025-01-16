package com.example.fetch.data.repository

import com.example.fetch.data.model.ItemResponse
import com.example.fetch.data.service.ApiService
import com.example.fetch.domain.model.Item
import com.example.fetch.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemRepositoryImpl (private val apiService: ApiService): ItemRepository {

    override suspend fun getItems(): List<ItemResponse> = apiService.getItems()

}